package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.WorkTechnology;
import com.garruto.portfolio_backend.service.WorkTechnologyService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/work-tech-nology")
public class WorkTechnologyController {

    private static final Logger logger = LoggerFactory.getLogger(WorkTechnologyController.class);
    private final WorkTechnologyService service;

    public WorkTechnologyController(WorkTechnologyService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkTechnology> getAll() {
        logger.info("Fetching all WorkTechnology");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkTechnology getById(@PathVariable Long id) {
        logger.info("Fetching WorkTechnology with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("WorkTechnology not found with id " + id));
    }
}