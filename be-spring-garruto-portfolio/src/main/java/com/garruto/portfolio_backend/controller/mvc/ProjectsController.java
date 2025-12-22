package com.garruto.portfolio_backend.controller.mvc;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/projects")
public class ProjectsController {

    @GetMapping
    public String projects() {
        log.info("Rendering projects page");
        return "projects/projects-home";
    }

    @GetMapping("/project1")
    public String project1() {
        return "projects/project1/project1";
    }

    @GetMapping("/project2")
    public String project2() {
        return "projects/project2/project2";
    }

    @GetMapping("/project3")
    public String project3() {
        return "projects/project3/project3";
    }
}
