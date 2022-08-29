package com.saomath.pacemaker.controller;

import com.saomath.pacemaker.service.CourseMapBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController extends BaseController {

    public IndexController(CourseMapBuilder courseMapBuilder) {
        super(courseMapBuilder);
    }

    @GetMapping("/")
    public String content() {
        return "views/index";
    }
}
