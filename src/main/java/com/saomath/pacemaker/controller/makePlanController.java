package com.saomath.pacemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class makePlanController {
    @GetMapping("/makePlan")
    public String content() {
        return "views/makePlan";
    }
}