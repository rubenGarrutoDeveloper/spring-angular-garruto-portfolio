package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.Education;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EducationDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        // Liceo Scientifico
        Education highSchool = Education.builder()
                .personalInfo(context.getPersonalInfo())
                .institutionName("Liceo Scientifico 'G. Marconi'")
                .institutionLocation("Roma, Italia")
                .degreeType("Diploma")
                .fieldOfStudy("Liceo Scientifico")
                .startDate(LocalDate.of(2006, 9, 1))
                .endDate(LocalDate.of(2011, 7, 31))
                .grade("82")
                .gradeMax("100")
                .displayOrder(3)
                .build();

        // Laurea Triennale
        Education bachelor = Education.builder()
                .personalInfo(context.getPersonalInfo())
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
                .thesisDescriptionIt(
                        "Studio di soluzioni innovative per la rigassificazione del GNL basate su tecnologie di cogenerazione, " +
                                "con focus sull'utilizzo dei gas di scarico delle turbine a gas come fonte alternativa di calore. " +
                                "Analisi del caso studio dell'impianto di Zeebrugge (Belgio), dove dal 1996 una partnership tra " +
                                "Distrigas ed Electrabel ha dimostrato la fattibilità economica ed ambientale di questa tecnologia, " +
                                "riducendo significativamente i costi di produzione energetica."
                )
                .thesisDescriptionEn(
                        "Study of innovative solutions for LNG regasification based on cogeneration technologies, " +
                                "focusing on using gas turbine exhaust gases as an alternative heat source. " +
                                "Analysis of the Zeebrugge (Belgium) plant case study, where since 1996 a partnership between " +
                                "Distrigas and Electrabel has demonstrated the economic and environmental feasibility of this technology, " +
                                "significantly reducing energy production costs."
                )
                .displayOrder(2)
                .build();

        // Laurea Magistrale
        Education master = Education.builder()
                .personalInfo(context.getPersonalInfo())
                .institutionName("Politecnico di Milano")
                .institutionLocation("Milano, Italia")
                .degreeType("Laurea Magistrale")
                .fieldOfStudy("Ingegneria Elettrica")
                .startDate(LocalDate.of(2016, 10, 1))
                .endDate(LocalDate.of(2019, 7, 31))
                .grade("92")
                .gradeMax("110")
                .thesisTitleIt("CONNECTING PARKS TO THE SMART GRID: A Vehicle-to-Grid feasibility study in the railway station car park of Ferrara")
                .thesisTitleEn("CONNECTING PARKS TO THE SMART GRID: A Vehicle-to-Grid feasibility study in the railway station car park of Ferrara")
                .thesisDescriptionIt(
                        "Feasibility study per l'integrazione di infrastrutture di ricarica per veicoli elettrici in un parcheggio " +
                                "ferroviario, analizzando l'impatto energetico sulla rete di distribuzione. Sviluppato un algoritmo Vehicle-to-Grid " +
                                "che ottimizza i flussi energetici bidirezionali tra veicoli parcheggiati e rete elettrica, riducendo i picchi di " +
                                "assorbimento e migliorando la stabilità del sistema. Il progetto include l'integrazione con un sistema fotovoltaico " +
                                "dedicato per massimizzare l'efficienza energetica complessiva."
                )
                .thesisDescriptionEn(
                        "Feasibility study for integrating electric vehicle charging infrastructure in a railway parking facility, " +
                                "analyzing energy impact on the distribution grid. Developed a Vehicle-to-Grid algorithm that optimizes " +
                                "bidirectional energy flows between parked vehicles and the electrical grid, reducing absorption peaks and " +
                                "improving system stability. The project includes integration with a dedicated photovoltaic system to " +
                                "maximize overall energy efficiency."
                )
                .displayOrder(1)
                .build();

        context.getEducationRepo().save(highSchool);
        context.getEducationRepo().save(bachelor);
        context.getEducationRepo().save(master);

        System.out.println("✅ Education loaded (3 entries)");
    }

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String getName() {
        return "EducationDataLoader";
    }
}