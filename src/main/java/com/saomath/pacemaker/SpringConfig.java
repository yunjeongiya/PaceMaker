package com.saomath.pacemaker;
import com.saomath.pacemaker.repository.*;
import com.saomath.pacemaker.service.*;
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

    //Service
    @Bean
    public CourseMapBuilder courseMapBuilder() { return new CourseMapBuilderImpl(subjectRepository(), courseRepository()); }
    @Bean
    public ScheduleViewBuilder scheduleViewBuilder() { return new ScheduleViewBuilderImpl(scheduleRepository(), progressRepository()); }
    @Bean
    public ScheduleBuilder scheduleBuilder() { return new ScheduleBuilderImpl(lectureRepository(), scheduleRepository(), progressRepository()); }

    //Repository
    @Bean
    public SubjectRepository subjectRepository() {
        return new JdbcTemplateSubjectRepo(dataSource);
    }
    @Bean
    public CourseRepository courseRepository() {
        return new JdbcTemplateCourseRepo(dataSource);
    }
    @Bean
    public ScheduleRepository scheduleRepository() { return new JdbcTemplateScheduleRepo(dataSource); }
    @Bean
    public ProgressRepository progressRepository() { return new JdbcTemplateProgressRepo(dataSource); }
    @Bean
    public LectureRepository lectureRepository() {return new JdbcTemplateLectureRepo(dataSource); }

}
