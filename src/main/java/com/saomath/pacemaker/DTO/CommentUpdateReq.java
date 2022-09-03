package com.saomath.pacemaker.DTO;

import lombok.Data;

@Data
public class CommentUpdateReq {
    private Long scheduleId;
    private String comment;
}