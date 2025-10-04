-- =====================================================
-- Portfolio Database Schema - Initial Setup
-- Version: 001
-- Description: Creates all tables for the portfolio application
-- =====================================================

-- =====================================================
-- CORE TABLES
-- =====================================================

-- Table: personal_info
-- Stores main personal and professional information
CREATE TABLE personal_info (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birth_date DATE,
    professional_title VARCHAR(200),
    bio_summary_it TEXT,
    bio_summary_en TEXT,
    profile_image_url VARCHAR(500),
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(50),
    linkedin_url VARCHAR(500),
    github_url VARCHAR(500),
    location_city VARCHAR(100),
    location_region VARCHAR(100),
    location_country VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- =====================================================
-- EDUCATION SECTION
-- =====================================================

-- Table: education
-- Stores educational background information
CREATE TABLE education (
    id BIGSERIAL PRIMARY KEY,
    personal_info_id BIGINT NOT NULL,
    institution_name VARCHAR(255) NOT NULL,
    institution_location VARCHAR(255),
    degree_type VARCHAR(100),
    field_of_study VARCHAR(255),
    start_date DATE,
    end_date DATE,
    grade VARCHAR(50),
    grade_max VARCHAR(50),
    thesis_title_it TEXT,
    thesis_title_en TEXT,
    thesis_description_it TEXT,
    thesis_description_en TEXT,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_education_personal_info 
        FOREIGN KEY (personal_info_id) 
        REFERENCES personal_info(id) 
        ON DELETE CASCADE
);

-- =====================================================
-- WORK EXPERIENCE SECTION
-- =====================================================

-- Table: companies
-- Stores company information
CREATE TABLE companies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sector VARCHAR(255),
    location VARCHAR(255),
    website_url VARCHAR(500),
    logo_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: work_experience
-- Stores main work experience entries
CREATE TABLE work_experience (
    id BIGSERIAL PRIMARY KEY,
    personal_info_id BIGINT NOT NULL,
    company_id BIGINT NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    employment_type VARCHAR(100),
    start_date DATE,
    end_date DATE,
    is_current BOOLEAN DEFAULT FALSE,
    description_it TEXT,
    description_en TEXT,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_work_experience_personal_info 
        FOREIGN KEY (personal_info_id) 
        REFERENCES personal_info(id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_work_experience_company 
        FOREIGN KEY (company_id) 
        REFERENCES companies(id) 
        ON DELETE RESTRICT
);

-- Table: work_responsibilities
-- Stores detailed responsibilities for each work experience
CREATE TABLE work_responsibilities (
    id BIGSERIAL PRIMARY KEY,
    work_experience_id BIGINT NOT NULL,
    description_it TEXT NOT NULL,
    description_en TEXT NOT NULL,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_work_responsibilities_work_experience 
        FOREIGN KEY (work_experience_id) 
        REFERENCES work_experience(id) 
        ON DELETE CASCADE
);

-- Table: work_achievements
-- Stores achievements for each work experience
CREATE TABLE work_achievements (
    id BIGSERIAL PRIMARY KEY,
    work_experience_id BIGINT NOT NULL,
    description_it TEXT NOT NULL,
    description_en TEXT NOT NULL,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_work_achievements_work_experience 
        FOREIGN KEY (work_experience_id) 
        REFERENCES work_experience(id) 
        ON DELETE CASCADE
);

-- =====================================================
-- SKILLS & TECHNOLOGIES SECTION
-- =====================================================

-- Table: skill_categories
-- Stores categories for organizing skills and technologies
CREATE TABLE skill_categories (
    id BIGSERIAL PRIMARY KEY,
    name_it VARCHAR(255) NOT NULL,
    name_en VARCHAR(255) NOT NULL,
    code VARCHAR(100) UNIQUE NOT NULL,
    icon_class VARCHAR(100),
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: technologies
-- Stores all technologies, frameworks, tools, etc.
CREATE TABLE technologies (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_id BIGINT NOT NULL,
    type VARCHAR(100),
    description_it TEXT,
    description_en TEXT,
    website_url VARCHAR(500),
    logo_url VARCHAR(500),
    icon_class VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_technologies_category 
        FOREIGN KEY (category_id) 
        REFERENCES skill_categories(id) 
        ON DELETE RESTRICT
);

-- Table: work_technologies
-- Links technologies to work experiences
CREATE TABLE work_technologies (
    id BIGSERIAL PRIMARY KEY,
    work_experience_id BIGINT NOT NULL,
    technology_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_work_technologies_work_experience 
        FOREIGN KEY (work_experience_id) 
        REFERENCES work_experience(id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_work_technologies_technology 
        FOREIGN KEY (technology_id) 
        REFERENCES technologies(id) 
        ON DELETE CASCADE,
    CONSTRAINT uk_work_technologies 
        UNIQUE (work_experience_id, technology_id)
);

-- Table: personal_tech_proficiency
-- Stores personal proficiency levels for each technology
CREATE TABLE personal_tech_proficiency (
    id BIGSERIAL PRIMARY KEY,
    personal_info_id BIGINT NOT NULL,
    technology_id BIGINT NOT NULL,
    proficiency_level VARCHAR(50),
    years_of_experience DECIMAL(4,1),
    notes_it TEXT,
    notes_en TEXT,
    is_featured BOOLEAN DEFAULT FALSE,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_personal_tech_proficiency_personal_info 
        FOREIGN KEY (personal_info_id) 
        REFERENCES personal_info(id) 
        ON DELETE CASCADE,
    CONSTRAINT fk_personal_tech_proficiency_technology 
        FOREIGN KEY (technology_id) 
        REFERENCES technologies(id) 
        ON DELETE CASCADE,
    CONSTRAINT uk_personal_tech_proficiency 
        UNIQUE (personal_info_id, technology_id)
);

-- =====================================================
-- LANGUAGES SECTION
-- =====================================================

-- Table: personal_languages
-- Stores language proficiency information
CREATE TABLE personal_languages (
    id BIGSERIAL PRIMARY KEY,
    personal_info_id BIGINT NOT NULL,
    language_name_it VARCHAR(100) NOT NULL,
    language_name_en VARCHAR(100) NOT NULL,
    proficiency_level VARCHAR(50),
    is_native BOOLEAN DEFAULT FALSE,
    certificate_name VARCHAR(255),
    certificate_score VARCHAR(50),
    certificate_max_score VARCHAR(50),
    certificate_date DATE,
    certificate_url VARCHAR(500),
    notes_it TEXT,
    notes_en TEXT,
    display_order INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_personal_languages_personal_info 
        FOREIGN KEY (personal_info_id) 
        REFERENCES personal_info(id) 
        ON DELETE CASCADE
);

-- =====================================================
-- INDEXES
-- =====================================================

-- Indexes for better query performance
CREATE INDEX idx_education_personal_info ON education(personal_info_id);
CREATE INDEX idx_work_experience_personal_info ON work_experience(personal_info_id);
CREATE INDEX idx_work_experience_company ON work_experience(company_id);
CREATE INDEX idx_work_responsibilities_work_experience ON work_responsibilities(work_experience_id);
CREATE INDEX idx_work_achievements_work_experience ON work_achievements(work_experience_id);
CREATE INDEX idx_technologies_category ON technologies(category_id);
CREATE INDEX idx_work_technologies_work_experience ON work_technologies(work_experience_id);
CREATE INDEX idx_work_technologies_technology ON work_technologies(technology_id);
CREATE INDEX idx_personal_tech_proficiency_personal_info ON personal_tech_proficiency(personal_info_id);
CREATE INDEX idx_personal_tech_proficiency_technology ON personal_tech_proficiency(technology_id);
CREATE INDEX idx_personal_languages_personal_info ON personal_languages(personal_info_id);

-- =====================================================
-- END OF SCHEMA
-- =====================================================