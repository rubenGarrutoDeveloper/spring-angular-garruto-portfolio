package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.Education;
import com.garruto.portfolio_backend.service.EducationService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private static final Logger logger = LoggerFactory.getLogger(EducationController.class);
    private final EducationService service;

    public EducationController(EducationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Education> getAll() {
        logger.info("Fetching all Education");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Education getById(@PathVariable Long id) {
        logger.info("Fetching Education with id: {}", id);
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found with id " + id));
    }
}