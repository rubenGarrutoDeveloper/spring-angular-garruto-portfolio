package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.Technology;
import com.garruto.portfolio_backend.service.TechnologyService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technology")
public class TechnologyController {

    private static final Logger logger = LoggerFactory.getLogger(TechnologyController.class);
    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Technology> getAll() {
        logger.info("Fetching all Technology");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Technology getById(@PathVariable Long id) {
        logger.info("Fetching Technology with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("Technology not found with id " + id));
    }
}