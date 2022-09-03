package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleCandidate;
import com.saomath.pacemaker.DTO.ScheduleSaveReq;
import com.saomath.pacemaker.DTO.SchedulingReq;
import com.saomath.pacemaker.domain.Lecture;

import java.util.List;

public interface ScheduleBuilder {
    ScheduleCandidate buildScheduleCandidate(String userId, Long courseId);
    ScheduleCandidate scheduling(SchedulingReq schedulingReq);
    void replaceSchedule(ScheduleSaveReq scheduleSaveReq);
}
