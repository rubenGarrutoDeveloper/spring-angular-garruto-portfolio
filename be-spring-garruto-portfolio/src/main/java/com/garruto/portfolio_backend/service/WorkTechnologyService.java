package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.WorkTechnology;
import com.garruto.portfolio_backend.repository.WorkTechnologyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkTechnologyService {
    private final WorkTechnologyRepository repository;
    public WorkTechnologyService(WorkTechnologyRepository repository) { this.repository = repository; }
    public List<WorkTechnology> findAll() { return repository.findAll(); }
    public Optional<WorkTechnology> findById(Long id) { return repository.findById(id); }
    public WorkTechnology save(WorkTechnology entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}