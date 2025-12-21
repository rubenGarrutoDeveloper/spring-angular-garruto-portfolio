package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.PersonalTechProficiency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PersonalTechProficiencyDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        // Programming Languages
        createProficiency(context, "JAVA", "Avanzato", "6.0", true, 1);
        createProficiency(context, "TYPESCRIPT", "Intermedio", "4.0", true, 2);
        createProficiency(context, "SQL", "Intermedio", "6.0", false, 3);
        createProficiency(context, "PL_SQL", "Intermedio", "4.0", false, 4);

        // Backend
        createProficiency(context, "SPRING_BOOT", "Avanzato", "5.0", true, 5);
        createProficiency(context, "SPRING_MVC", "Avanzato", "5.0", true, 6);
        createProficiency(context, "SPRING_DATA_JPA", "Avanzato", "5.0", true, 7);
        createProficiency(context, "SPRING_SECURITY", "Avanzato", "4.0", false, 8);
        createProficiency(context, "SPRING_BATCH", "Avanzato", "3.0", false, 9);
        createProficiency(context, "HIBERNATE_JPA", "Avanzato", "5.0", true, 10);
        createProficiency(context, "RESTFUL_API", "Avanzato", "5.0", true, 11);
        createProficiency(context, "SOAP_API", "Intermedio", "3.0", false, 12);
        createProficiency(context, "JAVA_EE", "Intermedio", "4.0", false, 13);

        // Frontend
        createProficiency(context, "ANGULAR", "Intermedio", "4.0", true, 14);
        createProficiency(context, "PRIMEFACES", "Intermedio", "4.0", false, 15);
        createProficiency(context, "BOOTSTRAP", "Base", "3.0", false, 16);
        createProficiency(context, "HTML5", "Base", "6.0", false, 17);
        createProficiency(context, "CSS3", "Base", "6.0", false, 18);
        createProficiency(context, "JAVASCRIPT", "Base", "6.0", false, 19);
        createProficiency(context, "JSF", "Intermedio", "4.0", false, 20);

        // Databases
        createProficiency(context, "ORACLE_DATABASE", "Intermedio", "5.0", true, 21);
        createProficiency(context, "INTERSYSTEMS_CACHÉ_IRIS", "Intermedio", "1.5", false, 22);
        createProficiency(context, "MYSQL", "Intermedio", "4.0", false, 23);
        createProficiency(context, "POSTGRESQL", "Intermedio", "3.0", false, 24);
        createProficiency(context, "MONGODB", "Base", "1.0", false, 25);

        // Tools & DevOps (selected main ones)
        createProficiency(context, "GIT", "Avanzato", "6.0", true, 26);
        createProficiency(context, "BITBUCKET", "Avanzato", "5.0", false, 27);
        createProficiency(context, "MAVEN", "Avanzato", "5.0", false, 28);
        createProficiency(context, "JASPER_REPORTS", "Intermedio", "3.0", false, 29);
        createProficiency(context, "INTELLIJ_IDEA", "Avanzato", "6.0", false, 30);
        createProficiency(context, "ECLIPSE", "Intermedio", "4.0", false, 31);
        createProficiency(context, "VISUAL_STUDIO_CODE", "Avanzato", "5.0", false, 32);
        createProficiency(context, "POSTMAN", "Avanzato", "5.0", false, 33);
        createProficiency(context, "SOAPUI", "Intermedio", "3.0", false, 34);
        createProficiency(context, "JIRA", "Avanzato", "5.0", false, 35);
        createProficiency(context, "DOCKER", "Intermedio", "2.0", false, 36);

        // Other Skills
        createProficiency(context, "HL7", "Intermedio", "1.5", false, 37);
        createProficiency(context, "ARDUINO", "Base", "2.0", false, 38);
        createProficiency(context, "AUTOCAD", "Intermedio", "3.0", false, 39);

        System.out.println("✅ Personal Tech Proficiencies loaded (39 entries)");
    }

    private void createProficiency(DataLoadContext context, String techKey, String level,
                                   String years, boolean featured, int order) {
        PersonalTechProficiency prof = PersonalTechProficiency.builder()
                .personalInfo(context.getPersonalInfo())
                .technology(context.getTechnology(techKey))
                .proficiencyLevel(level)
                .yearsOfExperience(new BigDecimal(years))
                .isFeatured(featured)
                .displayOrder(order)
                .build();
        context.getProficiencyRepo().save(prof);
    }

    @Override
    public int getOrder() {
        return 8;
    }

    @Override
    public String getName() {
        return "PersonalTechProficiencyDataLoader";
    }
}