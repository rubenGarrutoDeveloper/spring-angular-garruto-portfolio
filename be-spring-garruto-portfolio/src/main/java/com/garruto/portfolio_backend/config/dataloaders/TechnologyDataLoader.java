package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.Technology;
import org.springframework.stereotype.Component;

@Component
public class TechnologyDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        // PROGRAMMING LANGUAGES
        Technology java = createAndSave(context, "Java", "PROGRAMMING_LANGUAGES", "Linguaggio",
                "Linguaggio di programmazione principale per backend enterprise",
                "Main programming language for enterprise backend");

        Technology typescript = createAndSave(context, "TypeScript", "PROGRAMMING_LANGUAGES", "Linguaggio",
                "Superset tipizzato di JavaScript per sviluppo frontend",
                "Typed superset of JavaScript for frontend development");

        Technology sql = createAndSave(context, "SQL", "PROGRAMMING_LANGUAGES", "Linguaggio",
                "Linguaggio di query per database relazionali",
                "Query language for relational databases");

        Technology plsql = createAndSave(context, "PL/SQL", "PROGRAMMING_LANGUAGES", "Linguaggio",
                "Linguaggio procedurale Oracle per stored procedures",
                "Oracle procedural language for stored procedures");

        // BACKEND
        Technology springBoot = createAndSave(context, "Spring Boot", "BACKEND", "Framework",
                "Framework Java per applicazioni enterprise",
                "Java framework for enterprise applications");

        Technology springMvc = createAndSave(context, "Spring MVC", "BACKEND", "Framework",
                "Framework Spring per applicazioni web MVC",
                "Spring framework for MVC web applications");

        Technology springDataJpa = createAndSave(context, "Spring Data JPA", "BACKEND", "Framework",
                "Astrazione Spring per accesso ai dati con JPA",
                "Spring abstraction for data access with JPA");

        Technology springSecurity = createAndSave(context, "Spring Security", "BACKEND", "Framework",
                "Framework Spring per autenticazione e autorizzazione",
                "Spring framework for authentication and authorization");

        Technology springBatch = createAndSave(context, "Spring Batch", "BACKEND", "Framework",
                "Framework Spring per processi batch",
                "Spring framework for batch processes");

        Technology hibernate = createAndSave(context, "Hibernate/JPA", "BACKEND", "Framework",
                "ORM per mapping oggetti-relazionale",
                "ORM for object-relational mapping");

        Technology restApi = createAndSave(context, "RESTful API", "BACKEND", "Tecnologia",
                "Architettura per servizi web REST",
                "Architecture for REST web services");

        Technology soapApi = createAndSave(context, "SOAP API", "BACKEND", "Tecnologia",
                "Protocollo per servizi web enterprise",
                "Protocol for enterprise web services");

        Technology javaEe = createAndSave(context, "Java EE", "BACKEND", "Framework",
                "Java Enterprise Edition per applicazioni enterprise",
                "Java Enterprise Edition for enterprise applications");

        // FRONTEND
        Technology angular = createAndSave(context, "Angular", "FRONTEND", "Framework",
                "Framework frontend per Single Page Applications",
                "Frontend framework for Single Page Applications");

        Technology primefaces = createAndSave(context, "PrimeFaces", "FRONTEND", "Framework",
                "Libreria componenti JSF per interfacce ricche",
                "JSF component library for rich interfaces");

        Technology bootstrap = createAndSave(context, "Bootstrap", "FRONTEND", "Framework",
                "Framework CSS per design responsive",
                "CSS framework for responsive design");

        Technology html5 = createAndSave(context, "HTML5", "FRONTEND", "Linguaggio",
                "Linguaggio markup per struttura pagine web",
                "Markup language for web page structure");

        Technology css3 = createAndSave(context, "CSS3", "FRONTEND", "Linguaggio",
                "Linguaggio stili per presentazione pagine web",
                "Style language for web page presentation");

        Technology javascript = createAndSave(context, "JavaScript", "FRONTEND", "Linguaggio",
                "Linguaggio di scripting per web interattivo",
                "Scripting language for interactive web");

        Technology jsf = createAndSave(context, "JSF", "FRONTEND", "Framework",
                "JavaServer Faces per UI component-based",
                "JavaServer Faces for component-based UI");

        // DATABASE
        Technology oracle = createAndSave(context, "Oracle Database", "DATABASE", "Database",
                "Database relazionale enterprise di Oracle",
                "Oracle enterprise relational database");

        Technology intersystems = createAndSave(context, "InterSystems Caché/IRIS", "DATABASE", "Database",
                "Database post-relazionale ad alte prestazioni",
                "High-performance post-relational database");

        Technology mysql = createAndSave(context, "MySQL", "DATABASE", "Database",
                "Database relazionale open source",
                "Open source relational database");

        Technology postgresql = createAndSave(context, "PostgreSQL", "DATABASE", "Database",
                "Database relazionale open source avanzato",
                "Advanced open source relational database");

        Technology mongodb = createAndSave(context, "MongoDB", "DATABASE", "Database",
                "Database NoSQL document-oriented",
                "NoSQL document-oriented database");

        Technology sqlServer = createAndSave(context, "SQL Server", "DATABASE", "Database",
                "Database relazionale Microsoft",
                "Microsoft relational database");

        // TOOLS & DEVOPS
        Technology git = createAndSave(context, "Git", "TOOLS_DEVOPS", "Version Control",
                "Sistema di controllo versione distribuito",
                "Distributed version control system");

        Technology bitbucket = createAndSave(context, "Bitbucket", "TOOLS_DEVOPS", "Version Control",
                "Piattaforma Git per gestione repository",
                "Git platform for repository management");

        Technology sourcetree = createAndSave(context, "Sourcetree", "TOOLS_DEVOPS", "Version Control",
                "Client GUI per Git",
                "GUI client for Git");

        Technology maven = createAndSave(context, "Maven", "TOOLS_DEVOPS", "Build Tool",
                "Tool per gestione build e dipendenze Java",
                "Build and dependency management tool for Java");

        Technology jasperReports = createAndSave(context, "Jasper Reports", "TOOLS_DEVOPS", "Reporting",
                "Libreria per generazione report",
                "Library for report generation");

        Technology intellij = createAndSave(context, "IntelliJ IDEA", "TOOLS_DEVOPS", "IDE",
                "IDE per sviluppo Java",
                "IDE for Java development");

        Technology eclipse = createAndSave(context, "Eclipse", "TOOLS_DEVOPS", "IDE",
                "IDE open source per Java",
                "Open source IDE for Java");

        Technology vscode = createAndSave(context, "Visual Studio Code", "TOOLS_DEVOPS", "IDE",
                "Editor di codice leggero e versatile",
                "Lightweight and versatile code editor");

        Technology postman = createAndSave(context, "Postman", "TOOLS_DEVOPS", "Testing",
                "Tool per test API REST",
                "Tool for REST API testing");

        Technology bruno = createAndSave(context, "Bruno", "TOOLS_DEVOPS", "Testing",
                "Tool per test API REST",
                "Tool for REST API testing");

        Technology soapui = createAndSave(context, "SoapUI", "TOOLS_DEVOPS", "Testing",
                "Tool per test API SOAP",
                "Tool for SOAP API testing");

        Technology jira = createAndSave(context, "JIRA", "TOOLS_DEVOPS", "Project Management",
                "Tool per gestione progetti Agile",
                "Tool for Agile project management");

        Technology confluence = createAndSave(context, "Confluence", "TOOLS_DEVOPS", "Documentation",
                "Piattaforma per documentazione collaborativa",
                "Platform for collaborative documentation");

        Technology sqlDeveloper = createAndSave(context, "SQL Developer", "TOOLS_DEVOPS", "Database Tool",
                "IDE Oracle per database",
                "Oracle IDE for database");

        Technology dbeaver = createAndSave(context, "DBeaver", "TOOLS_DEVOPS", "Database Tool",
                "Client database universale",
                "Universal database client");

        Technology mysqlWorkbench = createAndSave(context, "MySQL Workbench", "TOOLS_DEVOPS", "Database Tool",
                "Tool per design e amministrazione MySQL",
                "Tool for MySQL design and administration");

        Technology docker = createAndSave(context, "Docker", "TOOLS_DEVOPS", "Containerization",
                "Piattaforma per containerizzazione applicazioni",
                "Platform for application containerization");

        Technology glassfish = createAndSave(context, "Glassfish/Payara", "TOOLS_DEVOPS", "Application Server",
                "Application server Java EE",
                "Java EE application server");

        Technology jboss = createAndSave(context, "JBoss", "TOOLS_DEVOPS", "Application Server",
                "Application server Java EE enterprise",
                "Enterprise Java EE application server");

        // OTHER SKILLS
        Technology hl7 = createAndSave(context, "HL7", "OTHER_SKILLS", "Standard",
                "Standard per interoperabilità sistemi sanitari",
                "Standard for healthcare system interoperability");

        Technology arduino = createAndSave(context, "Arduino", "OTHER_SKILLS", "IoT",
                "Piattaforma hardware per prototipazione elettronica",
                "Hardware platform for electronic prototyping");

        Technology esp8266 = createAndSave(context, "ESP8266", "OTHER_SKILLS", "IoT",
                "Microcontrollore WiFi per IoT",
                "WiFi microcontroller for IoT");

        Technology raspberryPi = createAndSave(context, "Raspberry Pi", "OTHER_SKILLS", "IoT",
                "Computer single-board per progetti IoT",
                "Single-board computer for IoT projects");

        Technology autocad = createAndSave(context, "AutoCAD", "OTHER_SKILLS", "Design",
                "Software per progettazione CAD",
                "CAD design software");

        Technology matlab = createAndSave(context, "MATLAB", "OTHER_SKILLS", "Engineering",
                "Software per calcolo numerico e ingegneria",
                "Software for numerical computing and engineering");

        Technology primus = createAndSave(context, "Primus", "OTHER_SKILLS", "Engineering",
                "Software per computi metrici",
                "Software for bill of quantities");

        System.out.println("✅ Technologies loaded (57 entries total)");
    }

    private Technology createAndSave(DataLoadContext context, String name, String categoryKey,
                                     String type, String descIt, String descEn) {
        Technology tech = Technology.builder()
                .name(name)
                .category(context.getSkillCategory(categoryKey))
                .type(type)
                .descriptionIt(descIt)
                .descriptionEn(descEn)
                .build();
        tech = context.getTechnologyRepo().save(tech);
        context.addTechnology(name.toUpperCase().replace(" ", "_").replace("/", "_"), tech);
        return tech;
    }

    @Override
    public int getOrder() {
        return 6;
    }

    @Override
    public String getName() {
        return "TechnologyDataLoader";
    }
}