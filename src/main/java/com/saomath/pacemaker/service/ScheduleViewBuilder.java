package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleView;

import java.util.Optional;

public interface ScheduleViewBuilder {
    Optional<ScheduleView> buildScheduleView(String userId, Long courseId);
}
