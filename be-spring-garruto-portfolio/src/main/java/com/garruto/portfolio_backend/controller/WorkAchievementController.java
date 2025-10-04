package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.WorkAchievement;
import com.garruto.portfolio_backend.service.WorkAchievementService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/work-achievement")
public class WorkAchievementController {

    private static final Logger logger = LoggerFactory.getLogger(WorkAchievementController.class);
    private final WorkAchievementService service;

    public WorkAchievementController(WorkAchievementService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkAchievement> getAll() {
        logger.info("Fetching all WorkAchievement");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkAchievement getById(@PathVariable Long id) {
        logger.info("Fetching WorkAchievement with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("WorkAchievement not found with id " + id));
    }
}