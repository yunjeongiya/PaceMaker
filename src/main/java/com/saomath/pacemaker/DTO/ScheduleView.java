package com.saomath.pacemaker.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduleView {
    private Long scheduleId;
    private String startDate;
    private String endDate;
    private List<ProgressWithLectureInfo> progressWithLectureInfoList;
    private String comment;
}