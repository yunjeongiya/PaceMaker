package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.domain.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateScheduleRepo implements ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRepo(DataSource dataSource) {
       jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ScheduleView> findScheduleToDisplay(Long userId, Long courseId) {
        return null;
    }

    @Override
    public Long findActivatedId(Long userId, Long courseId) {
        return null;
    }

    @Override
    public Long insert(Schedule schedule) {
        return null;
    }

    @Override
    public void updateComment(Long scheduleId, String Comment) {

    }

    @Override
    public void updateActivated(Long scheduleId, boolean activated) {

    }
}
