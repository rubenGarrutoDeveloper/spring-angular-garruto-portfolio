-- =====================================================
-- Portfolio Database - Initial Data Population
-- Version: 002
-- Description: Populates tables with Ruben Garruto's portfolio data
-- =====================================================

-- =====================================================
-- PERSONAL INFORMATION
-- =====================================================

INSERT INTO personal_info (
    id, first_name, last_name, birth_date, professional_title,
    bio_summary_it, bio_summary_en,
    email, phone, linkedin_url, github_url,
    location_city, location_region, location_country
) VALUES (
    1,
    'Ruben',
    'Garruto',
    '1992-11-06',
    'Full Stack Web Developer',
    'Dal 2019 lavoro come consulente full-stack, specializzandomi nello sviluppo di applicazioni web enterprise per processi aziendali complessi. Mi occupo dell''intero stack tecnologico: progettazione architetture database, sviluppo backend e design UI/UX, coprendo l''intero ciclo di vita del software dalla raccolta requisiti al deployment. La combinazione tra formazione ingegneristica e competenze software mi consente di tradurre esigenze di business complesse in architetture concrete ed efficienti, affrontando progetti dove l''integrazione tra sistemi eterogenei, la gestione di grandi volumi di dati e l''affidabilità delle soluzioni sono elementi critici.',
    'Since 2019, I have been working as a full-stack consultant, specializing in developing enterprise web applications for complex business processes. I handle the entire technology stack: database architecture design, backend development, and UI/UX design, covering the complete software lifecycle from requirements gathering to deployment. The combination of engineering education and software skills allows me to translate complex business needs into concrete and efficient architectures, tackling projects where integration between heterogeneous systems, large data volume management, and solution reliability are critical elements.',
    'ruben.garruto@gmail.com',
    '+39 333 48 96 366',
    NULL,
    NULL,
    'Roma',
    'Lazio',
    'Italia'
);

-- =====================================================
-- SKILL CATEGORIES
-- =====================================================

INSERT INTO skill_categories (id, name_it, name_en, code, icon_class, display_order) VALUES
(1, 'Linguaggi di Programmazione', 'Programming Languages', 'PROGRAMMING_LANGUAGES', '💻', 1),
(2, 'Backend', 'Backend', 'BACKEND', '⚙️', 2),
(3, 'Frontend', 'Frontend', 'FRONTEND', '🎨', 3),
(4, 'Database', 'Database', 'DATABASE', '🗄️', 4),
(5, 'Tools & DevOps', 'Tools & DevOps', 'TOOLS_DEVOPS', '🛠️', 5),
(6, 'Altre Competenze', 'Other Skills', 'OTHER_SKILLS', '🎯', 6);

-- =====================================================
-- TECHNOLOGIES
-- =====================================================

-- Programming Languages
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(1, 'Java', 1, 'Language', 'Java SE/EE, Spring Framework', 'Java SE/EE, Spring Framework'),
(2, 'TypeScript', 1, 'Language', 'TypeScript per sviluppo frontend', 'TypeScript for frontend development'),
(3, 'SQL/PL-SQL', 1, 'Language', 'SQL e PL/SQL per database relazionali', 'SQL and PL-SQL for relational databases'),
(4, 'JavaScript', 1, 'Language', 'JavaScript vanilla', 'Vanilla JavaScript'),
(5, 'HTML5', 1, 'Markup', 'HTML5 per struttura web', 'HTML5 for web structure'),
(6, 'CSS3', 1, 'Styling', 'CSS3 per styling web', 'CSS3 for web styling');

-- Backend Technologies
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(7, 'Spring Boot', 2, 'Framework', 'Framework per applicazioni Spring standalone', 'Framework for standalone Spring applications'),
(8, 'Spring MVC', 2, 'Framework', 'Framework MVC per applicazioni web', 'MVC framework for web applications'),
(9, 'Spring Data JPA', 2, 'Framework', 'Astrazione per accesso dati JPA', 'Abstraction for JPA data access'),
(10, 'Spring Security', 2, 'Framework', 'Framework per sicurezza applicazioni', 'Framework for application security'),
(11, 'Spring Batch', 2, 'Framework', 'Framework per elaborazioni batch', 'Framework for batch processing'),
(12, 'Hibernate/JPA', 2, 'ORM', 'Object-Relational Mapping', 'Object-Relational Mapping'),
(13, 'RESTful API', 2, 'Architecture', 'API REST', 'REST API'),
(14, 'SOAP API', 2, 'Architecture', 'API SOAP', 'SOAP API');

-- Frontend Technologies
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(15, 'Angular', 3, 'Framework', 'Framework frontend (v8-20)', 'Frontend framework (v8-20)'),
(16, 'PrimeFaces', 3, 'Library', 'Libreria componenti JSF', 'JSF component library'),
(17, 'Bootstrap', 3, 'Framework', 'Framework CSS responsive', 'Responsive CSS framework');

-- Databases
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(18, 'Oracle Database', 4, 'RDBMS', 'Database relazionale Oracle', 'Oracle relational database'),
(19, 'InterSystems Caché', 4, 'Database', 'Database post-relazionale', 'Post-relational database'),
(20, 'InterSystems IRIS', 4, 'Database', 'Piattaforma dati multi-model', 'Multi-model data platform'),
(21, 'MySQL', 4, 'RDBMS', 'Database relazionale open source', 'Open source relational database'),
(22, 'PostgreSQL', 4, 'RDBMS', 'Database relazionale avanzato', 'Advanced relational database'),
(23, 'MongoDB', 4, 'NoSQL', 'Database NoSQL document-oriented', 'Document-oriented NoSQL database'),
(24, 'SQL Server', 4, 'RDBMS', 'Database relazionale Microsoft', 'Microsoft relational database');

-- Tools & DevOps
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(25, 'Git', 5, 'Version Control', 'Sistema controllo versione distribuito', 'Distributed version control system'),
(26, 'Bitbucket', 5, 'Version Control', 'Piattaforma Git hosting', 'Git hosting platform'),
(27, 'Sourcetree', 5, 'Version Control', 'Client Git GUI', 'Git GUI client'),
(28, 'Maven', 5, 'Build Tool', 'Tool gestione dipendenze e build', 'Dependency and build management tool'),
(29, 'Jasper Reports', 5, 'Reporting', 'Tool per generazione report', 'Report generation tool'),
(30, 'IntelliJ IDEA', 5, 'IDE', 'IDE per Java', 'Java IDE'),
(31, 'Eclipse', 5, 'IDE', 'IDE open source', 'Open source IDE'),
(32, 'Visual Studio Code', 5, 'IDE', 'Editor codice leggero', 'Lightweight code editor'),
(33, 'Postman', 5, 'Testing', 'Tool testing API', 'API testing tool'),
(34, 'SoapUI', 5, 'Testing', 'Tool testing servizi SOAP', 'SOAP service testing tool'),
(35, 'JIRA', 5, 'Project Management', 'Tool gestione progetti', 'Project management tool'),
(36, 'Confluence', 5, 'Documentation', 'Tool documentazione collaborativa', 'Collaborative documentation tool'),
(37, 'SQL Developer', 5, 'Database Tool', 'Tool per Oracle Database', 'Oracle Database tool'),
(38, 'DBeaver', 5, 'Database Tool', 'Client database universale', 'Universal database client'),
(39, 'MySQL Workbench', 5, 'Database Tool', 'Tool per MySQL', 'MySQL tool'),
(40, 'Docker', 5, 'DevOps', 'Piattaforma containerizzazione', 'Containerization platform'),
(41, 'JBoss', 5, 'Application Server', 'Application server Java EE', 'Java EE application server'),
(42, 'Glassfish', 5, 'Application Server', 'Application server Java EE', 'Java EE application server'),
(43, 'Payara', 5, 'Application Server', 'Application server basato su Glassfish', 'Glassfish-based application server');

-- Other Skills
INSERT INTO technologies (id, name, category_id, type, description_it, description_en) VALUES
(44, 'HL7', 6, 'Standard', 'Standard interoperabilità sistemi sanitari', 'Healthcare system interoperability standard'),
(45, 'Arduino', 6, 'IoT', 'Piattaforma microcontroller', 'Microcontroller platform'),
(46, 'ESP8266', 6, 'IoT', 'Modulo WiFi IoT', 'WiFi IoT module'),
(47, 'Raspberry Pi', 6, 'IoT', 'Single-board computer', 'Single-board computer'),
(48, 'AutoCAD', 6, 'Design', 'Software progettazione CAD', 'CAD design software');

-- =====================================================
-- PERSONAL TECH PROFICIENCY
-- =====================================================

INSERT INTO personal_tech_proficiency (
    id, personal_info_id, technology_id, proficiency_level, 
    years_of_experience, is_featured, display_order
) VALUES
-- Programming Languages (Advanced)
(1, 1, 1, 'Advanced', 6.0, true, 1),    -- Java
(2, 1, 2, 'Intermediate', 4.0, true, 2), -- TypeScript
(3, 1, 3, 'Intermediate', 6.0, true, 3), -- SQL/PL-SQL
(4, 1, 4, 'Base', 6.0, false, 4),        -- JavaScript
(5, 1, 5, 'Base', 6.0, false, 5),        -- HTML5
(6, 1, 6, 'Base', 6.0, false, 6),        -- CSS3

-- Backend (All featured as main expertise)
(7, 1, 7, 'Advanced', 4.0, true, 7),     -- Spring Boot
(8, 1, 8, 'Advanced', 6.0, true, 8),     -- Spring MVC
(9, 1, 9, 'Advanced', 4.0, true, 9),     -- Spring Data JPA
(10, 1, 10, 'Advanced', 4.0, true, 10),  -- Spring Security
(11, 1, 11, 'Advanced', 4.0, true, 11),  -- Spring Batch
(12, 1, 12, 'Advanced', 6.0, true, 12),  -- Hibernate/JPA
(13, 1, 13, 'Advanced', 6.0, true, 13),  -- RESTful API
(14, 1, 14, 'Advanced', 6.0, true, 14),  -- SOAP API

-- Frontend
(15, 1, 15, 'Intermediate', 2.0, true, 15), -- Angular
(16, 1, 16, 'Intermediate', 4.0, true, 16), -- PrimeFaces
(17, 1, 17, 'Base', 6.0, false, 17),        -- Bootstrap

-- Databases
(18, 1, 18, 'Advanced', 6.0, true, 18),  -- Oracle Database
(19, 1, 19, 'Intermediate', 2.0, true, 19), -- InterSystems Caché
(20, 1, 20, 'Intermediate', 2.0, true, 20), -- InterSystems IRIS
(21, 1, 21, 'Intermediate', 1.0, true, 21), -- MySQL
(22, 1, 22, 'Intermediate', 1.0, true, 22), -- PostgreSQL
(23, 1, 23, 'Base', 0.5, false, 23),        -- MongoDB

-- Tools & DevOps
(24, 1, 25, 'Advanced', 6.0, true, 24),  -- Git
(25, 1, 26, 'Advanced', 6.0, true, 25),  -- Bitbucket
(26, 1, 28, 'Advanced', 6.0, true, 26),  -- Maven
(27, 1, 29, 'Intermediate', 4.0, true, 27), -- Jasper Reports
(28, 1, 30, 'Advanced', 6.0, false, 28), -- IntelliJ IDEA
(29, 1, 33, 'Advanced', 6.0, false, 29), -- Postman
(30, 1, 35, 'Advanced', 6.0, false, 30), -- JIRA
(31, 1, 40, 'Intermediate', 2.0, true, 31), -- Docker

-- Other Skills
(32, 1, 44, 'Intermediate', 2.0, true, 32), -- HL7
(33, 1, 45, 'Base', 2.0, false, 33),        -- Arduino
(34, 1, 46, 'Base', 2.0, false, 34),        -- ESP8266
(35, 1, 47, 'Base', 2.0, false, 35),        -- Raspberry Pi
(36, 1, 48, 'Intermediate', 1.0, false, 36); -- AutoCAD

-- =====================================================
-- LANGUAGES
-- =====================================================

INSERT INTO personal_languages (
    id, personal_info_id, language_name_it, language_name_en,
    proficiency_level, is_native, certificate_name, 
    certificate_score, certificate_max_score, display_order
) VALUES
(1, 1, 'Italiano', 'Italian', 'Native', true, NULL, NULL, NULL, 1),
(2, 1, 'Inglese', 'English', 'B2', false, 'TOEIC Certificate', '825', '990', 2);

-- =====================================================
-- COMPANIES
-- =====================================================

INSERT INTO companies (id, name, sector, location) VALUES
(1, 'Reply', 'Healthcare', 'Roma, Italia'),
(2, 'Rextart', 'Telecommunications', 'Roma, Italia'),
(3, 'Accenture', 'Energy', 'Milano, Italia'),
(4, 'Metropark', 'Engineering', 'Milano, Italia');

-- =====================================================
-- EDUCATION
-- =====================================================

INSERT INTO education (
    id, personal_info_id, institution_name, institution_location,
    degree_type, field_of_study, start_date, end_date, grade, grade_max,
    thesis_title_it, thesis_title_en, thesis_description_it, thesis_description_en, display_order
) VALUES
(1, 1, 'Politecnico di Milano', 'Milano, Italia', 'Master', 'Electrical Engineering',
 '2016-10-01', '2019-07-01', '92', '110',
 'CONNECTING PARKS TO THE SMART GRID: Uno studio di fattibilità Vehicle-to-Grid nel parcheggio della stazione ferroviaria di Ferrara',
 'CONNECTING PARKS TO THE SMART GRID: A Vehicle-to-Grid feasibility study in the railway station car park of Ferrara',
 'Studio di fattibilità per l''integrazione di infrastrutture di ricarica per veicoli elettrici in un parcheggio ferroviario, analizzando l''impatto energetico sulla rete di distribuzione. Sviluppato un algoritmo Vehicle-to-Grid che ottimizza i flussi energetici bidirezionali tra i veicoli parcheggiati e la rete elettrica, riducendo i picchi di assorbimento e migliorando la stabilità del sistema. Il progetto include l''integrazione con un sistema fotovoltaico dedicato per massimizzare l''efficienza energetica complessiva.',
 'Feasibility study for integrating electric vehicle charging infrastructure in a railway parking facility, analyzing energy impact on the distribution grid. Developed a Vehicle-to-Grid algorithm that optimizes bidirectional energy flows between parked vehicles and the electrical grid, reducing absorption peaks and improving system stability. The project includes integration with a dedicated photovoltaic system to maximize overall energy efficiency.',
 1),
(2, 1, 'Politecnico di Milano', 'Milano, Italia', 'Bachelor', 'Electrical Engineering',
 '2011-10-01', '2016-09-01', '85', '110',
 'Esempio di impianto di rigassificazione LNG con adozione di turbina a gas interrefrigerata',
 'Example of LNG regasification plant with intercooled gas turbine adoption',
 'Studio di soluzioni innovative per la rigassificazione del GNL basate su tecnologie di cogenerazione, con focus sull''utilizzo dei gas di scarico delle turbine a gas come fonte alternativa di calore. Analisi del caso studio dell''impianto di Zeebrugge (Belgio), dove dal 1996 una partnership tra Distrigas ed Electrabel ha dimostrato la fattibilità economica ed ambientale di questa tecnologia, riducendo significativamente i costi di produzione energetica.',
 'Study of innovative solutions for LNG regasification based on cogeneration technologies, focusing on using gas turbine exhaust gases as an alternative heat source. Analysis of the Zeebrugge (Belgium) plant case study, where since 1996 a partnership between Distrigas and Electrabel has demonstrated the economic and environmental feasibility of this technology, significantly reducing energy production costs.',
 2),
(3, 1, 'Liceo Scientifico G. Marconi', 'Roma, Italia', 'High School Diploma', 'Scientific Studies',
 '2006-09-01', '2011-07-01', '82', '100',
 NULL, NULL, NULL, NULL, 3);

-- =====================================================
-- WORK EXPERIENCE
-- =====================================================

-- Reply (Current Position)
INSERT INTO work_experience (
    id, personal_info_id, company_id, job_title, employment_type,
    start_date, end_date, is_current,
    description_it, description_en, display_order
) VALUES
(1, 1, 1, 'Full Stack Web Developer', 'Full-time',
 '2023-09-01', NULL, true,
 'Progettazione e sviluppo di applicazione web enterprise per la gestione integrata dei processi sanitari, con focus su automazione e interoperabilità.',
 'Design and development of enterprise web application for integrated healthcare process management, with focus on automation and interoperability.',
 1);

-- Rextart (Apprenticeship)
INSERT INTO work_experience (
    id, personal_info_id, company_id, job_title, employment_type,
    start_date, end_date, is_current,
    description_it, description_en, display_order
) VALUES
(2, 1, 2, 'Full Stack Web Developer', 'Apprenticeship',
 '2019-11-01', '2023-08-31', false,
 'Sviluppo di applicazione web enterprise per gestione e automazione dei processi di collaudo delle Stazioni Radio, coprendo l''intero ciclo di sviluppo dall''UI al database.',
 'Development of enterprise web application for management and automation of Radio Station testing processes, covering the entire development cycle from UI to database.',
 2);

-- Accenture Stage
INSERT INTO work_experience (
    id, personal_info_id, company_id, job_title, employment_type,
    start_date, end_date, is_current,
    description_it, description_en, display_order
) VALUES
(3, 1, 3, 'Software Developer Intern', 'Internship',
 '2019-08-01', '2019-10-31', false,
 'Sviluppo di microservizi web in ambiente Agile per azienda del settore energetico, acquisendo esperienza in architetture moderne e metodologie collaborative.',
 'Development of web microservices in Agile environment for energy sector company, gaining experience in modern architectures and collaborative methodologies.',
 3);

-- Metropark Stage
INSERT INTO work_experience (
    id, personal_info_id, company_id, job_title, employment_type,
    start_date, end_date, is_current,
    description_it, description_en, display_order
) VALUES
(4, 1, 4, 'Electrical Design Assistant', 'Internship',
 '2018-09-01', '2019-03-31', false,
 'Progettazione e dimensionamento di impianti elettrici per parcheggi, sistemi TVCC e infrastrutture di ricarica per veicoli elettrici.',
 'Design and sizing of electrical systems for parking facilities, CCTV systems and electric vehicle charging infrastructure.',
 4);

-- =====================================================
-- WORK RESPONSIBILITIES
-- =====================================================

-- Reply Responsibilities
INSERT INTO work_responsibilities (id, work_experience_id, description_it, description_en, display_order) VALUES
(1, 1, 'Sviluppo full-stack: front-end Angular, back-end Java Spring e integrazione dati', 'Full-stack development: Angular front-end, Java Spring back-end and data integration', 1),
(2, 1, 'Implementazione di logiche di business per automazione dei workflow sanitari', 'Implementation of business logic for healthcare workflow automation', 2),
(3, 1, 'Integrazione con sistemi HL7 per interoperabilità dei dati clinici', 'Integration with HL7 systems for clinical data interoperability', 3),
(4, 1, 'Sviluppo e manutenzione di API REST e SOAP per sistemi esterni', 'Development and maintenance of REST and SOAP APIs for external systems', 4);

-- Rextart Responsibilities
INSERT INTO work_responsibilities (id, work_experience_id, description_it, description_en, display_order) VALUES
(5, 2, 'Sviluppo di interfacce utente JSF con componenti PrimeFaces', 'Development of JSF user interfaces with PrimeFaces components', 1),
(6, 2, 'Progettazione e implementazione delle logiche di business per automazione dei processi', 'Design and implementation of business logic for process automation', 2),
(7, 2, 'Creazione di report dettagliati e personalizzabili per analisi dei dati tecnici', 'Creation of detailed and customizable reports for technical data analysis', 3),
(8, 2, 'Deployment e configurazione delle applicazioni su JBoss', 'Deployment and configuration of applications on JBoss', 4);

-- =====================================================
-- WORK ACHIEVEMENTS
-- =====================================================

-- Rextart Achievements
INSERT INTO work_achievements (id, work_experience_id, description_it, description_en, display_order) VALUES
(1, 2, 'Implementazione di un sistema di versionamento dei dati delle antenne', 'Implementation of antenna data versioning system', 1),
(2, 2, 'Implementazione di un sistema dinamico di report tramite Jasper Reports', 'Implementation of dynamic reporting system using Jasper Reports', 2),
(3, 2, 'Creazione di dashboard per monitoraggio avanzamento collaudi', 'Creation of dashboards for testing progress monitoring', 3),
(4, 2, 'Automatizzazione completa dei processi di collaudo, riducendo i tempi operativi', 'Complete automation of testing processes, reducing operational time', 4);

-- =====================================================
-- WORK TECHNOLOGIES
-- =====================================================

-- Reply Technologies
INSERT INTO work_technologies (id, work_experience_id, technology_id) VALUES
-- Languages & Core
(1, 1, 15),  -- Angular
(2, 1, 1),   -- Java
(3, 1, 7),   -- Spring Boot
(4, 1, 18),  -- Oracle Database
(5, 1, 19),  -- InterSystems Caché
(6, 1, 20),  -- InterSystems IRIS
(7, 1, 42),  -- Glassfish
(8, 1, 43),  -- Payara
(9, 1, 40),  -- Docker
(10, 1, 13), -- REST API
(11, 1, 14), -- SOAP API
(12, 1, 44), -- HL7
(13, 1, 25), -- Git
(14, 1, 26), -- Bitbucket
(15, 1, 35); -- JIRA

-- Rextart Technologies
INSERT INTO work_technologies (id, work_experience_id, technology_id) VALUES
(16, 2, 1),   -- Java
(17, 2, 16),  -- PrimeFaces
(18, 2, 18),  -- Oracle Database
(19, 2, 41),  -- JBoss
(20, 2, 29),  -- Jasper Reports
(21, 2, 25);  -- Git

-- Accenture Technologies
INSERT INTO work_technologies (id, work_experience_id, technology_id) VALUES
(22, 3, 1),   -- Java
(23, 3, 7),   -- Spring Boot
(24, 3, 24),  -- SQL Server
(25, 3, 23),  -- MongoDB
(26, 3, 26),  -- Bitbucket
(27, 3, 35);  -- JIRA

-- Metropark Technologies
INSERT INTO work_technologies (id, work_experience_id, technology_id) VALUES
(28, 4, 48);  -- AutoCAD

-- =====================================================
-- RESET SEQUENCES
-- =====================================================

SELECT setval('personal_info_id_seq', (SELECT MAX(id) FROM personal_info));
SELECT setval('skill_categories_id_seq', (SELECT MAX(id) FROM skill_categories));
SELECT setval('technologies_id_seq', (SELECT MAX(id) FROM technologies));
SELECT setval('personal_tech_proficiency_id_seq', (SELECT MAX(id) FROM personal_tech_proficiency));
SELECT setval('personal_languages_id_seq', (SELECT MAX(id) FROM personal_languages));
SELECT setval('companies_id_seq', (SELECT MAX(id) FROM companies));
SELECT setval('education_id_seq', (SELECT MAX(id) FROM education));
SELECT setval('work_experience_id_seq', (SELECT MAX(id) FROM work_experience));
SELECT setval('work_responsibilities_id_seq', (SELECT MAX(id) FROM work_responsibilities));
SELECT setval('work_achievements_id_seq', (SELECT MAX(id) FROM work_achievements));
SELECT setval('work_technologies_id_seq', (SELECT MAX(id) FROM work_technologies));

-- =====================================================
-- END OF POPULATION SCRIPT
-- =====================================================