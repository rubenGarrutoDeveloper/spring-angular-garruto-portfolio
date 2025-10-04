package com.garruto.portfolio_backend.service;

import com.garruto.portfolio_backend.entity.PersonalInfo;
import com.garruto.portfolio_backend.repository.PersonalInfoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalInfoService {
    private final PersonalInfoRepository repository;
    public PersonalInfoService(PersonalInfoRepository repository) { this.repository = repository; }
    public List<PersonalInfo> findAll() { return repository.findAll(); }
    public Optional<PersonalInfo> findById(Long id) { return repository.findById(id); }
    public PersonalInfo save(PersonalInfo entity) { return repository.save(entity); }
    public void deleteById(Long id) { repository.deleteById(id); }
}