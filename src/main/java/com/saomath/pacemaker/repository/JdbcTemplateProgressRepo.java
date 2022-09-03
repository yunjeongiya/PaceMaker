package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ProgressWithLectureInfo;
import com.saomath.pacemaker.domain.Progress;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplateProgressRepo implements ProgressRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateProgressRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProgressWithLectureInfo> findWIthLectureInfoBySchedule(Long scheduleId) {
        return jdbcTemplate.query("select progress.id as progress_id, title, link, done from progress inner join lecture on progress.lecture_id = lecture.id where schedule_id = ?",
                (rs, rowNum) -> {
                    ProgressWithLectureInfo progressWithLectureInfo = new ProgressWithLectureInfo();
                    progressWithLectureInfo.setProgressId(rs.getLong("progress_id"));
                    progressWithLectureInfo.setTitle(rs.getString("title"));
                    progressWithLectureInfo.setLink(rs.getString("link"));
                    progressWithLectureInfo.setDone(rs.getBoolean("done"));
                    return progressWithLectureInfo;
                }, scheduleId);
    }

    @Override
    public Long insert(Progress progress) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("progress").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("schedule_id", progress.getScheduleId());
        parameters.put("lecture_id", progress.getLectureId());
        parameters.put("done", progress.isDone());
        return (Long) jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    }

    @Override
    public void updateDone(Long progressId, boolean done) {
        jdbcTemplate.update("update progress set done=? where id=?", done, progressId);
    }
}
