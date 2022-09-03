package com.saomath.pacemaker.controller;

import com.saomath.pacemaker.service.CourseMapBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MakeScheduleController extends BaseController {

    public MakeScheduleController(CourseMapBuilder courseMapBuilder) {
        super(courseMapBuilder);
    }

    @GetMapping("/makeSchedule")
    public String content(@RequestParam("courseId") Long courseId, @RequestParam("courseTitle") String courseTitle, Model model) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseTitle", courseTitle);
        return "views/makeSchedule";
    }
}