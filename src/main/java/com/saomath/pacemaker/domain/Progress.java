package com.saomath.pacemaker.domain;

import lombok.Getter;

@Getter
public class Progress {
    private Long id;
    private Long scheduleId;
    private Long lectureId;
    private boolean done = false;

    public Progress(Long scheduleId, Long lectureId) {
        this.scheduleId = scheduleId;
        this.lectureId = lectureId;
    }
}