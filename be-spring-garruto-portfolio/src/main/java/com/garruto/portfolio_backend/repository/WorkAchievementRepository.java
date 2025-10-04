package com.garruto.portfolio_backend.repository;

import com.garruto.portfolio_backend.entity.WorkAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkAchievementRepository extends JpaRepository<WorkAchievement, Long> {
}