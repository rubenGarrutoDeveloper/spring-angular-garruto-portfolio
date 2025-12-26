package com.garruto.portfolio_backend.config;

import com.garruto.portfolio_backend.config.dataloaders.*;
import com.garruto.portfolio_backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

/**
 * Main data loader orchestrator for development and production environments.
 * Loads data ONLY if the database is empty (first run).
 * Coordinates the execution of all individual data loaders in the correct order.
 */
@Configuration
@Profile({"dev", "prod"})
public class DevDataLoader {

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
            WorkAchievementRepository achievementRepo,
            WorkTechnologyRepository workTechnologyRepo,
            List<DataLoader> dataLoaders // Spring will inject all DataLoader beans
    ) {
        return args -> {
            // Check if data already exists
            long personalInfoCount = personalInfoRepo.count();

            if (personalInfoCount > 0) {
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                System.out.println("ℹ️  Database already contains data - skipping data loading");
                System.out.println("📊 Found " + personalInfoCount + " personal info record(s)");
                System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                return;
            }

            System.out.println("🚀 Starting data loading process...");
            System.out.println("📦 Found " + dataLoaders.size() + " data loaders");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

            // Create context with all repositories
            DataLoadContext context = new DataLoadContext(
                    personalInfoRepo,
                    companyRepo,
                    workExpRepo,
                    educationRepo,
                    skillCategoryRepo,
                    technologyRepo,
                    proficiencyRepo,
                    languageRepo,
                    responsibilityRepo,
                    achievementRepo,
                    workTechnologyRepo
            );

            // Sort loaders by order
            dataLoaders.sort((a, b) -> Integer.compare(a.getOrder(), b.getOrder()));

            // Execute all loaders in order
            for (DataLoader loader : dataLoaders) {
                try {
                    System.out.println("\n📂 [" + loader.getOrder() + "] Loading: " + loader.getName());
                    loader.load(context);
                } catch (Exception e) {
                    System.err.println("❌ Error loading " + loader.getName() + ": " + e.getMessage());
                    e.printStackTrace();
                    throw new RuntimeException("Failed to load data from " + loader.getName(), e);
                }
            }

            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("✅ All data loaded successfully!");
            System.out.println("📊 Summary:");
            System.out.println("   - Personal Info: 1 entry");
            System.out.println("   - Education: 3 entries (High School + 2 Degrees)");
            System.out.println("   - Companies: 5 entries");
            System.out.println("   - Work Experiences: 6 entries");
            System.out.println("   - Skill Categories: 6 entries");
            System.out.println("   - Technologies: 57 entries");
            System.out.println("   - Work-Tech Associations: ~40 entries");
            System.out.println("   - Tech Proficiencies: 39 entries");
            System.out.println("   - Languages: 2 entries");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        };
    }
}