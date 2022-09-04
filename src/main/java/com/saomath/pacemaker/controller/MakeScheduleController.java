package com.saomath.pacemaker.controller;

import com.saomath.pacemaker.DTO.*;
import com.saomath.pacemaker.service.CourseMapBuilder;
import com.saomath.pacemaker.service.ScheduleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MakeScheduleController extends BaseController {
    private final ScheduleBuilder scheduleBuilder;

    @Autowired
    public MakeScheduleController(CourseMapBuilder courseMapBuilder, ScheduleBuilder scheduleBuilder) {
        super(courseMapBuilder);
        this.scheduleBuilder = scheduleBuilder;
    }

    @GetMapping("/makeSchedule")
    public String content(@RequestParam("courseId") Long courseId, @RequestParam("courseTitle") String courseTitle, Model model) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseTitle", courseTitle);
        String userId = "test";
        ScheduleCandidate scheduleCandidate = scheduleBuilder.buildScheduleCandidate(userId, courseId);
        model.addAttribute("scheduleCandidate", scheduleCandidate);
        return "views/makeSchedule";
    }

    @RequestMapping(value = "/regulatePace", method = RequestMethod.POST)
    public void regulatePace(SchedulingReq schedulingReq, Model model){
        ScheduleCandidate scheduleCandidate = scheduleBuilder.scheduling(schedulingReq);
        model.addAttribute("scheduleCandidate", scheduleCandidate);
    }

    @PostMapping("/replaceSchedule")
    public String replaceSchedule(ScheduleSaveReq scheduleSaveReq, Model model) {
        String userId = "test";
        scheduleSaveReq.setUserId(userId);
        scheduleBuilder.replaceSchedule(scheduleSaveReq);
        //model.addAttribute("courseId", scheduleSaveReq.getCourseId());
        //model.addAttribute("courseTitle", courseTitle);
        return "views/showSchedule";
    }
}