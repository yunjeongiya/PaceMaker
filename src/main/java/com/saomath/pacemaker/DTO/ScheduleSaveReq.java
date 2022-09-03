package com.saomath.pacemaker.DTO;

import com.saomath.pacemaker.domain.Lecture;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ScheduleSaveReq {
    Long courseId;
    String userId;
    LocalDate startDate;
    List<Lecture> lectureList;
}
