package com.saomath.pacemaker.controller;

import com.saomath.pacemaker.service.CourseMapBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class singinController extends BaseController {
    public singinController(CourseMapBuilder courseMapBuilder) {
        super(courseMapBuilder);
    }

    @GetMapping("/login")
    public String content() {
        return "views/login";
    }
}
