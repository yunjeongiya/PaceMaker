package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> findBySubject(String subject);
}
