package com.garruto.portfolio_backend.controller.rest;

import com.garruto.portfolio_backend.entity.SkillCategory;
import com.garruto.portfolio_backend.service.SkillCategoryService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/skillcategory")
public class SkillCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(SkillCategoryController.class);
    private final SkillCategoryService service;

    public SkillCategoryController(SkillCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<SkillCategory> getAll() {
        logger.info("Fetching all SkillCategory");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SkillCategory getById(@PathVariable Long id) {
        logger.info("Fetching SkillCategory with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("SkillCategory not found with id " + id));
    }
}