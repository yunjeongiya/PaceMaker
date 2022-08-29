package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Subject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateSubjectRepo implements SubjectRepository {
    private final JdbcTemplate jdbcTemplate;


    public JdbcTemplateSubjectRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Subject> findAll() {
        return jdbcTemplate.query("select * from subject", subjectRowMapper());
    }

    private RowMapper<Subject> subjectRowMapper() {
        return (rs, rowNum) -> {
            Subject subject = new Subject();
            subject.setGrade(rs.getInt("grade"));
            subject.setName(rs.getString("name"));
            return subject;
        };
    }
}
