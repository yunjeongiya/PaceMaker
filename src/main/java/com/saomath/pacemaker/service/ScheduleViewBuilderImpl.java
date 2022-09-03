package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ProgressWithLectureInfo;
import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.repository.LectureRepository;
import com.saomath.pacemaker.repository.ProgressRepository;
import com.saomath.pacemaker.repository.ScheduleRepository;

import java.util.List;
import java.util.Optional;

public class ScheduleViewBuilderImpl implements ScheduleViewBuilder{
    private final ScheduleRepository scheduleRepository;
    private final ProgressRepository progressRepository;

    public ScheduleViewBuilderImpl(ScheduleRepository scheduleRepository, ProgressRepository progressRepository) {
        this.scheduleRepository = scheduleRepository;
        this.progressRepository = progressRepository;
    }

    @Override
    public Optional<ScheduleView> buildScheduleView(String userId, Long courseId) {
        Optional<ScheduleView> scheduleView = scheduleRepository.findScheduleToDisplay(userId, courseId);
        if(scheduleView.isPresent()) {
            ScheduleView result = scheduleView.get();
            List<ProgressWithLectureInfo> progressWithLectureInfoList = progressRepository.findWIthLectureInfoBySchedule(result.getScheduleId());
            result.setProgressWithLectureInfoList(progressWithLectureInfoList);
            return Optional.of(result);
        }
        else return Optional.empty();
    }
}