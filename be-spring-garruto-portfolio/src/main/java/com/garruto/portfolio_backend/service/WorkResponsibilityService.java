package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.WorkResponsibility;
import com.garruto.portfolio_backend.repository.WorkResponsibilityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkResponsibilityService {
    private final WorkResponsibilityRepository repository;
    public WorkResponsibilityService(WorkResponsibilityRepository repository) { this.repository = repository; }
    public List<WorkResponsibility> findAll() { return repository.findAll(); }
    public Optional<WorkResponsibility> findById(Long id) { return repository.findById(id); }
    public WorkResponsibility save(WorkResponsibility entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}