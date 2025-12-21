package com.garruto.portfolio_backend.config;

import com.garruto.portfolio_backend.entity.*;
import com.garruto.portfolio_backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Profile("dev") // Solo in ambiente dev (H2)
public class DevDataLoader {

    private static final int startYear = 2019;

    @Bean
    CommandLineRunner loadData(
            PersonalInfoRepository personalInfoRepo,
            CompanyRepository companyRepo,
            WorkExperienceRepository workExpRepo,
            EducationRepository educationRepo,
            SkillCategoryRepository skillCategoryRepo,
            TechnologyRepository technologyRepo,
            PersonalTechProficiencyRepository proficiencyRepo,
            PersonalLanguageRepository languageRepo,
            WorkResponsibilityRepository responsibilityRepo,
            WorkAchievementRepository achievementRepo
    ) {
        return args -> {
            System.out.println("🚀 Loading test data into H2 database...");

            // 1. Personal Info
            PersonalInfo ruben = PersonalInfo.builder()
                    .firstName("Ruben")
                    .lastName("Garruto")
                    .birthDate(LocalDate.of(1992, 11, 6))
                    .professionalTitle("Full Stack Web Developer")
                    .bioSummaryIt(
                            "Sviluppatore Full Stack con " + getYearsOfExperiencePlaceholder() +
                                    " anni di esperienza in applicazioni web enterprise. " +
                                    "Specializzato in Java Spring e Angular."
                    )
                    .bioSummaryEn(
                            "Full Stack Developer with" + getYearsOfExperiencePlaceholder() + " " +
                                    " years of experience in enterprise web applications. Specialized in Java Spring and Angular.")
                    .email("ruben.garruto@gmail.com")
                    .phone("+39 333 48 96 366")
                    .linkedinUrl("https://www.linkedin.com/in/ruben-garruto")
                    .githubUrl("https://github.com/rubengarruto")
                    .locationCity("Roma")
                    .locationRegion("Lazio")
                    .locationCountry("Italia")
                    .build();
            personalInfoRepo.save(ruben);

            // 2. Education
            Education bachelor = Education.builder()
                    .personalInfo(ruben)
                    .institutionName("Politecnico di Milano")
                    .institutionLocation("Milano, Italia")
                    .degreeType("Laurea Triennale")
                    .fieldOfStudy("Ingegneria Elettrica")
                    .startDate(LocalDate.of(2011, 10, 1))
                    .endDate(LocalDate.of(2016, 9, 30))
                    .grade("85")
                    .gradeMax("110")
                    .thesisTitleIt("Esempio di impianto di rigassificazione LNG con adozione di turbina a gas interregriferata")
                    .thesisTitleEn("Example of LNG regasification plant with intercooled gas turbine adoption")
                    .displayOrder(1)
                    .build();

            Education master = Education.builder()
                    .personalInfo(ruben)
                    .institutionName("Politecnico di Milano")
                    .institutionLocation("Milano, Italia")
                    .degreeType("Laurea Magistrale")
                    .fieldOfStudy("Ingegneria Elettrica")
                    .startDate(LocalDate.of(2016, 10, 1))
                    .endDate(LocalDate.of(2019, 7, 31))
                    .grade("92")
                    .gradeMax("110")
                    .thesisTitleIt("CONNECTING PARKS TO THE SMART GRID: A Vehicle-to-Grid feasibility study")
                    .thesisTitleEn("CONNECTING PARKS TO THE SMART GRID: A Vehicle-to-Grid feasibility study")
                    .displayOrder(2)
                    .build();

            educationRepo.save(bachelor);
            educationRepo.save(master);

            // 3. Companies
            Company reply = Company.builder()
                    .name("Reply")
                    .sector("Sanitario")
                    .location("Milano, Italia")
                    .websiteUrl("https://www.reply.com")
                    .build();

            Company rextart = Company.builder()
                    .name("Rextart")
                    .sector("Telecomunicazioni")
                    .location("Roma, Italia")
                    .websiteUrl("https://www.rextart.com")
                    .build();

            Company accenture = Company.builder()
                    .name("Accenture")
                    .sector("Energetico")
                    .location("Milano, Italia")
                    .websiteUrl("https://www.accenture.com")
                    .build();

            companyRepo.save(reply);
            companyRepo.save(rextart);
            companyRepo.save(accenture);

            // 4. Work Experience - Reply
            WorkExperience replyWork = WorkExperience.builder()
                    .personalInfo(ruben)
                    .company(reply)
                    .jobTitle("Full Stack Web Developer")
                    .employmentType("Consulente")
                    .startDate(LocalDate.of(2023, 9, 1))
                    .isCurrent(true)
                    .descriptionIt("Progettazione e sviluppo di applicazione web enterprise per la gestione integrata dei processi sanitari")
                    .descriptionEn("Design and development of enterprise web application for integrated healthcare process management")
                    .displayOrder(1)
                    .build();
            workExpRepo.save(replyWork);

            // Responsibilities
            WorkResponsibility resp1 = WorkResponsibility.builder()
                    .workExperience(replyWork)
                    .descriptionIt("Sviluppo full-stack: front-end Angular, back-end Java Spring e integrazione dati")
                    .descriptionEn("Full-stack development: Angular front-end, Java Spring back-end and data integration")
                    .displayOrder(1)
                    .build();

            WorkResponsibility resp2 = WorkResponsibility.builder()
                    .workExperience(replyWork)
                    .descriptionIt("Implementazione di logiche di business per automazione dei workflow sanitari")
                    .descriptionEn("Implementation of business logic for healthcare workflow automation")
                    .displayOrder(2)
                    .build();

            responsibilityRepo.save(resp1);
            responsibilityRepo.save(resp2);

            // 5. Work Experience - Rextart
            WorkExperience rextartWork = WorkExperience.builder()
                    .personalInfo(ruben)
                    .company(rextart)
                    .jobTitle("Full Stack Web Developer")
                    .employmentType("Apprendistato")
                    .startDate(LocalDate.of(2019, 11, 1))
                    .endDate(LocalDate.of(2023, 8, 31))
                    .isCurrent(false)
                    .descriptionIt("Sviluppo di applicazione web enterprise per gestione e automazione dei processi di collaudo delle Stazioni Radio")
                    .descriptionEn("Development of enterprise web application for management and automation of Radio Station testing processes")
                    .displayOrder(2)
                    .build();
            workExpRepo.save(rextartWork);

            // Achievement
            WorkAchievement ach1 = WorkAchievement.builder()
                    .workExperience(rextartWork)
                    .descriptionIt("Implementazione di un sistema di versionamento dei dati delle antenne")
                    .descriptionEn("Implementation of an antenna data versioning system")
                    .displayOrder(1)
                    .build();

            achievementRepo.save(ach1);

            // 6. Skill Categories
            SkillCategory backend = SkillCategory.builder()
                    .nameIt("Backend")
                    .nameEn("Backend")
                    .code("BACKEND")
                    .iconClass("fa-server")
                    .displayOrder(1)
                    .build();

            SkillCategory frontend = SkillCategory.builder()
                    .nameIt("Frontend")
                    .nameEn("Frontend")
                    .code("FRONTEND")
                    .iconClass("fa-laptop-code")
                    .displayOrder(2)
                    .build();

            SkillCategory database = SkillCategory.builder()
                    .nameIt("Database")
                    .nameEn("Database")
                    .code("DATABASE")
                    .iconClass("fa-database")
                    .displayOrder(3)
                    .build();

            skillCategoryRepo.save(backend);
            skillCategoryRepo.save(frontend);
            skillCategoryRepo.save(database);

            // 7. Technologies
            Technology java = Technology.builder()
                    .name("Java")
                    .category(backend)
                    .type("Linguaggio")
                    .descriptionIt("Linguaggio di programmazione principale")
                    .descriptionEn("Main programming language")
                    .build();

            Technology spring = Technology.builder()
                    .name("Spring Boot")
                    .category(backend)
                    .type("Framework")
                    .descriptionIt("Framework per applicazioni enterprise")
                    .descriptionEn("Framework for enterprise applications")
                    .build();

            Technology angular = Technology.builder()
                    .name("Angular")
                    .category(frontend)
                    .type("Framework")
                    .descriptionIt("Framework frontend per SPA")
                    .descriptionEn("Frontend framework for SPA")
                    .build();

            Technology postgresql = Technology.builder()
                    .name("PostgreSQL")
                    .category(database)
                    .type("Database")
                    .descriptionIt("Database relazionale")
                    .descriptionEn("Relational database")
                    .build();

            technologyRepo.save(java);
            technologyRepo.save(spring);
            technologyRepo.save(angular);
            technologyRepo.save(postgresql);

            // 8. Personal Tech Proficiency
            PersonalTechProficiency javaProficiency = PersonalTechProficiency.builder()
                    .personalInfo(ruben)
                    .technology(java)
                    .proficiencyLevel("Avanzato")
                    .yearsOfExperience(new BigDecimal("6.0"))
                    .isFeatured(true)
                    .displayOrder(1)
                    .build();

            PersonalTechProficiency springProficiency = PersonalTechProficiency.builder()
                    .personalInfo(ruben)
                    .technology(spring)
                    .proficiencyLevel("Avanzato")
                    .yearsOfExperience(new BigDecimal("5.0"))
                    .isFeatured(true)
                    .displayOrder(2)
                    .build();

            proficiencyRepo.save(javaProficiency);
            proficiencyRepo.save(springProficiency);

            // 9. Languages
            PersonalLanguage italian = PersonalLanguage.builder()
                    .personalInfo(ruben)
                    .languageNameIt("Italiano")
                    .languageNameEn("Italian")
                    .proficiencyLevel("Madrelingua")
                    .isNative(true)
                    .displayOrder(1)
                    .build();

            PersonalLanguage english = PersonalLanguage.builder()
                    .personalInfo(ruben)
                    .languageNameIt("Inglese")
                    .languageNameEn("English")
                    .proficiencyLevel("B2")
                    .isNative(false)
                    .certificateName("TOEIC")
                    .certificateScore("825")
                    .certificateMaxScore("990")
                    .displayOrder(2)
                    .build();

            languageRepo.save(italian);
            languageRepo.save(english);

            System.out.println("✅ Test data loaded successfully!");
        };
    }

    private static String getYearsOfExperiencePlaceholder() {
        int currentYear = java.time.Year.now().getValue();
        int years = currentYear - startYear;
        return years + "+";
    }
}