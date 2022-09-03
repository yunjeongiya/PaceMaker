package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.domain.Schedule;

import java.util.Optional;

public interface ScheduleRepository {
    //nullable
    Optional<ScheduleView> findScheduleToDisplay(String userId, Long courseId);

    Optional<Long> findActivatedScheduleId(String userId, Long courseId);

    //return scheduleId
    Long insert(Schedule schedule);

    void updateComment(Long scheduleId, String comment);
    void updateActivated(Long scheduleId, boolean activated);
}