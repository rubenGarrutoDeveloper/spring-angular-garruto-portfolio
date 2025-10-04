package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.Company;
import com.garruto.portfolio_backend.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository repository;
    public CompanyService(CompanyRepository repository) { this.repository = repository; }
    public List<Company> findAll() { return repository.findAll(); }
    public Optional<Company> findById(Long id) { return repository.findById(id); }
    public Company save(Company entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}