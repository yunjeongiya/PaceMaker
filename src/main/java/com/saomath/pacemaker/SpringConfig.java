package com.saomath.pacemaker;
import com.saomath.pacemaker.repository.CourseRepository;
import com.saomath.pacemaker.repository.JdbcTemplateCourseRepo;
import com.saomath.pacemaker.repository.JdbcTemplateSubjectRepo;
import com.saomath.pacemaker.repository.SubjectRepository;
import com.saomath.pacemaker.service.CourseMapBuilder;
import com.saomath.pacemaker.service.CourseMapBuilderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public CourseMapBuilder courseMapBuilder() {
        return new CourseMapBuilderImpl(subjectRepository(), courseRepository());
    }

    @Bean
    public SubjectRepository subjectRepository() {
        return new JdbcTemplateSubjectRepo(dataSource);
    }
    @Bean
    public CourseRepository courseRepository() {
        return new JdbcTemplateCourseRepo(dataSource);
    }

}
