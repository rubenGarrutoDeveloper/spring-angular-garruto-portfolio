package com.garruto.portfolio_backend.repository;

import com.garruto.portfolio_backend.entity.WorkTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTechnologyRepository extends JpaRepository<WorkTechnology, Long> {
}