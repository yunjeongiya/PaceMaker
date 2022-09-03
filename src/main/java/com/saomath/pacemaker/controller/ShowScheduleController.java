package com.saomath.pacemaker.controller;
import com.saomath.pacemaker.DTO.CommentUpdateReq;
import com.saomath.pacemaker.DTO.DoneUpdateReq;
import com.saomath.pacemaker.DTO.ScheduleView;
import com.saomath.pacemaker.repository.ProgressRepository;
import com.saomath.pacemaker.repository.ScheduleRepository;
import com.saomath.pacemaker.service.CourseMapBuilder;
import com.saomath.pacemaker.service.ScheduleViewBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ShowScheduleController extends BaseController{
    private final ScheduleViewBuilder scheduleViewBuilder;
    private final ScheduleRepository scheduleRepository;
    private final ProgressRepository progressRepository;

    @Autowired
    public ShowScheduleController(CourseMapBuilder courseMapBuilder, ScheduleViewBuilder scheduleViewBuilder, ScheduleRepository scheduleRepository, ProgressRepository progressRepository) {
        super(courseMapBuilder);
        this.scheduleViewBuilder = scheduleViewBuilder;
        this.scheduleRepository = scheduleRepository;
        this.progressRepository = progressRepository;
    }

    @GetMapping("/showSchedule")
    public String content(@RequestParam("courseId") Long courseId, @RequestParam("courseTitle") String courseTitle, Model model) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseTitle", courseTitle);
        String userId = "test";
        Optional<ScheduleView> scheduleView = scheduleViewBuilder.buildScheduleView(userId, courseId);
        if(scheduleView.isPresent()) {;
            model.addAttribute("scheduleView", scheduleView.get());
            return "views/showSchedule";
        }
        else return "views/noSchedule";
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    @ResponseBody
    public CommentUpdateReq updateComment(CommentUpdateReq commentUpdateReq){
        scheduleRepository.updateComment(commentUpdateReq.getScheduleId(), commentUpdateReq.getComment());
        return commentUpdateReq;
    }

    @RequestMapping(value = "/updateDone", method = RequestMethod.POST)
    @ResponseBody
    public DoneUpdateReq updateDone(DoneUpdateReq doneUpdateReq){
        progressRepository.updateDone(doneUpdateReq.getProgressId(), doneUpdateReq.isDone());
        return doneUpdateReq;
    }
}