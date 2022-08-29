package com.saomath.pacemaker.domain;

import lombok.Data;

@Data
public class Lecture {
    private Long id;
    private Long courseId;
    private String title;
    private String link = null;
    private int weight = 1;
}
