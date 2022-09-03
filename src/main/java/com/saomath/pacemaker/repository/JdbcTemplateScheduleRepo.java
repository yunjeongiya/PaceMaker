package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.domain.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplateScheduleRepo implements ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepo(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<ScheduleView> findScheduleToDisplay(String userId, Long courseId) {
        List<ScheduleView> result = jdbcTemplate.query("select id, start_date, comment from schedule where user_id=? and course_id=? and activated=true",
                (rs, rowNum) -> {
                    ScheduleView scheduleView = new ScheduleView();
                    scheduleView.setScheduleId(rs.getLong("id"));
                    LocalDate startDate = rs.getDate("start_date").toLocalDate();
                    scheduleView.setStartDate(startDate.toString());
                    scheduleView.setEndDate(startDate.plusWeeks(1).toString());
                    scheduleView.setComment(rs.getString("comment"));
                    return scheduleView;
                }, userId, courseId);
        return result.stream().findAny();
    }

    @Override
    public Long insert(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("user_id", schedule.getUserId());
        parameters.put("course_id", schedule.getCourseId());
        parameters.put("start_date", schedule.getStartDate());
        parameters.put("activated", schedule.isActivated());
        parameters.put("comment", schedule.getComment());
        return (Long) jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
    }

    @Override
    public void updateComment(Long scheduleId, String comment) {
        jdbcTemplate.update("update schedule set comment=? where id=?", comment, scheduleId);
    }

    @Override
    public void updateActivated(Long scheduleId, boolean activated) {
        jdbcTemplate.update("update schedule set activated=? where id=?", activated, scheduleId);
    }
}