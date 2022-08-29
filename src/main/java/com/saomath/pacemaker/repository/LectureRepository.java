package com.saomath.pacemaker.repository;

import com.saomath.pacemaker.domain.Lecture;

import java.util.List;

public interface LectureRepository {
    List<Lecture> findSchedulingResource(Long courseId, Long userId);
}
