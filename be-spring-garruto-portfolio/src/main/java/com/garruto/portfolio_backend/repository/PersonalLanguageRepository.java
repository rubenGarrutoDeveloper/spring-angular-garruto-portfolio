package com.garruto.portfolio_backend.repository;

import com.garruto.portfolio_backend.entity.PersonalLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalLanguageRepository extends JpaRepository<PersonalLanguage, Long> {
}