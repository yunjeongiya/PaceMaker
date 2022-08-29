package com.saomath.pacemaker.service;

import com.saomath.pacemaker.domain.Course;
import com.saomath.pacemaker.domain.Subject;

import java.util.List;
import java.util.Map;

public interface CourseMapBuilder {
    Map<Subject, List<Course>> buildCourseMap();
}
