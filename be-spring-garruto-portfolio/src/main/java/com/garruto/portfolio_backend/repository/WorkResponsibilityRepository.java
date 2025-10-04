package com.garruto.portfolio_backend.repository;

import com.garruto.portfolio_backend.entity.WorkResponsibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkResponsibilityRepository extends JpaRepository<WorkResponsibility, Long> {
}