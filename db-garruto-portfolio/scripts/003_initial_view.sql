-- =====================================================
-- Portfolio Database - Convenience Views
-- Version: 003
-- Description: Views for easy database inspection and ad-hoc queries
-- Note: These are for human readability, not for application use
-- =====================================================

-- =====================================================
-- PERSONAL PROFILE VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_personal_profile AS
SELECT
    pi.id,
    pi.first_name,
    pi.last_name,
    pi.first_name || ' ' || pi.last_name AS full_name,
    pi.birth_date,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, pi.birth_date)) AS age,
    pi.professional_title,
    pi.bio_summary_it,
    pi.bio_summary_en,
    pi.profile_image_url,
    pi.email,
    pi.phone,
    pi.linkedin_url,
    pi.github_url,
    pi.location_city,
    pi.location_region,
    pi.location_country,
    pi.location_city || ', ' || pi.location_region || ', ' || pi.location_country AS full_location,
    pi.created_at,
    pi.updated_at
FROM personal_info pi;

COMMENT ON VIEW v_personal_profile IS 'Complete personal profile with calculated fields for easy viewing';

-- =====================================================
-- EDUCATION VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_education_full AS
SELECT
    e.id,
    e.personal_info_id,
    pi.first_name || ' ' || pi.last_name AS person_name,
    e.institution_name,
    e.institution_location,
    e.degree_type,
    e.field_of_study,
    e.start_date,
    e.end_date,
    e.grade || '/' || e.grade_max AS final_grade,
    e.grade,
    e.grade_max,
    e.thesis_title_it,
    e.thesis_title_en,
    e.thesis_description_it,
    e.thesis_description_en,
    EXTRACT(YEAR FROM e.end_date) - EXTRACT(YEAR FROM e.start_date) AS duration_years,
    e.display_order,
    e.created_at,
    e.updated_at
FROM education e
JOIN personal_info pi ON e.personal_info_id = pi.id
ORDER BY e.display_order;

COMMENT ON VIEW v_education_full IS 'Complete education history with formatted grades and durations';

-- =====================================================
-- WORK EXPERIENCE FULL VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_work_experience_full AS
SELECT
    we.id,
    we.personal_info_id,
    pi.first_name || ' ' || pi.last_name AS person_name,
    c.name AS company_name,
    c.sector AS company_sector,
    c.location AS company_location,
    we.job_title,
    we.employment_type,
    we.start_date,
    we.end_date,
    we.is_current,
    CASE
        WHEN we.is_current THEN 'Current'
        ELSE TO_CHAR(we.end_date, 'Mon YYYY')
    END AS end_date_display,
    CASE
        WHEN we.is_current THEN
            EXTRACT(YEAR FROM AGE(CURRENT_DATE, we.start_date)) * 12 +
            EXTRACT(MONTH FROM AGE(CURRENT_DATE, we.start_date))
        ELSE
            EXTRACT(YEAR FROM AGE(we.end_date, we.start_date)) * 12 +
            EXTRACT(MONTH FROM AGE(we.end_date, we.start_date))
    END AS duration_months,
    we.description_it,
    we.description_en,
    -- Aggregate responsibilities (Italian)
    (SELECT string_agg(wr.description_it, ' | ' ORDER BY wr.display_order)
     FROM work_responsibilities wr
     WHERE wr.work_experience_id = we.id) AS responsibilities_it,
    -- Aggregate responsibilities (English)
    (SELECT string_agg(wr.description_en, ' | ' ORDER BY wr.display_order)
     FROM work_responsibilities wr
     WHERE wr.work_experience_id = we.id) AS responsibilities_en,
    -- Aggregate achievements (Italian)
    (SELECT string_agg(wa.description_it, ' | ' ORDER BY wa.display_order)
     FROM work_achievements wa
     WHERE wa.work_experience_id = we.id) AS achievements_it,
    -- Aggregate achievements (English)
    (SELECT string_agg(wa.description_en, ' | ' ORDER BY wa.display_order)
     FROM work_achievements wa
     WHERE wa.work_experience_id = we.id) AS achievements_en,
    -- Aggregate technologies
    (SELECT string_agg(t.name, ', ' ORDER BY t.name)
     FROM work_technologies wt
     JOIN technologies t ON wt.technology_id = t.id
     WHERE wt.work_experience_id = we.id) AS tech_stack,
    we.display_order,
    we.created_at,
    we.updated_at
FROM work_experience we
JOIN personal_info pi ON we.personal_info_id = pi.id
JOIN companies c ON we.company_id = c.id
ORDER BY we.display_order;

COMMENT ON VIEW v_work_experience_full IS 'Complete work experience with aggregated responsibilities, achievements, and technologies';

-- =====================================================
-- WORK TIMELINE VIEW (Simplified)
-- =====================================================

CREATE OR REPLACE VIEW v_work_timeline AS
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    TO_CHAR(we.start_date, 'Mon YYYY') AS started,
    CASE
        WHEN we.is_current THEN 'Present'
        ELSE TO_CHAR(we.end_date, 'Mon YYYY')
    END AS ended,
    CASE
        WHEN we.is_current THEN
            ROUND((EXTRACT(YEAR FROM AGE(CURRENT_DATE, we.start_date)) * 12 +
                   EXTRACT(MONTH FROM AGE(CURRENT_DATE, we.start_date))) / 12.0, 1)
        ELSE
            ROUND((EXTRACT(YEAR FROM AGE(we.end_date, we.start_date)) * 12 +
                   EXTRACT(MONTH FROM AGE(we.end_date, we.start_date))) / 12.0, 1)
    END AS years,
    we.employment_type,
    c.sector,
    we.is_current
FROM work_experience we
JOIN companies c ON we.company_id = c.id
ORDER BY we.start_date DESC;

COMMENT ON VIEW v_work_timeline IS 'Simplified chronological work history for quick overview';

-- =====================================================
-- TECHNOLOGY SKILLS VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_tech_skills AS
SELECT
    ptp.id,
    ptp.personal_info_id,
    pi.first_name || ' ' || pi.last_name AS person_name,
    sc.name_en AS category,
    sc.code AS category_code,
    sc.icon_class AS category_icon,
    t.name AS technology,
    t.type AS tech_type,
    ptp.proficiency_level,
    ptp.years_of_experience,
    ptp.is_featured,
    t.description_it,
    t.description_en,
    t.website_url,
    t.logo_url,
    t.icon_class AS tech_icon,
    ptp.notes_it,
    ptp.notes_en,
    sc.display_order AS category_order,
    ptp.display_order AS skill_order
FROM personal_tech_proficiency ptp
JOIN personal_info pi ON ptp.personal_info_id = pi.id
JOIN technologies t ON ptp.technology_id = t.id
JOIN skill_categories sc ON t.category_id = sc.id
ORDER BY sc.display_order, ptp.display_order;

COMMENT ON VIEW v_tech_skills IS 'Technology skills with proficiency levels organized by category';

-- =====================================================
-- FEATURED SKILLS VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_featured_skills AS
SELECT
    sc.name_en AS category,
    sc.icon_class AS category_icon,
    string_agg(
        t.name || ' (' || ptp.proficiency_level || ')',
        ', '
        ORDER BY ptp.display_order
    ) AS skills
FROM personal_tech_proficiency ptp
JOIN technologies t ON ptp.technology_id = t.id
JOIN skill_categories sc ON t.category_id = sc.id
WHERE ptp.is_featured = true
GROUP BY sc.name_en, sc.icon_class, sc.display_order
ORDER BY sc.display_order;

COMMENT ON VIEW v_featured_skills IS 'Summary of featured skills grouped by category';

-- =====================================================
-- SKILLS BY CATEGORY VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_skills_by_category AS
SELECT
    sc.id AS category_id,
    sc.name_it AS category_it,
    sc.name_en AS category_en,
    sc.code AS category_code,
    sc.icon_class,
    COUNT(ptp.id) AS total_skills,
    COUNT(CASE WHEN ptp.is_featured THEN 1 END) AS featured_skills,
    string_agg(
        CASE WHEN ptp.is_featured THEN t.name END,
        ', '
        ORDER BY ptp.display_order
    ) AS featured_list,
    AVG(ptp.years_of_experience) AS avg_years_experience,
    sc.display_order
FROM skill_categories sc
LEFT JOIN technologies t ON t.category_id = sc.id
LEFT JOIN personal_tech_proficiency ptp ON ptp.technology_id = t.id
GROUP BY sc.id, sc.name_it, sc.name_en, sc.code, sc.icon_class, sc.display_order
ORDER BY sc.display_order;

COMMENT ON VIEW v_skills_by_category IS 'Skills statistics and aggregations by category';

-- =====================================================
-- LANGUAGES VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_languages AS
SELECT
    pl.id,
    pl.personal_info_id,
    pi.first_name || ' ' || pi.last_name AS person_name,
    pl.language_name_en AS language,
    pl.proficiency_level,
    pl.is_native,
    CASE
        WHEN pl.is_native THEN 'Native Speaker'
        ELSE pl.proficiency_level
    END AS proficiency_display,
    pl.certificate_name,
    CASE
        WHEN pl.certificate_score IS NOT NULL THEN
            pl.certificate_score || '/' || pl.certificate_max_score
        ELSE NULL
    END AS certificate_score_display,
    pl.certificate_date,
    pl.certificate_url,
    pl.notes_en,
    pl.display_order
FROM personal_languages pl
JOIN personal_info pi ON pl.personal_info_id = pi.id
ORDER BY pl.display_order;

COMMENT ON VIEW v_languages IS 'Language proficiency with formatted certificate information';

-- =====================================================
-- TECHNOLOGIES USED IN JOBS VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_technologies_usage AS
SELECT
    t.id AS technology_id,
    t.name AS technology,
    sc.name_en AS category,
    t.type,
    COUNT(DISTINCT wt.work_experience_id) AS jobs_count,
    string_agg(
        DISTINCT c.name || ' (' || we.job_title || ')',
        ' | '
        ORDER BY c.name || ' (' || we.job_title || ')'
    ) AS used_at,
    ptp.proficiency_level,
    ptp.years_of_experience
FROM technologies t
JOIN skill_categories sc ON t.category_id = sc.id
LEFT JOIN work_technologies wt ON wt.technology_id = t.id
LEFT JOIN work_experience we ON we.id = wt.work_experience_id
LEFT JOIN companies c ON c.id = we.company_id
LEFT JOIN personal_tech_proficiency ptp ON ptp.technology_id = t.id
GROUP BY t.id, t.name, sc.name_en, t.type, ptp.proficiency_level, ptp.years_of_experience
ORDER BY jobs_count DESC, t.name;

COMMENT ON VIEW v_technologies_usage IS 'Technologies with count and list of where they were used';

-- =====================================================
-- COMPLETE CV SUMMARY VIEW
-- =====================================================

CREATE OR REPLACE VIEW v_cv_summary AS
SELECT
    pi.first_name || ' ' || pi.last_name AS full_name,
    pi.professional_title,
    pi.email,
    pi.phone,
    pi.location_city || ', ' || pi.location_country AS location,
    -- Work experience summary
    (SELECT COUNT(*) FROM work_experience WHERE personal_info_id = pi.id) AS total_jobs,
    (SELECT MAX(start_date) FROM work_experience WHERE personal_info_id = pi.id AND is_current = true) AS current_job_since,
    -- Education summary
    (SELECT COUNT(*) FROM education WHERE personal_info_id = pi.id) AS total_degrees,
    (SELECT degree_type || ' in ' || field_of_study
     FROM education
     WHERE personal_info_id = pi.id
     ORDER BY end_date DESC
     LIMIT 1) AS highest_degree,
    -- Skills summary
    (SELECT COUNT(*) FROM personal_tech_proficiency WHERE personal_info_id = pi.id) AS total_skills,
    (SELECT COUNT(*) FROM personal_tech_proficiency WHERE personal_info_id = pi.id AND is_featured = true) AS featured_skills,
    -- Languages summary
    (SELECT COUNT(*) FROM personal_languages WHERE personal_info_id = pi.id) AS total_languages,
    -- Most experienced technology
    (SELECT t.name
     FROM personal_tech_proficiency ptp
     JOIN technologies t ON ptp.technology_id = t.id
     WHERE ptp.personal_info_id = pi.id
     ORDER BY ptp.years_of_experience DESC
     LIMIT 1) AS most_experienced_tech
FROM personal_info pi;

COMMENT ON VIEW v_cv_summary IS 'High-level CV summary with key statistics';

-- =====================================================
-- END OF VIEWS
-- =====================================================