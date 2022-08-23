package com.saomath.pacemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class showPlanController {
    @GetMapping("/showPlan")
    public String content() {
        return "views/showPlan";
    }
}