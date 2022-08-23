package com.saomath.pacemaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class singinController {
    @GetMapping("/login")
    public String content() {
        return "views/login";
    }
}
