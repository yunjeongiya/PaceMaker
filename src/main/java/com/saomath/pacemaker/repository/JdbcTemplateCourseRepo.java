package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateCourseRepo implements CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCourseRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Course> findBySubject(String subject) {
        return jdbcTemplate.query("select * from course where subject = ?", courseRowMapper(), subject);
    }

    private RowMapper<Course> courseRowMapper() {
        return (rs, rowNum) -> {
            Course course = new Course();
            course.setId(rs.getLong("id"));
            course.setSubject(rs.getString("subject"));
            course.setTitle(rs.getString("Title"));
            return course;
        };
    }
}
