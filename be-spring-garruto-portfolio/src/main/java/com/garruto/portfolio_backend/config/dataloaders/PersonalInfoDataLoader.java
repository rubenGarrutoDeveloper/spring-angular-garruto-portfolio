package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.PersonalInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonalInfoDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        PersonalInfo ruben = PersonalInfo.builder()
                .firstName("Ruben")
                .lastName("Garruto")
                .birthDate(LocalDate.of(1992, 11, 6))
                .professionalTitle("Full Stack Web Developer | 6+ anni di esperienza")
                .bioSummaryIt(
                        "Nel 2011 inizio la mia carriera universitaria nel campo dell'ingegneria Elettrica, " +
                                "laureandomi in magistrale presso il Politecnico di Milano. Durante l'ultimo periodo " +
                                "universitario sviluppo un crescente interesse per l'innovazione tecnologica, che mi porta a " +
                                "vincere una borsa di studio con Ferrovie dello Stato e in seguito ad essere selezionato " +
                                "per un corso intensivo di formazione in Digital Technologies presso Accenture, dove " +
                                "arricchisco la mia formazione elettrica con competenze trasversali nello sviluppo software. " +
                                "Dal 2019 lavoro come consulente full-stack, specializzandomi nello sviluppo di " +
                                "applicazioni web enterprise per processi aziendali complessi. Mi occupo dell'intero stack " +
                                "tecnologico: progettazione architetture database, sviluppo backend e design UI/UX, " +
                                "coprendo l'intero ciclo di vita del software dalla raccolta requisiti al deployment. " +
                                "La combinazione tra formazione ingegneristica e competenze software mi consente di " +
                                "tradurre esigenze di business complesse in architetture concrete ed efficienti, " +
                                "affrontando progetti dove l'integrazione tra sistemi eterogenei, la gestione di grandi volumi di " +
                                "dati e l'affidabilità delle soluzioni sono elementi critici."
                )
                .bioSummaryEn(
                        "In 2011, I began my university career in Electrical Engineering, " +
                                "completing my master's degree at Politecnico di Milano. During my final university period, " +
                                "I developed a growing interest in technological innovation, which led me to " +
                                "win a scholarship with Ferrovie dello Stato and subsequently be selected " +
                                "for an intensive training course in Digital Technologies at Accenture, where " +
                                "I enriched my electrical engineering background with cross-functional software development skills. " +
                                "Since 2019, I have been working as a full-stack consultant, specializing in the development of " +
                                "enterprise web applications for complex business processes. I handle the entire technology " +
                                "stack: database architecture design, backend development, and UI/UX design, " +
                                "covering the complete software lifecycle from requirements gathering to deployment. " +
                                "The combination of engineering training and software skills allows me to " +
                                "translate complex business needs into concrete and efficient architectures, " +
                                "tackling projects where integration between heterogeneous systems, management of large data volumes, " +
                                "and solution reliability are critical elements."
                )
                .email("ruben.garruto@gmail.com")
                .phone("+39 333 48 96 366")
                .linkedinUrl("https://www.linkedin.com/in/ruben-garruto")
                .githubUrl("https://github.com/rubenGarrutoDeveloper")
                .locationCity("Roma")
                .locationRegion("Lazio")
                .locationCountry("Italia")
                .build();

        ruben = context.getPersonalInfoRepo().save(ruben);
        context.setPersonalInfo(ruben);

        System.out.println("✅ Personal Info loaded");
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getName() {
        return "PersonalInfoDataLoader";
    }
}