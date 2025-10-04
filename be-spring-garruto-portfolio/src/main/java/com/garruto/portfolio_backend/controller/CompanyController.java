package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.entity.Company;
import com.garruto.portfolio_backend.service.CompanyService;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Company> getAll() {
        logger.info("Fetching all Company");
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable Long id) {
        logger.info("Fetching Company with id: {}", id);
        return service.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id " + id));
    }
}