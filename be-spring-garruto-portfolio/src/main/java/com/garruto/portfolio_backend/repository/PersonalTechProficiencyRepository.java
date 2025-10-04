package com.garruto.portfolio_backend.repository;

import com.garruto.portfolio_backend.entity.PersonalTechProficiency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTechProficiencyRepository extends JpaRepository<PersonalTechProficiency, Long> {
}