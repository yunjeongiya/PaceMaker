package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Lecture;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateLectureRepo implements LectureRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateLectureRepo(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Lecture> findSchedulingResource(String userId, Long courseId) {
        return jdbcTemplate.query("select * from lecture where course_id = ? and id not in " +
                "(select lecture_id from schedule inner join progress on schedule.id=progress.schedule_id where schedule.user_id = ? and schedule.course_id = ? and done = true)",
                lectureRowMapper(), courseId, userId, courseId );
    }

    private RowMapper<Lecture> lectureRowMapper() {
        return (rs, rowNum) -> {
            Lecture lecture = new Lecture();
            lecture.setId(rs.getLong("id"));
            lecture.setTitle(rs.getString("title"));
            lecture.setCourseId(rs.getLong("course_id"));
            lecture.setLink(rs.getString("link"));
            lecture.setWeight(rs.getInt("weight"));
            return lecture;
        };
    }
}
