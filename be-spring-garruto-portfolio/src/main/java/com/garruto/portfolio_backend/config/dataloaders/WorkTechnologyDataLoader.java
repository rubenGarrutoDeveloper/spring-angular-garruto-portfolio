package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.WorkTechnology;
import org.springframework.stereotype.Component;

@Component
public class WorkTechnologyDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        // Reply Technologies
        associateTech(context, "REPLY", "ANGULAR");
        associateTech(context, "REPLY", "SPRING_BOOT");
        associateTech(context, "REPLY", "JAVA");
        associateTech(context, "REPLY", "ORACLE_DATABASE");
        associateTech(context, "REPLY", "INTERSYSTEMS_CACHÉ_IRIS");
        associateTech(context, "REPLY", "GLASSFISH_PAYARA");
        associateTech(context, "REPLY", "DOCKER");
        associateTech(context, "REPLY", "RESTFUL_API");
        associateTech(context, "REPLY", "SOAP_API");
        associateTech(context, "REPLY", "HL7");
        associateTech(context, "REPLY", "GIT");
        associateTech(context, "REPLY", "BITBUCKET");
        associateTech(context, "REPLY", "JIRA");

        // Rextart Technologies
        associateTech(context, "REXTART", "JAVA_EE");
        associateTech(context, "REXTART", "JAVA");
        associateTech(context, "REXTART", "PRIMEFACES");
        associateTech(context, "REXTART", "JSF");
        associateTech(context, "REXTART", "ORACLE_DATABASE");
        associateTech(context, "REXTART", "SQL");
        associateTech(context, "REXTART", "JBOSS");
        associateTech(context, "REXTART", "JASPER_REPORTS");
        associateTech(context, "REXTART", "GIT");

        // Accenture Stage Technologies
        associateTech(context, "ACCENTURE_STAGE", "JAVA");
        associateTech(context, "ACCENTURE_STAGE", "SPRING_BOOT");
        associateTech(context, "ACCENTURE_STAGE", "SQL_SERVER");
        associateTech(context, "ACCENTURE_STAGE", "MONGODB");
        associateTech(context, "ACCENTURE_STAGE", "BITBUCKET");
        associateTech(context, "ACCENTURE_STAGE", "JIRA");

        // Accenture Training Technologies
        associateTech(context, "ACCENTURE_TRAINING", "JAVA");
        associateTech(context, "ACCENTURE_TRAINING", "SPRING_BOOT");
        associateTech(context, "ACCENTURE_TRAINING", "SQL");
        associateTech(context, "ACCENTURE_TRAINING", "PL_SQL");
        associateTech(context, "ACCENTURE_TRAINING", "ORACLE_DATABASE");
        associateTech(context, "ACCENTURE_TRAINING", "HTML5");
        associateTech(context, "ACCENTURE_TRAINING", "CSS3");
        associateTech(context, "ACCENTURE_TRAINING", "JAVASCRIPT");

        // Metropark Technologies
        associateTech(context, "METROPARK", "AUTOCAD");
        associateTech(context, "METROPARK", "MATLAB");
        associateTech(context, "METROPARK", "PRIMUS");

        System.out.println("✅ Work-Technology associations loaded");
    }

    private void associateTech(DataLoadContext context, String workExpKey, String techKey) {
        WorkTechnology wt = WorkTechnology.builder()
                .workExperience(context.getWorkExperience(workExpKey))
                .technology(context.getTechnology(techKey))
                .build();
        context.getWorkTechnologyRepo().save(wt);
    }

    @Override
    public int getOrder() {
        return 7;
    }

    @Override
    public String getName() {
        return "WorkTechnologyDataLoader";
    }
}