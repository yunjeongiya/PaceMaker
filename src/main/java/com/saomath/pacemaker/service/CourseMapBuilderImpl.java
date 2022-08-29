package com.saomath.pacemaker.service;

import com.saomath.pacemaker.domain.Course;
import com.saomath.pacemaker.domain.Subject;
import com.saomath.pacemaker.repository.CourseRepository;
import com.saomath.pacemaker.repository.SubjectRepository;

import java.util.*;

public class CourseMapBuilderImpl implements CourseMapBuilder{
    private final CourseRepository courseRepository;
    private final SubjectRepository subjectRepository;
    public CourseMapBuilderImpl(SubjectRepository subjectRepository, CourseRepository courseRepository){
        this.subjectRepository = subjectRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Map<Subject, List<Course>> buildCourseMap() {
        List<Subject> subjectList = subjectRepository.findAll();
        subjectList.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                if(o1.getGrade()>o2.getGrade()) return 1;
                else if(o1.getGrade()==o2.getGrade())
                    return o1.getName().compareTo(o2.getName());
                else return -1;
            }
        });
        Map<Subject, List<Course>> courseMap = new LinkedHashMap<>();
        for(Subject subject:subjectList) {
            List<Course> courseList = courseRepository.findBySubject(subject.getName());
            courseList.sort(new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            courseMap.put(subject, courseList);
        }
        return courseMap;
    }
}
