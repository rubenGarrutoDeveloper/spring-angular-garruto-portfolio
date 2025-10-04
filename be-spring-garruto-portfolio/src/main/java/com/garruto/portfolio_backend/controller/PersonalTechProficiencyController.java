package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.PersonalTechProficiency;
import com.garruto.portfolio_backend.service.PersonalTechProficiencyService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal-tech-proficiency")
public class PersonalTechProficiencyController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalTechProficiencyController.class);
    private final PersonalTechProficiencyService service;

    public PersonalTechProficiencyController(PersonalTechProficiencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonalTechProficiency> getAll() {
        logger.info("Fetching all PersonalTechProficiency");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonalTechProficiency getById(@PathVariable Long id) {
        logger.info("Fetching PersonalTechProficiency with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("PersonalTechProficiency not found with id " + id));
    }
}