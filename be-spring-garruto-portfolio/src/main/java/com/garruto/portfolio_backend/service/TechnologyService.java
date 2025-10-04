package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.Technology;
import com.garruto.portfolio_backend.repository.TechnologyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {
    private final TechnologyRepository repository;
    public TechnologyService(TechnologyRepository repository) { this.repository = repository; }
    public List<Technology> findAll() { return repository.findAll(); }
    public Optional<Technology> findById(Long id) { return repository.findById(id); }
    public Technology save(Technology entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}