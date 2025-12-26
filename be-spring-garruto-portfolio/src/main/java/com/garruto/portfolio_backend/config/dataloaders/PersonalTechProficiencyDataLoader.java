package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.PersonalTechProficiency;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PersonalTechProficiencyDataLoader implements DataLoader {

    int order = 1;
    @Override
    public void load(DataLoadContext context) {
        // Programming Languages

        createProficiency(context, "JAVA", "Avanzato", "6.0", false, order);
        createProficiency(context, "TYPESCRIPT", "Intermedio", "4.0", false, order);
        createProficiency(context, "SQL", "Intermedio", "6.0", false, order);
        createProficiency(context, "PL_SQL", "Intermedio", "4.0", false, order);

        // Backend
        createProficiency(context, "SPRING_BOOT", "Avanzato", "5.0", true, order);
        createProficiency(context, "SPRING_MVC", "Avanzato", "5.0", false, order);
        createProficiency(context, "SPRING_DATA_JPA", "Avanzato", "5.0", false, order);
        createProficiency(context, "SPRING_SECURITY", "Intermedio", "4.0", false, order);
        createProficiency(context, "SPRING_BATCH", "Intermedio", "3.0", false, order);
        createProficiency(context, "HIBERNATE_JPA", "Avanzato", "5.0", false, order);
        createProficiency(context, "RESTFUL_API", "Avanzato", "5.0", false, order);
        createProficiency(context, "SOAP_API", "Intermedio", "3.0", false, order);
        createProficiency(context, "JAVA_EE", "Intermedio", "4.0", false, order);

        // Frontend
        createProficiency(context, "ANGULAR", "Intermedio", "4.0", true, order);
        createProficiency(context, "PRIMEFACES", "Intermedio", "4.0", false, order);
        createProficiency(context, "BOOTSTRAP", "Base", "3.0", false, order);
        createProficiency(context, "HTML5", "Base", "6.0", false, order);
        createProficiency(context, "CSS3", "Base", "6.0", false, order);
        createProficiency(context, "JAVASCRIPT", "Base", "6.0", false, order);
        createProficiency(context, "JSF", "Intermedio", "4.0", false, order);

        // Databases
        createProficiency(context, "ORACLE_DATABASE", "Intermedio", "5.0", true, order);
        createProficiency(context, "INTERSYSTEMS_CACHÉ_IRIS", "Intermedio", "1.5", false, order);
        createProficiency(context, "MYSQL", "Intermedio", "4.0", false, order);
        createProficiency(context, "POSTGRESQL", "Intermedio", "3.0", true, order);
        createProficiency(context, "MONGODB", "Base", "1.0", false, order);

        // Tools & DevOps (selected main ones)
        createProficiency(context, "GIT", "Avanzato", "6.0", false, order);
        createProficiency(context, "BITBUCKET", "Avanzato", "5.0", false, order);
        createProficiency(context, "MAVEN", "Avanzato", "5.0", false, order);
        createProficiency(context, "JASPER_REPORTS", "Intermedio", "3.0", false, order);
        createProficiency(context, "INTELLIJ_IDEA", "Avanzato", "6.0", false, order);
        createProficiency(context, "ECLIPSE", "Intermedio", "4.0", false, order);
        createProficiency(context, "VISUAL_STUDIO_CODE", "Avanzato", "5.0", false, order);
        createProficiency(context, "POSTMAN", "Avanzato", "5.0", false, order);
        createProficiency(context, "BRUNO", "Avanzato", "5.0", false, order);
        createProficiency(context, "SOAPUI", "Intermedio", "3.0", false, order);
        createProficiency(context, "JIRA", "Avanzato", "5.0", false, order);
        createProficiency(context, "DOCKER", "Intermedio", "2.0", false, order);

        // Other Skills
        createProficiency(context, "HL7", "Intermedio", "1.5", false, order);
        createProficiency(context, "ARDUINO", "Base", "2.0", false, order);
        createProficiency(context, "AUTOCAD", "Intermedio", "3.0", false, order);

        System.out.println("Personal Tech Proficiencies loaded : " + order);
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

        order++;
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