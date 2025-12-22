package com.garruto.portfolio_backend.controller.rest;

import com.garruto.portfolio_backend.entity.WorkResponsibility;
import com.garruto.portfolio_backend.service.WorkResponsibilityService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work-responsibility")
public class WorkResponsibilityController {

    private static final Logger logger = LoggerFactory.getLogger(WorkResponsibilityController.class);
    private final WorkResponsibilityService service;

    public WorkResponsibilityController(WorkResponsibilityService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkResponsibility> getAll() {
        logger.info("Fetching all WorkResponsibility");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkResponsibility getById(@PathVariable Long id) {
        logger.info("Fetching WorkResponsibility with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("WorkResponsibility not found with id " + id));
    }
}