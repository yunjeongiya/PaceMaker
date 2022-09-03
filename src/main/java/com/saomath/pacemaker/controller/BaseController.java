package com.saomath.pacemaker.controller;

import com.saomath.pacemaker.domain.Course;
import com.saomath.pacemaker.domain.Subject;
import com.saomath.pacemaker.service.CourseMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Component
public abstract class BaseController {
    private final CourseMapBuilder courseMapBuilder;

    @Autowired
    public BaseController(CourseMapBuilder courseMapBuilder) {
        this.courseMapBuilder = courseMapBuilder;
    }

    @ModelAttribute(name = "subjectToCourseMap")
    public Map<Subject, List<Course>> returnCourseMap() {
        return courseMapBuilder.buildCourseMap();
        //나머지도 이름 다 subjectToCourseMap으로 바꿔야할지...
    }
}