package com.saomath.pacemaker.DTO;

import lombok.Data;

@Data
public class ProgressWithLectureInfo {
    private Long progressId;
    private String title;
    private String link;
    private boolean done;
}
