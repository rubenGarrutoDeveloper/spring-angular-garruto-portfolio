package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.PersonalInfo;
import com.garruto.portfolio_backend.service.PersonalInfoService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personal-info")
public class PersonalInfoController {

    private static final Logger logger = LoggerFactory.getLogger(PersonalInfoController.class);
    private final PersonalInfoService service;

    public PersonalInfoController(PersonalInfoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonalInfo> getAll() {
        logger.info("Fetching all PersonalInfo");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonalInfo getById(@PathVariable Long id) {
        logger.info("Fetching PersonalInfo with id: {}", id);
        return service.findById(id)
                      .orElseThrow(() -> new RuntimeException("PersonalInfo not found with id " + id));
    }
}