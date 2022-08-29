package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.domain.Schedule;

import java.util.List;

public interface ScheduleRepository {
    List<ScheduleView> findScheduleToDisplay(Long userId, Long courseId);

    //return null or activatedScheduleId
    Long findActivatedId(Long userId, Long courseId);

    //return scheduleId
    Long insert(Schedule schedule);

    void updateComment(Long scheduleId, String Comment);
    void updateActivated(Long scheduleId, boolean activated);
}
