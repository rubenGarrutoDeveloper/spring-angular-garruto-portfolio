package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.PersonalLanguage;
import com.garruto.portfolio_backend.repository.PersonalLanguageRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalLanguageService {
    private final PersonalLanguageRepository repository;
    public PersonalLanguageService(PersonalLanguageRepository repository) { this.repository = repository; }
    public List<PersonalLanguage> findAll() { return repository.findAll(); }
    public Optional<PersonalLanguage> findById(Long id) { return repository.findById(id); }
    public PersonalLanguage save(PersonalLanguage entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}