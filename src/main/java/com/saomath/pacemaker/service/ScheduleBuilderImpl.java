package com.saomath.pacemaker.service;

import com.saomath.pacemaker.DTO.ScheduleCandidate;
import com.saomath.pacemaker.DTO.ScheduleSaveReq;
import com.saomath.pacemaker.DTO.SchedulingReq;
import com.saomath.pacemaker.domain.Lecture;
import com.saomath.pacemaker.domain.Progress;
import com.saomath.pacemaker.domain.Schedule;
import com.saomath.pacemaker.repository.LectureRepository;
import com.saomath.pacemaker.repository.ProgressRepository;
import com.saomath.pacemaker.repository.ScheduleRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScheduleBuilderImpl implements ScheduleBuilder{
    private final LectureRepository lectureRepository;
    private final ScheduleRepository scheduleRepository;
    private final ProgressRepository progressRepository;

    public ScheduleBuilderImpl(LectureRepository lectureRepository, ScheduleRepository scheduleRepository, ProgressRepository progressRepository) {
        this.lectureRepository = lectureRepository;
        this.scheduleRepository = scheduleRepository;
        this.progressRepository = progressRepository;
    }

    @Override
    public ScheduleCandidate buildScheduleCandidate(String userId, Long courseId) {
        List<Lecture> schedulingResource = lectureRepository.findSchedulingResource(userId, courseId);
        SchedulingReq schedulingReq = new SchedulingReq();
        schedulingReq.setSchedulingResource(schedulingResource);
        schedulingReq.setPace(1);
        return scheduling(schedulingReq);
    }

    @Override
    public ScheduleCandidate scheduling(SchedulingReq schedulingReq) {
        List<Lecture> schedulingResource = schedulingReq.getSchedulingResource();
        int pace = schedulingReq.getPace();

        ScheduleCandidate scheduleCandidate = new ScheduleCandidate();
        scheduleCandidate.setSchedulingResource(schedulingResource);
        LocalDate today = LocalDate.now();
        scheduleCandidate.setStartLocalDate(today);
        scheduleCandidate.setStartDate(today.toString());
        scheduleCandidate.setEndDate(today.plusWeeks(1).toString());

        //pace: 일주일에 하는 개수
        double weightSum = 0;
        for(Lecture lecture : schedulingResource){
            weightSum += lecture.getWeight();
        }
        int d_day = (int) Math.ceil(weightSum / pace * 7);
        scheduleCandidate.setD_Day(d_day);
        scheduleCandidate.setCourseEndDate(today.plusDays(d_day).toString());

        List<Lecture> lectureListCandidate = new ArrayList<Lecture>();
        int scheduledWiehgtSum = 0;
        for(Lecture lecture : schedulingResource){
            scheduledWiehgtSum += lecture.getWeight();
            if(scheduledWiehgtSum > pace) break;
            lectureListCandidate.add(lecture);
        }

        scheduleCandidate.setLectureListCandidate(lectureListCandidate);
        return scheduleCandidate;
    }

    @Override @Transactional
    public void replaceSchedule(ScheduleSaveReq scheduleSaveReq) {
        Optional<Long> oldScheduleId = scheduleRepository.findActivatedScheduleId(scheduleSaveReq.getUserId(), scheduleSaveReq.getCourseId());
        if(oldScheduleId.isPresent()) {
            scheduleRepository.updateActivated(oldScheduleId.get(), false);
        }
        Schedule schedule = new Schedule(scheduleSaveReq.getUserId(), scheduleSaveReq.getCourseId());
        Long newScheduleId = scheduleRepository.insert(schedule);

        for(Lecture lecture : scheduleSaveReq.getLectureList()){
            Progress progress = new Progress(newScheduleId, lecture.getId());
            progressRepository.insert(progress);
        }
    }
}