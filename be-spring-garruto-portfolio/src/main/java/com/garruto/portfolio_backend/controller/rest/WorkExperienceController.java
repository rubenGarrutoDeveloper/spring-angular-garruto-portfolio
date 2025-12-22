package com.garruto.portfolio_backend.controller.rest;

import com.garruto.portfolio_backend.entity.WorkExperience;
import com.garruto.portfolio_backend.service.WorkExperienceService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work-experience")
public class WorkExperienceController {

    private static final Logger logger = LoggerFactory.getLogger(WorkExperienceController.class);
    private final WorkExperienceService service;

    public WorkExperienceController(WorkExperienceService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkExperience> getAll() {
        logger.info("Fetching all WorkExperience");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkExperience getById(@PathVariable Long id) {
        logger.info("Fetching WorkExperience with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("WorkExperience not found with id " + id));
    }
}