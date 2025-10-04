-- =====================================================
-- Utility Scripts - Data Checks and Validation
-- File: 001_utility_data_checks.sql
-- Description: Queries to verify data integrity and check relationships
-- =====================================================

-- =====================================================
-- RECORD COUNTS
-- =====================================================

-- Count records in all main tables
SELECT 'personal_info' AS table_name, COUNT(*) AS record_count FROM personal_info
UNION ALL
SELECT 'education', COUNT(*) FROM education
UNION ALL
SELECT 'companies', COUNT(*) FROM companies
UNION ALL
SELECT 'work_experience', COUNT(*) FROM work_experience
UNION ALL
SELECT 'work_responsibilities', COUNT(*) FROM work_responsibilities
UNION ALL
SELECT 'work_achievements', COUNT(*) FROM work_achievements
UNION ALL
SELECT 'work_technologies', COUNT(*) FROM work_technologies
UNION ALL
SELECT 'skill_categories', COUNT(*) FROM skill_categories
UNION ALL
SELECT 'technologies', COUNT(*) FROM technologies
UNION ALL
SELECT 'personal_tech_proficiency', COUNT(*) FROM personal_tech_proficiency
UNION ALL
SELECT 'personal_languages', COUNT(*) FROM personal_languages
ORDER BY table_name;

-- =====================================================
-- FOREIGN KEY INTEGRITY CHECKS
-- =====================================================

-- Check for orphaned education records (no matching personal_info)
SELECT 'Orphaned Education Records' AS check_name, COUNT(*) AS issues
FROM education e
WHERE NOT EXISTS (SELECT 1 FROM personal_info pi WHERE pi.id = e.personal_info_id);

-- Check for orphaned work_experience records
SELECT 'Orphaned Work Experience Records' AS check_name, COUNT(*) AS issues
FROM work_experience we
WHERE NOT EXISTS (SELECT 1 FROM personal_info pi WHERE pi.id = we.personal_info_id)
   OR NOT EXISTS (SELECT 1 FROM companies c WHERE c.id = we.company_id);

-- Check for orphaned work_responsibilities
SELECT 'Orphaned Work Responsibilities' AS check_name, COUNT(*) AS issues
FROM work_responsibilities wr
WHERE NOT EXISTS (SELECT 1 FROM work_experience we WHERE we.id = wr.work_experience_id);

-- Check for orphaned work_achievements
SELECT 'Orphaned Work Achievements' AS check_name, COUNT(*) AS issues
FROM work_achievements wa
WHERE NOT EXISTS (SELECT 1 FROM work_experience we WHERE we.id = wa.work_experience_id);

-- Check for orphaned work_technologies
SELECT 'Orphaned Work Technologies' AS check_name, COUNT(*) AS issues
FROM work_technologies wt
WHERE NOT EXISTS (SELECT 1 FROM work_experience we WHERE we.id = wt.work_experience_id)
   OR NOT EXISTS (SELECT 1 FROM technologies t WHERE t.id = wt.technology_id);

-- Check for orphaned technologies (no matching category)
SELECT 'Orphaned Technologies' AS check_name, COUNT(*) AS issues
FROM technologies t
WHERE NOT EXISTS (SELECT 1 FROM skill_categories sc WHERE sc.id = t.category_id);

-- Check for orphaned personal_tech_proficiency
SELECT 'Orphaned Tech Proficiency Records' AS check_name, COUNT(*) AS issues
FROM personal_tech_proficiency ptp
WHERE NOT EXISTS (SELECT 1 FROM personal_info pi WHERE pi.id = ptp.personal_info_id)
   OR NOT EXISTS (SELECT 1 FROM technologies t WHERE t.id = ptp.technology_id);

-- Check for orphaned personal_languages
SELECT 'Orphaned Language Records' AS check_name, COUNT(*) AS issues
FROM personal_languages pl
WHERE NOT EXISTS (SELECT 1 FROM personal_info pi WHERE pi.id = pl.personal_info_id);

-- =====================================================
-- DATA COMPLETENESS CHECKS
-- =====================================================

-- Check for work experiences without responsibilities
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    we.start_date,
    'No Responsibilities' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE NOT EXISTS (
    SELECT 1 FROM work_responsibilities wr WHERE wr.work_experience_id = we.id
);

-- Check for work experiences without technologies
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    we.start_date,
    'No Technologies Linked' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE NOT EXISTS (
    SELECT 1 FROM work_technologies wt WHERE wt.work_experience_id = we.id
);

-- Check for technologies without any proficiency records
SELECT
    t.id,
    t.name,
    sc.name_en AS category,
    'No Proficiency Record' AS issue
FROM technologies t
JOIN skill_categories sc ON t.category_id = sc.id
WHERE NOT EXISTS (
    SELECT 1 FROM personal_tech_proficiency ptp WHERE ptp.technology_id = t.id
);

-- Check for personal_info without any work experience
SELECT
    pi.id,
    pi.first_name || ' ' || pi.last_name AS name,
    'No Work Experience' AS issue
FROM personal_info pi
WHERE NOT EXISTS (
    SELECT 1 FROM work_experience we WHERE we.personal_info_id = pi.id
);

-- =====================================================
-- DATA QUALITY CHECKS
-- =====================================================

-- Check for missing required email addresses
SELECT
    id,
    first_name || ' ' || last_name AS name,
    'Missing Email' AS issue
FROM personal_info
WHERE email IS NULL OR email = '';

-- Check for work experiences with invalid date ranges
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    we.start_date,
    we.end_date,
    'Invalid Date Range' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE we.end_date IS NOT NULL
  AND we.end_date < we.start_date;

-- Check for education with invalid date ranges
SELECT
    e.id,
    e.institution_name,
    e.degree_type,
    e.start_date,
    e.end_date,
    'Invalid Date Range' AS issue
FROM education e
WHERE e.end_date IS NOT NULL
  AND e.end_date < e.start_date;

-- Check for current jobs with end_date set
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    we.is_current,
    we.end_date,
    'Current Job Has End Date' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE we.is_current = true
  AND we.end_date IS NOT NULL;

-- Check for non-current jobs without end_date
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    we.is_current,
    we.end_date,
    'Past Job Missing End Date' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE we.is_current = false
  AND we.end_date IS NULL;

-- Check for duplicate technology proficiencies
SELECT
    personal_info_id,
    technology_id,
    COUNT(*) AS duplicate_count
FROM personal_tech_proficiency
GROUP BY personal_info_id, technology_id
HAVING COUNT(*) > 1;

-- Check for duplicate work_technologies entries
SELECT
    work_experience_id,
    technology_id,
    COUNT(*) AS duplicate_count
FROM work_technologies
GROUP BY work_experience_id, technology_id
HAVING COUNT(*) > 1;

-- =====================================================
-- BILINGUAL CONTENT CHECKS
-- =====================================================

-- Check for missing Italian descriptions in work_experience
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    'Missing Italian Description' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE we.description_it IS NULL OR TRIM(we.description_it) = '';

-- Check for missing English descriptions in work_experience
SELECT
    we.id,
    c.name AS company,
    we.job_title,
    'Missing English Description' AS issue
FROM work_experience we
JOIN companies c ON we.company_id = c.id
WHERE we.description_en IS NULL OR TRIM(we.description_en) = '';

-- Check for missing Italian descriptions in technologies
SELECT
    t.id,
    t.name,
    'Missing Italian Description' AS issue
FROM technologies t
WHERE t.description_it IS NULL OR TRIM(t.description_it) = '';

-- Check for missing English descriptions in technologies
SELECT
    t.id,
    t.name,
    'Missing English Description' AS issue
FROM technologies t
WHERE t.description_en IS NULL OR TRIM(t.description_en) = '';

-- =====================================================
-- SUMMARY REPORT
-- =====================================================

-- Comprehensive data quality summary
SELECT
    'Total Records' AS metric,
    (SELECT COUNT(*) FROM personal_info) +
    (SELECT COUNT(*) FROM education) +
    (SELECT COUNT(*) FROM work_experience) +
    (SELECT COUNT(*) FROM technologies) +
    (SELECT COUNT(*) FROM personal_tech_proficiency) AS value
UNION ALL
SELECT
    'Total Work Experiences',
    (SELECT COUNT(*) FROM work_experience)
UNION ALL
SELECT
    'Work Experiences with Responsibilities',
    (SELECT COUNT(DISTINCT work_experience_id) FROM work_responsibilities)
UNION ALL
SELECT
    'Work Experiences with Achievements',
    (SELECT COUNT(DISTINCT work_experience_id) FROM work_achievements)
UNION ALL
SELECT
    'Work Experiences with Technologies',
    (SELECT COUNT(DISTINCT work_experience_id) FROM work_technologies)
UNION ALL
SELECT
    'Total Technologies',
    (SELECT COUNT(*) FROM technologies)
UNION ALL
SELECT
    'Technologies with Proficiency',
    (SELECT COUNT(DISTINCT technology_id) FROM personal_tech_proficiency)
UNION ALL
SELECT
    'Featured Skills',
    (SELECT COUNT(*) FROM personal_tech_proficiency WHERE is_featured = true)
UNION ALL
SELECT
    'Total Languages',
    (SELECT COUNT(*) FROM personal_languages);

-- =====================================================
-- END OF DATA CHECKS
-- =====================================================