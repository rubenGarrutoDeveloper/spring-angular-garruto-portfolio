package com.garruto.portfolio_backend.controller.rest;

import com.garruto.portfolio_backend.entity.PersonalLanguage;
import com.garruto.portfolio_backend.service.PersonalLanguageService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal-language")
public class PersonalLanguageController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalLanguageController.class);
    private final PersonalLanguageService service;

    public PersonalLanguageController(PersonalLanguageService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonalLanguage> getAll() {
        logger.info("Fetching all PersonalLanguage");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonalLanguage getById(@PathVariable Long id) {
        logger.info("Fetching PersonalLanguage with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("PersonalLanguage not found with id " + id));
    }
}