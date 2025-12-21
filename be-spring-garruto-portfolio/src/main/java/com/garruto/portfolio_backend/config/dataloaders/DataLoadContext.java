package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.*;
import com.garruto.portfolio_backend.repository.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Context object that holds all repositories and shared entities
 * needed by the data loaders.
 */
@Getter
@Setter
public class DataLoadContext {

    // Repositories
    private PersonalInfoRepository personalInfoRepo;
    private CompanyRepository companyRepo;
    private WorkExperienceRepository workExpRepo;
    private EducationRepository educationRepo;
    private SkillCategoryRepository skillCategoryRepo;
    private TechnologyRepository technologyRepo;
    private PersonalTechProficiencyRepository proficiencyRepo;
    private PersonalLanguageRepository languageRepo;
    private WorkResponsibilityRepository responsibilityRepo;
    private WorkAchievementRepository achievementRepo;
    private WorkTechnologyRepository workTechnologyRepo;

    // Shared entities (populated by loaders and used by subsequent loaders)
    private PersonalInfo personalInfo;
    private Map<String, Company> companies = new HashMap<>();
    private Map<String, SkillCategory> skillCategories = new HashMap<>();
    private Map<String, Technology> technologies = new HashMap<>();
    private Map<String, WorkExperience> workExperiences = new HashMap<>();

    // Constructor with all repositories
    public DataLoadContext(
            PersonalInfoRepository personalInfoRepo,
            CompanyRepository companyRepo,
            WorkExperienceRepository workExpRepo,
            EducationRepository educationRepo,
            SkillCategoryRepository skillCategoryRepo,
            TechnologyRepository technologyRepo,
            PersonalTechProficiencyRepository proficiencyRepo,
            PersonalLanguageRepository languageRepo,
            WorkResponsibilityRepository responsibilityRepo,
            WorkAchievementRepository achievementRepo,
            WorkTechnologyRepository workTechnologyRepo
    ) {
        this.personalInfoRepo = personalInfoRepo;
        this.companyRepo = companyRepo;
        this.workExpRepo = workExpRepo;
        this.educationRepo = educationRepo;
        this.skillCategoryRepo = skillCategoryRepo;
        this.technologyRepo = technologyRepo;
        this.proficiencyRepo = proficiencyRepo;
        this.languageRepo = languageRepo;
        this.responsibilityRepo = responsibilityRepo;
        this.achievementRepo = achievementRepo;
        this.workTechnologyRepo = workTechnologyRepo;
    }

    // Utility methods
    public void addCompany(String key, Company company) {
        companies.put(key, company);
    }

    public Company getCompany(String key) {
        return companies.get(key);
    }

    public void addSkillCategory(String key, SkillCategory category) {
        skillCategories.put(key, category);
    }

    public SkillCategory getSkillCategory(String key) {
        return skillCategories.get(key);
    }

    public void addTechnology(String key, Technology technology) {
        technologies.put(key, technology);
    }

    public Technology getTechnology(String key) {
        return technologies.get(key);
    }

    public void addWorkExperience(String key, WorkExperience workExperience) {
        workExperiences.put(key, workExperience);
    }

    public WorkExperience getWorkExperience(String key) {
        return workExperiences.get(key);
    }
}