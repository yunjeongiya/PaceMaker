package com.saomath.pacemaker.domain;

import lombok.Getter;

@Getter
public class Progress {
    private Long id;
    private Long scheduleId;
    private Long lectureId;
    private boolean done = false;

    public Progress(Long planId, Long lectureId) {
        this.scheduleId = planId;
        this.lectureId = lectureId;
    }
}