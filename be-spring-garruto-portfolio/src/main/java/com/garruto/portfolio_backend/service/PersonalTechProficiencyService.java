package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.PersonalTechProficiency;
import com.garruto.portfolio_backend.repository.PersonalTechProficiencyRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalTechProficiencyService {
    private final PersonalTechProficiencyRepository repository;
    public PersonalTechProficiencyService(PersonalTechProficiencyRepository repository) { this.repository = repository; }
    public List<PersonalTechProficiency> findAll() { return repository.findAll(); }
    public Optional<PersonalTechProficiency> findById(Long id) { return repository.findById(id); }
    public PersonalTechProficiency save(PersonalTechProficiency entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}