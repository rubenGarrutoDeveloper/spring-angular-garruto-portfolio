package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.SkillCategory;
import com.garruto.portfolio_backend.repository.SkillCategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkillCategoryService {
    private final SkillCategoryRepository repository;
    public SkillCategoryService(SkillCategoryRepository repository) { this.repository = repository; }
    public List<SkillCategory> findAll() { return repository.findAll(); }
    public Optional<SkillCategory> findById(Long id) { return repository.findById(id); }
    public SkillCategory save(SkillCategory entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}