package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.DTO.ProgressWithLectureInfo;
import com.saomath.pacemaker.domain.Progress;

import java.util.List;

public interface ProgressRepository {
    List<ProgressWithLectureInfo> findWIthLectureInfoBySchedule(Long scheduleId);

    //return progressId
    Long insert(Progress progress);

    void updateDone(Long progressId, boolean done);
}
