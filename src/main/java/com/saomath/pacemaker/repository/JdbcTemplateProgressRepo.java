package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ProgressWithLectureInfo;
import com.saomath.pacemaker.domain.Progress;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateProgressRepo implements ProgressRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateProgressRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProgressWithLectureInfo> findWIthLectureInfoBySchedule(Long scheduleId) {
        return null;
    }

    @Override
    public Long insert(Progress progress) {
        return null;
    }

    @Override
    public void updateDone(Long progressId, boolean done) {

    }
}
