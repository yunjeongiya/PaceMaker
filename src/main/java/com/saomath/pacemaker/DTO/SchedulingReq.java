package com.saomath.pacemaker.DTO;

import com.saomath.pacemaker.domain.Lecture;
import lombok.Data;

import java.util.List;

@Data
public class SchedulingReq {
    private int pace;
    private List<Lecture> schedulingResource;
}
