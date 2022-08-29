package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleCandidateRes;
import com.saomath.pacemaker.domain.Lecture;

import java.util.List;

public class ScheduleBuilderImpl implements ScheduleBuilder{
    @Override
    public List<Lecture> getSchedulingResource(Long courseId, Long userId) {
        return null;
    }

    @Override
    public ScheduleCandidateRes scheduling(List<Lecture> schedulingResource, int pace) {
        return null;
    }

    @Override
    public void replaceSchedule(Long userId, Long courseId, List<Long> lectureIdList) {

    }
}
