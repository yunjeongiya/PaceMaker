package com.saomath.pacemaker.domain;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Schedule {
    private Long id;
    private String userId;
    private Long courseId;
    private LocalDate startDate = LocalDate.now();
    private boolean activated = true;
    private String comment = null;

    public Schedule(String userId, Long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }
}