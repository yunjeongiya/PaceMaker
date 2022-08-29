package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleView;

public interface ScheduleViewBuilder {
    ScheduleView buildScheduleView(Long courseId, Long userId);
}
