package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.PersonalLanguage;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LanguageDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        PersonalLanguage italian = PersonalLanguage.builder()
                .personalInfo(context.getPersonalInfo())
                .languageNameIt("Italiano")
                .languageNameEn("Italian")
                .proficiencyLevel("Madrelingua")
                .isNative(true)
                .notesIt("Lingua Madre")
                .notesEn("Native Language")
                .displayOrder(1)
                .build();

        PersonalLanguage english = PersonalLanguage.builder()
                .personalInfo(context.getPersonalInfo())
                .languageNameIt("Inglese")
                .languageNameEn("English")
                .proficiencyLevel("B2")
                .isNative(false)
                .certificateName("TOEIC Certificate")
                .certificateScore("825")
                .certificateMaxScore("990")
                .certificateDate(LocalDate.of(2019, 1, 1)) // Approximate date
                .notesIt("Working Proficiency Plus")
                .notesEn("Working Proficiency Plus")
                .displayOrder(2)
                .build();

        context.getLanguageRepo().save(italian);
        context.getLanguageRepo().save(english);

        System.out.println("✅ Languages loaded (2 entries)");
    }

    @Override
    public int getOrder() {
        return 9;
    }

    @Override
    public String getName() {
        return "LanguageDataLoader";
    }
}
