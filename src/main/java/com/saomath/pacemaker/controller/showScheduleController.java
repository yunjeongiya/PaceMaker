package com.saomath.pacemaker.controller;
import com.saomath.pacemaker.service.CourseMapBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class showScheduleController extends BaseController{

    public showScheduleController(CourseMapBuilder courseMapBuilder) {
        super(courseMapBuilder);
    }

    @GetMapping("/showSchedule")
    //public String content(@RequestParam("startDate") LocalDate startDate, Model model) {
    public String content(@RequestParam("courseId") Long courseId, @RequestParam("courseTitle") String courseTitle, Model model) {
        LocalDate startDate = LocalDate.now();
        model.addAttribute("courseId", courseId);
        model.addAttribute("courseTitle", courseTitle);
        model.addAttribute("startDate", startDate.toString());
        model.addAttribute("endDate", startDate.plusWeeks(1).toString());
        return "views/showSchedule";
    }
}