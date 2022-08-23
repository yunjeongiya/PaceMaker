package com.saomath.pacemaker.domain;

import java.time.LocalDate;

public class Plan {
    private double id;
    private String userId;
    private double courseId;
    private LocalDate startDate = LocalDate.now();
    private boolean state = true;
    private String comment = null;
}
