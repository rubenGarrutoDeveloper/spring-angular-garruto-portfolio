package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.WorkAchievement;
import com.garruto.portfolio_backend.entity.WorkExperience;
import com.garruto.portfolio_backend.entity.WorkResponsibility;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class WorkExperienceDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        // 1. Reply (tramite Rextart) - Settembre 2023 - Presente
        WorkExperience reply = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("REPLY"))
                .jobTitle("Full Stack Web Developer")
                .employmentType("Consulente (tramite Rextart)")
                .startDate(LocalDate.of(2023, 9, 1))
                .isCurrent(true)
                .descriptionIt("Progettazione e sviluppo di applicazione web enterprise per la gestione integrata dei processi sanitari, con focus su automazione e interoperabilità.")
                .descriptionEn("Design and development of enterprise web application for integrated healthcare process management, with focus on automation and interoperability.")
                .displayOrder(1)
                .build();
        reply = context.getWorkExpRepo().save(reply);
        context.addWorkExperience("REPLY", reply);

        // Reply - Responsibilities
        WorkResponsibility replyResp1 = WorkResponsibility.builder()
                .workExperience(reply)
                .descriptionIt("Sviluppo full-stack: front-end Angular, back-end Java Spring e integrazione dati")
                .descriptionEn("Full-stack development: Angular front-end, Java Spring back-end and data integration")
                .displayOrder(1)
                .build();

        WorkResponsibility replyResp2 = WorkResponsibility.builder()
                .workExperience(reply)
                .descriptionIt("Implementazione di logiche di business per automazione dei workflow sanitari")
                .descriptionEn("Implementation of business logic for healthcare workflow automation")
                .displayOrder(2)
                .build();

        WorkResponsibility replyResp3 = WorkResponsibility.builder()
                .workExperience(reply)
                .descriptionIt("Integrazione con sistemi HL7 per interoperabilità dei dati clinici")
                .descriptionEn("Integration with HL7 systems for clinical data interoperability")
                .displayOrder(3)
                .build();

        WorkResponsibility replyResp4 = WorkResponsibility.builder()
                .workExperience(reply)
                .descriptionIt("Sviluppo e manutenzione di API REST e SOAP per sistemi esterni")
                .descriptionEn("Development and maintenance of REST and SOAP APIs for external systems")
                .displayOrder(4)
                .build();

        context.getResponsibilityRepo().save(replyResp1);
        context.getResponsibilityRepo().save(replyResp2);
        context.getResponsibilityRepo().save(replyResp3);
        context.getResponsibilityRepo().save(replyResp4);

        // 2. Rextart - Novembre 2019 - Agosto 2023
        WorkExperience rextart = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("REXTART"))
                .jobTitle("Full Stack Web Developer")
                .employmentType("Apprendistato")
                .startDate(LocalDate.of(2019, 11, 1))
                .endDate(LocalDate.of(2023, 8, 31))
                .isCurrent(false)
                .descriptionIt("Sviluppo di applicazione web enterprise per gestione e automazione dei processi di collaudo delle Stazioni Radio, coprendo l'intero ciclo di sviluppo dall'UI al database.")
                .descriptionEn("Development of enterprise web application for management and automation of Radio Station testing processes, covering the entire development cycle from UI to database.")
                .displayOrder(2)
                .build();
        rextart = context.getWorkExpRepo().save(rextart);
        context.addWorkExperience("REXTART", rextart);

        // Rextart - Achievements
        WorkAchievement rextartAch1 = WorkAchievement.builder()
                .workExperience(rextart)
                .descriptionIt("Implementazione di un sistema di versionamento dei dati delle antenne")
                .descriptionEn("Implementation of an antenna data versioning system")
                .displayOrder(1)
                .build();

        WorkAchievement rextartAch2 = WorkAchievement.builder()
                .workExperience(rextart)
                .descriptionIt("Implementazione di un sistema dinamico di report tramite Jasper Reports")
                .descriptionEn("Implementation of a dynamic reporting system using Jasper Reports")
                .displayOrder(2)
                .build();

        WorkAchievement rextartAch3 = WorkAchievement.builder()
                .workExperience(rextart)
                .descriptionIt("Creazione di dashboard per monitoraggio avanzamento collaudi")
                .descriptionEn("Creation of dashboards for testing progress monitoring")
                .displayOrder(3)
                .build();

        WorkAchievement rextartAch4 = WorkAchievement.builder()
                .workExperience(rextart)
                .descriptionIt("Automatizzazione completa dei processi di collaudo, riducendo i tempi operativi")
                .descriptionEn("Complete automation of testing processes, reducing operational times")
                .displayOrder(4)
                .build();

        context.getAchievementRepo().save(rextartAch1);
        context.getAchievementRepo().save(rextartAch2);
        context.getAchievementRepo().save(rextartAch3);
        context.getAchievementRepo().save(rextartAch4);

        // Rextart - Responsibilities
        WorkResponsibility rextartResp1 = WorkResponsibility.builder()
                .workExperience(rextart)
                .descriptionIt("Sviluppo di interfacce utente JSF con componenti PrimeFaces")
                .descriptionEn("Development of JSF user interfaces with PrimeFaces components")
                .displayOrder(1)
                .build();

        WorkResponsibility rextartResp2 = WorkResponsibility.builder()
                .workExperience(rextart)
                .descriptionIt("Progettazione e implementazione delle logiche di business per automazione dei processi")
                .descriptionEn("Design and implementation of business logic for process automation")
                .displayOrder(2)
                .build();

        WorkResponsibility rextartResp3 = WorkResponsibility.builder()
                .workExperience(rextart)
                .descriptionIt("Creazione di report dettagliati e personalizzabili per analisi dei dati tecnici")
                .descriptionEn("Creation of detailed and customizable reports for technical data analysis")
                .displayOrder(3)
                .build();

        WorkResponsibility rextartResp4 = WorkResponsibility.builder()
                .workExperience(rextart)
                .descriptionIt("Deployment e configurazione delle applicazioni su JBoss")
                .descriptionEn("Deployment and configuration of applications on JBoss")
                .displayOrder(4)
                .build();

        context.getResponsibilityRepo().save(rextartResp1);
        context.getResponsibilityRepo().save(rextartResp2);
        context.getResponsibilityRepo().save(rextartResp3);
        context.getResponsibilityRepo().save(rextartResp4);

        // 3. Accenture - Stage - Agosto 2019 - Ottobre 2019
        WorkExperience accentureStage = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("ACCENTURE"))
                .jobTitle("Stage")
                .employmentType("Stage")
                .startDate(LocalDate.of(2019, 8, 1))
                .endDate(LocalDate.of(2019, 10, 31))
                .isCurrent(false)
                .descriptionIt("Sviluppo di microservizi web in ambiente Agile per azienda del settore energetico, acquisendo esperienza in architetture moderne e metodologie collaborative.")
                .descriptionEn("Development of web microservices in Agile environment for energy sector company, gaining experience in modern architectures and collaborative methodologies.")
                .displayOrder(3)
                .build();
        accentureStage = context.getWorkExpRepo().save(accentureStage);
        context.addWorkExperience("ACCENTURE_STAGE", accentureStage);

        // 4. Accenture - Technology Trainee Program - Giugno 2019 - Luglio 2019
        WorkExperience accentureTraining = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("ACCENTURE"))
                .jobTitle("Technology Trainee Program")
                .employmentType("Formazione")
                .startDate(LocalDate.of(2019, 6, 1))
                .endDate(LocalDate.of(2019, 7, 31))
                .isCurrent(false)
                .descriptionIt("Corso intensivo di formazione nelle principali tecnologie per il web development.")
                .descriptionEn("Intensive training course in main technologies for web development.")
                .displayOrder(4)
                .build();
        accentureTraining = context.getWorkExpRepo().save(accentureTraining);
        context.addWorkExperience("ACCENTURE_TRAINING", accentureTraining);

        // Accenture Training - Responsibilities
        WorkResponsibility accentureTrainResp1 = WorkResponsibility.builder()
                .workExperience(accentureTraining)
                .descriptionIt("Introduzione a: Java, JPA, JSP e Java Spring")
                .descriptionEn("Introduction to: Java, JPA, JSP and Java Spring")
                .displayOrder(1)
                .build();

        WorkResponsibility accentureTrainResp2 = WorkResponsibility.builder()
                .workExperience(accentureTraining)
                .descriptionIt("Introduzione a: SQL e PL/SQL con utilizzo di RDBM Oracle")
                .descriptionEn("Introduction to: SQL and PL/SQL with Oracle RDBMS")
                .displayOrder(2)
                .build();

        WorkResponsibility accentureTrainResp3 = WorkResponsibility.builder()
                .workExperience(accentureTraining)
                .descriptionIt("Introduzione a: HTML5/CSS3/XML")
                .descriptionEn("Introduction to: HTML5/CSS3/XML")
                .displayOrder(3)
                .build();

        WorkResponsibility accentureTrainResp4 = WorkResponsibility.builder()
                .workExperience(accentureTraining)
                .descriptionIt("Introduzione alla programmazione JavaScript")
                .descriptionEn("Introduction to JavaScript programming")
                .displayOrder(4)
                .build();

        WorkResponsibility accentureTrainResp5 = WorkResponsibility.builder()
                .workExperience(accentureTraining)
                .descriptionIt("Esempi di creazione di una Web-App")
                .descriptionEn("Examples of Web-App creation")
                .displayOrder(5)
                .build();

        context.getResponsibilityRepo().save(accentureTrainResp1);
        context.getResponsibilityRepo().save(accentureTrainResp2);
        context.getResponsibilityRepo().save(accentureTrainResp3);
        context.getResponsibilityRepo().save(accentureTrainResp4);
        context.getResponsibilityRepo().save(accentureTrainResp5);

        // 5. Metropark - Stage - Settembre 2018 - Marzo 2019
        WorkExperience metropark = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("METROPARK"))
                .jobTitle("Assistente Progettazione")
                .employmentType("Stage")
                .startDate(LocalDate.of(2018, 9, 1))
                .endDate(LocalDate.of(2019, 3, 31))
                .isCurrent(false)
                .descriptionIt("Stage di progettazione impianti elettrici e architettonici per parcheggi.")
                .descriptionEn("Internship in electrical and architectural design for parking facilities.")
                .displayOrder(5)
                .build();
        metropark = context.getWorkExpRepo().save(metropark);
        context.addWorkExperience("METROPARK", metropark);

        // Metropark - Responsibilities
        WorkResponsibility metroparkResp1 = WorkResponsibility.builder()
                .workExperience(metropark)
                .descriptionIt("Progettazione e dimensionamento degli impianti elettrici di diversi parcheggi del gruppo comprensivi dei relativi elaborati grafici in Autocad e stesura dei computi metrici")
                .descriptionEn("Design and sizing of electrical systems for various group parking facilities including related AutoCAD drawings and bill of quantities")
                .displayOrder(1)
                .build();

        WorkResponsibility metroparkResp2 = WorkResponsibility.builder()
                .workExperience(metropark)
                .descriptionIt("Progettazione e dimensionamento del sistema di TVCC, realizzazione schemi funzionali e relativi computi metrici")
                .descriptionEn("Design and sizing of CCTV system, creation of functional diagrams and related bill of quantities")
                .displayOrder(2)
                .build();

        WorkResponsibility metroparkResp3 = WorkResponsibility.builder()
                .workExperience(metropark)
                .descriptionIt("Progettazione architettonica ed impiantistica di un locale tecnico")
                .descriptionEn("Architectural and plant engineering design of a technical room")
                .displayOrder(3)
                .build();

        WorkResponsibility metroparkResp4 = WorkResponsibility.builder()
                .workExperience(metropark)
                .descriptionIt("Progettazione per la realizzazione di parcheggi adibiti alla ricarica dei veicoli elettrici")
                .descriptionEn("Design for the implementation of parking facilities for electric vehicle charging")
                .displayOrder(4)
                .build();

        context.getResponsibilityRepo().save(metroparkResp1);
        context.getResponsibilityRepo().save(metroparkResp2);
        context.getResponsibilityRepo().save(metroparkResp3);
        context.getResponsibilityRepo().save(metroparkResp4);

        // 6. Tutor Privato - Gennaio 2017 - Gennaio 2019
        WorkExperience tutor = WorkExperience.builder()
                .personalInfo(context.getPersonalInfo())
                .company(context.getCompany("SUPERPROF"))
                .jobTitle("Tutor Privato")
                .employmentType("Freelance")
                .startDate(LocalDate.of(2017, 1, 1))
                .endDate(LocalDate.of(2019, 1, 31))
                .isCurrent(false)
                .descriptionIt("Supporto didattico per studenti di scuole superiori in Elettrotecnica, Fisica, Matematica, con focus su metodologia di studio e approccio alla risoluzione di problemi complessi.")
                .descriptionEn("Educational support for high school students in Electrical Engineering, Physics, Mathematics, with focus on study methodology and approach to solving complex problems.")
                .displayOrder(6)
                .build();
        tutor = context.getWorkExpRepo().save(tutor);
        context.addWorkExperience("TUTOR", tutor);

        System.out.println("✅ Work Experiences loaded (6 entries with responsibilities and achievements)");
    }

    @Override
    public int getOrder() {
        return 4;
    }

    @Override
    public String getName() {
        return "WorkExperienceDataLoader";
    }
}