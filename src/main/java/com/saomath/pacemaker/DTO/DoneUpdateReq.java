package com.saomath.pacemaker.DTO;

import lombok.Data;

@Data
public class DoneUpdateReq {
    private long progressId;
    private boolean done;
}