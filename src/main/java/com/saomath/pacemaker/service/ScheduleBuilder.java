package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleCandidateRes;
import com.saomath.pacemaker.domain.Lecture;

import java.util.List;

public interface ScheduleBuilder {
    List<Lecture> getSchedulingResource(Long courseId, Long userId);
    ScheduleCandidateRes scheduling(List<Lecture> schedulingResource, int pace);
    void replaceSchedule(Long userId, Long courseId, List<Long> lectureIdList);
}
