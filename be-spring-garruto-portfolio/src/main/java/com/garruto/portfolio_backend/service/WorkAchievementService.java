package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.WorkAchievement;
import com.garruto.portfolio_backend.repository.WorkAchievementRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WorkAchievementService {
    private final WorkAchievementRepository repository;
    public WorkAchievementService(WorkAchievementRepository repository) { this.repository = repository; }
    public List<WorkAchievement> findAll() { return repository.findAll(); }
    public Optional<WorkAchievement> findById(Long id) { return repository.findById(id); }
    public WorkAchievement save(WorkAchievement entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}