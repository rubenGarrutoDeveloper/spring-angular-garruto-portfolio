package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.SkillCategory;
import org.springframework.stereotype.Component;

@Component
public class SkillCategoryDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        SkillCategory programmingLanguages = SkillCategory.builder()
                .nameIt("Linguaggi di Programmazione")
                .nameEn("Programming Languages")
                .code("PROGRAMMING_LANGUAGES")
                .iconClass("fa-code")
                .displayOrder(1)
                .build();
        programmingLanguages = context.getSkillCategoryRepo().save(programmingLanguages);
        context.addSkillCategory("PROGRAMMING_LANGUAGES", programmingLanguages);

        SkillCategory backend = SkillCategory.builder()
                .nameIt("Backend")
                .nameEn("Backend")
                .code("BACKEND")
                .iconClass("fa-server")
                .displayOrder(2)
                .build();
        backend = context.getSkillCategoryRepo().save(backend);
        context.addSkillCategory("BACKEND", backend);

        SkillCategory frontend = SkillCategory.builder()
                .nameIt("Frontend")
                .nameEn("Frontend")
                .code("FRONTEND")
                .iconClass("fa-laptop-code")
                .displayOrder(3)
                .build();
        frontend = context.getSkillCategoryRepo().save(frontend);
        context.addSkillCategory("FRONTEND", frontend);

        SkillCategory database = SkillCategory.builder()
                .nameIt("Database")
                .nameEn("Database")
                .code("DATABASE")
                .iconClass("fa-database")
                .displayOrder(4)
                .build();
        database = context.getSkillCategoryRepo().save(database);
        context.addSkillCategory("DATABASE", database);

        SkillCategory tools = SkillCategory.builder()
                .nameIt("Tools & DevOps")
                .nameEn("Tools & DevOps")
                .code("TOOLS_DEVOPS")
                .iconClass("fa-tools")
                .displayOrder(5)
                .build();
        tools = context.getSkillCategoryRepo().save(tools);
        context.addSkillCategory("TOOLS_DEVOPS", tools);

        SkillCategory other = SkillCategory.builder()
                .nameIt("Altre Competenze")
                .nameEn("Other Skills")
                .code("OTHER_SKILLS")
                .iconClass("fa-puzzle-piece")
                .displayOrder(6)
                .build();
        other = context.getSkillCategoryRepo().save(other);
        context.addSkillCategory("OTHER_SKILLS", other);

        System.out.println("✅ Skill Categories loaded (6 entries)");
    }

    @Override
    public int getOrder() {
        return 5;
    }

    @Override
    public String getName() {
        return "SkillCategoryDataLoader";
    }
}
