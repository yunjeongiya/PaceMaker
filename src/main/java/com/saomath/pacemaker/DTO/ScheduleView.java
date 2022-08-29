package com.saomath.pacemaker.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduleView {
    private Long ScheduleId;
    private LocalDate startDate;
    private List<ProgressWithLectureInfo> progressWithLectureInfoList;
    private String comment;
}