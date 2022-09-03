package com.saomath.pacemaker.DTO;

import com.saomath.pacemaker.domain.Lecture;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduleCandidate {
    private LocalDate startLocalDate;
    private String startDate;
    private String endDate;
    private String courseEndDate;
    private int D_Day;
    private List<Lecture> schedulingResource;
    private List<Lecture> lectureListCandidate;
}
