package com.garruto.portfolio_backend.config.dataloaders;

import com.garruto.portfolio_backend.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyDataLoader implements DataLoader {

    @Override
    public void load(DataLoadContext context) {
        Company reply = Company.builder()
                .name("Reply")
                .sector("Sanitario")
                .location("Milano, Italia")
                .websiteUrl("https://www.reply.com")
                .build();
        reply = context.getCompanyRepo().save(reply);
        context.addCompany("REPLY", reply);

        Company rextart = Company.builder()
                .name("Rextart")
                .sector("Telecomunicazioni")
                .location("Roma, Italia")
                .websiteUrl("https://www.rextart.com")
                .build();
        rextart = context.getCompanyRepo().save(rextart);
        context.addCompany("REXTART", rextart);

        Company accenture = Company.builder()
                .name("Accenture")
                .sector("Consulting")
                .location("Milano, Italia")
                .websiteUrl("https://www.accenture.com")
                .build();
        accenture = context.getCompanyRepo().save(accenture);
        context.addCompany("ACCENTURE", accenture);

        Company metropark = Company.builder()
                .name("Metropark")
                .sector("Progettazione")
                .location("Roma, Italia")
                .build();
        metropark = context.getCompanyRepo().save(metropark);
        context.addCompany("METROPARK", metropark);

        Company superprof = Company.builder()
                .name("Superprof")
                .sector("Educazione")
                .location("Online")
                .websiteUrl("https://www.superprof.it")
                .build();
        superprof = context.getCompanyRepo().save(superprof);
        context.addCompany("SUPERPROF", superprof);

        System.out.println("✅ Companies loaded (5 entries)");
    }

    @Override
    public int getOrder() {
        return 3;
    }

    @Override
    public String getName() {
        return "CompanyDataLoader";
    }
}