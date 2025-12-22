package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.Education;
import com.garruto.portfolio_backend.repository.EducationRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    private final EducationRepository repository;
    public EducationService(EducationRepository repository) { this.repository = repository; }
    public List<Education> findAll() { return repository.findAll(); }

    public List<Education> findAllByOrderByStartDateDesc() { return repository.findAllByOrderByStartDateDesc(); }
    public Optional<Education> findById(Long id) { return repository.findById(id); }
    public Education save(Education entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}