package com.garruto.portfolio_backend.controller;

import com.garruto.portfolio_backend.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller per le view Thymeleaf (pagine HTML)
 * Separato dai REST controllers che espongono API JSON
 */
@Controller
@Slf4j
public class ViewController {

    private final PersonalInfoService personalInfoService;
    private final WorkExperienceService workExperienceService;
    private final EducationService educationService;
    private final SkillCategoryService skillCategoryService;
    private final PersonalTechProficiencyService proficiencyService;
    private final PersonalLanguageService languageService;
    private final CompanyService companyService;

    public ViewController(
            PersonalInfoService personalInfoService,
            WorkExperienceService workExperienceService,
            EducationService educationService,
            SkillCategoryService skillCategoryService,
            PersonalTechProficiencyService proficiencyService,
            PersonalLanguageService languageService,
            CompanyService companyService
    ) {
        this.personalInfoService = personalInfoService;
        this.workExperienceService = workExperienceService;
        this.educationService = educationService;
        this.skillCategoryService = skillCategoryService;
        this.proficiencyService = proficiencyService;
        this.languageService = languageService;
        this.companyService = companyService;
    }

    /**
     * Homepage - Pagina di landing
     * Route: GET /
     */
    @GetMapping("/")
    public String index(Model model) {
        log.info("Rendering homepage");

        // Recupera info personali per nome e titolo
        personalInfoService.findAll().stream()
                .findFirst()
                .ifPresent(personalInfo -> {
                    model.addAttribute("firstName", personalInfo.getFirstName());
                    model.addAttribute("lastName", personalInfo.getLastName());
                    model.addAttribute("professionalTitle", personalInfo.getProfessionalTitle());
                });

        return "index";
    }


    /**
     * About page - Chi sono
     * Route: GET /about
     */
    @GetMapping("/about")
    public String about(Model model) {
        log.info("Rendering about page");

        // Recupera tutte le info personali
        personalInfoService.findAll().stream()
                .findFirst()
                .ifPresent(personalInfo -> {
                    model.addAttribute("personalInfo", personalInfo);

                    // Aggiungi anche le lingue
                    model.addAttribute("languages", personalInfo.getLanguages());
                });

        return "about";
    }

    // Le altre route saranno aggiunte nelle iterazioni successive:

    // @GetMapping("/experience")
    // public String experience(Model model) { ... }

    // @GetMapping("/education")
    // public String education(Model model) { ... }

    // @GetMapping("/skills")
    // public String skills(Model model) { ... }

    // @GetMapping("/contact")
    // public String contact(Model model) { ... }
}