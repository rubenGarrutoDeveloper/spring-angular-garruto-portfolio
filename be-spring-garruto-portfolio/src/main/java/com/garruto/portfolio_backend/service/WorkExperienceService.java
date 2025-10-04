package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.WorkExperience;
import com.garruto.portfolio_backend.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {
    private final WorkExperienceRepository repository;
    public WorkExperienceService(WorkExperienceRepository repository) { this.repository = repository; }
    public List<WorkExperience> findAll() { return repository.findAll(); }
    public Optional<WorkExperience> findById(Long id) { return repository.findById(id); }
    public WorkExperience save(WorkExperience entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}