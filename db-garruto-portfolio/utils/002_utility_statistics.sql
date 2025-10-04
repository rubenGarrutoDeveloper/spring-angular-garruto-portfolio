-- =====================================================
-- Utility Scripts - Database Statistics
-- File: 002_utility_statistics.sql
-- Description: Queries for database metrics, performance, and analysis
-- =====================================================

-- =====================================================
-- TABLE SIZE STATISTICS
-- =====================================================

-- Get size of all tables
SELECT
    schemaname,
    tablename,
    pg_size_pretty(pg_total_relation_size(schemaname||'.'||tablename)) AS total_size,
    pg_size_pretty(pg_relation_size(schemaname||'.'||tablename)) AS table_size,
    pg_size_pretty(pg_total_relation_size(schemaname||'.'||tablename) - pg_relation_size(schemaname||'.'||tablename)) AS indexes_size
FROM pg_tables
WHERE schemaname = 'public'
ORDER BY pg_total_relation_size(schemaname||'.'||tablename) DESC;

-- Total database size
SELECT
    pg_size_pretty(pg_database_size(current_database())) AS database_size;

-- =====================================================
-- INDEX STATISTICS
-- =====================================================

-- List all indexes with their sizes
SELECT
    schemaname,
    tablename,
    indexname,
    pg_size_pretty(pg_relation_size(indexrelid)) AS index_size
FROM pg_indexes
JOIN pg_class ON pg_class.relname = indexname
WHERE schemaname = 'public'
ORDER BY pg_relation_size(indexrelid) DESC;

-- Index usage statistics
SELECT
    schemaname,
    tablename,
    indexname,
    idx_scan AS number_of_scans,
    idx_tup_read AS tuples_read,
    idx_tup_fetch AS tuples_fetched
FROM pg_stat_user_indexes
WHERE schemaname = 'public'
ORDER BY idx_scan DESC;

-- Unused indexes (never scanned)
SELECT
    schemaname,
    tablename,
    indexname,
    pg_size_pretty(pg_relation_size(indexrelid)) AS index_size
FROM pg_stat_user_indexes
WHERE schemaname = 'public'
  AND idx_scan = 0
  AND indexname NOT LIKE '%_pkey'
ORDER BY pg_relation_size(indexrelid) DESC;

-- =====================================================
-- ROW COUNT STATISTICS
-- =====================================================

-- Detailed row counts with estimated sizes
SELECT
    schemaname,
    relname AS table_name,
    n_live_tup AS row_count,
    pg_size_pretty(pg_total_relation_size(relid)) AS total_size,
    ROUND(pg_total_relation_size(relid)::numeric / NULLIF(n_live_tup, 0), 2) AS bytes_per_row
FROM pg_stat_user_tables
WHERE schemaname = 'public'
ORDER BY n_live_tup DESC;

-- =====================================================
-- WORK EXPERIENCE STATISTICS
-- =====================================================

-- Work experience duration statistics
SELECT
    'Total Work Experiences' AS metric,
    COUNT(*)::text AS value
FROM work_experience
UNION ALL
SELECT
    'Current Positions',
    COUNT(*)::text
FROM work_experience
WHERE is_current = true
UNION ALL
SELECT
    'Average Job Duration (months)',
    ROUND(AVG(
        CASE
            WHEN is_current THEN
                EXTRACT(YEAR FROM AGE(CURRENT_DATE, start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(CURRENT_DATE, start_date))
            ELSE
                EXTRACT(YEAR FROM AGE(end_date, start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(end_date, start_date))
        END
    ), 1)::text
FROM work_experience
UNION ALL
SELECT
    'Total Years of Experience',
    ROUND(SUM(
        CASE
            WHEN is_current THEN
                EXTRACT(YEAR FROM AGE(CURRENT_DATE, start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(CURRENT_DATE, start_date))
            ELSE
                EXTRACT(YEAR FROM AGE(end_date, start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(end_date, start_date))
        END
    ) / 12.0, 1)::text
FROM work_experience;

-- Work experience by company
SELECT
    c.name AS company,
    c.sector,
    COUNT(we.id) AS positions_count,
    MIN(we.start_date) AS first_position_start,
    MAX(COALESCE(we.end_date, CURRENT_DATE)) AS last_position_end,
    ROUND(SUM(
        CASE
            WHEN we.is_current THEN
                EXTRACT(YEAR FROM AGE(CURRENT_DATE, we.start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(CURRENT_DATE, we.start_date))
            ELSE
                EXTRACT(YEAR FROM AGE(we.end_date, we.start_date)) * 12 +
                EXTRACT(MONTH FROM AGE(we.end_date, we.start_date))
        END
    ) / 12.0, 1) AS total_years
FROM companies c
JOIN work_experience we ON we.company_id = c.id
GROUP BY c.id, c.name, c.sector
ORDER BY first_position_start DESC;

-- =====================================================
-- TECHNOLOGY STATISTICS
-- =====================================================

-- Technology usage across jobs
SELECT
    t.name AS technology,
    sc.name_en AS category,
    COUNT(DISTINCT wt.work_experience_id) AS used_in_jobs,
    ptp.proficiency_level,
    ptp.years_of_experience
FROM technologies t
JOIN skill_categories sc ON t.category_id = sc.id
LEFT JOIN work_technologies wt ON wt.technology_id = t.id
LEFT JOIN personal_tech_proficiency ptp ON ptp.technology_id = t.id
GROUP BY t.id, t.name, sc.name_en, ptp.proficiency_level, ptp.years_of_experience
ORDER BY used_in_jobs DESC, t.name;

-- Technologies by category with counts
SELECT
    sc.name_en AS category,
    sc.code,
    COUNT(t.id) AS total_technologies,
    COUNT(ptp.id) AS with_proficiency,
    COUNT(CASE WHEN ptp.is_featured THEN 1 END) AS featured_count,
    ROUND(AVG(ptp.years_of_experience), 1) AS avg_years_experience
FROM skill_categories sc
LEFT JOIN technologies t ON t.category_id = sc.id
LEFT JOIN personal_tech_proficiency ptp ON ptp.technology_id = t.id
GROUP BY sc.id, sc.name_en, sc.code, sc.display_order
ORDER BY sc.display_order;

-- Proficiency level distribution
SELECT
    proficiency_level,
    COUNT(*) AS count,
    ROUND(COUNT(*) * 100.0 / SUM(COUNT(*)) OVER (), 1) AS percentage
FROM personal_tech_proficiency
GROUP BY proficiency_level
ORDER BY
    CASE proficiency_level
        WHEN 'Advanced' THEN 1
        WHEN 'Intermediate' THEN 2
        WHEN 'Base' THEN 3
        ELSE 4
    END;

-- Most experienced technologies
SELECT
    t.name AS technology,
    sc.name_en AS category,
    ptp.years_of_experience,
    ptp.proficiency_level,
    ptp.is_featured
FROM personal_tech_proficiency ptp
JOIN technologies t ON ptp.technology_id = t.id
JOIN skill_categories sc ON t.category_id = sc.id
ORDER BY ptp.years_of_experience DESC, t.name
LIMIT 10;

-- =====================================================
-- EDUCATION STATISTICS
-- =====================================================

-- Education summary
SELECT
    degree_type,
    COUNT(*) AS count,
    AVG(EXTRACT(YEAR FROM end_date) - EXTRACT(YEAR FROM start_date)) AS avg_duration_years
FROM education
WHERE degree_type IS NOT NULL
GROUP BY degree_type
ORDER BY
    CASE degree_type
        WHEN 'Master' THEN 1
        WHEN 'Bachelor' THEN 2
        WHEN 'High School Diploma' THEN 3
        ELSE 4
    END;

-- =====================================================
-- RESPONSIBILITIES AND ACHIEVEMENTS
-- =====================================================

-- Responsibilities per job statistics
SELECT
    'Average Responsibilities per Job' AS metric,
    ROUND(AVG(responsibility_count), 1)::text AS value
FROM (
    SELECT
        we.id,
        COUNT(wr.id) AS responsibility_count
    FROM work_experience we
    LEFT JOIN work_responsibilities wr ON wr.work_experience_id = we.id
    GROUP BY we.id
) subquery
UNION ALL
SELECT
    'Jobs with Achievements',
    COUNT(DISTINCT work_experience_id)::text
FROM work_achievements
UNION ALL
SELECT
    'Average Achievements per Job (with achievements)',
    ROUND(AVG(achievement_count), 1)::text
FROM (
    SELECT
        work_experience_id,
        COUNT(*) AS achievement_count
    FROM work_achievements
    GROUP BY work_experience_id
) subquery
UNION ALL
SELECT
    'Average Technologies per Job',
    ROUND(AVG(tech_count), 1)::text
FROM (
    SELECT
        we.id,
        COUNT(wt.id) AS tech_count
    FROM work_experience we
    LEFT JOIN work_technologies wt ON wt.work_experience_id = we.id
    GROUP BY we.id
) subquery;

-- =====================================================
-- LANGUAGE STATISTICS
-- =====================================================

-- Language proficiency summary
SELECT
    language_name_en AS language,
    proficiency_level,
    is_native,
    certificate_name,
    CASE
        WHEN certificate_score IS NOT NULL
        THEN certificate_score || '/' || certificate_max_score
        ELSE NULL
    END AS certificate_score
FROM personal_languages
ORDER BY display_order;

-- =====================================================
-- RECENT ACTIVITY
-- =====================================================

-- Most recently updated records (top 10)
SELECT
    'personal_info' AS table_name,
    id::text AS record_id,
    updated_at
FROM personal_info
UNION ALL
SELECT 'education', id::text, updated_at FROM education
UNION ALL
SELECT 'work_experience', id::text, updated_at FROM work_experience
UNION ALL
SELECT 'technologies', id::text, updated_at FROM technologies
UNION ALL
SELECT 'personal_tech_proficiency', id::text, updated_at FROM personal_tech_proficiency
ORDER BY updated_at DESC
LIMIT 10;

-- =====================================================
-- COMPREHENSIVE PORTFOLIO SUMMARY
-- =====================================================

-- Complete portfolio statistics
SELECT 'PERSONAL INFORMATION' AS section, '---' AS metric, '---' AS value
UNION ALL
SELECT '', 'Total Persons', COUNT(*)::text FROM personal_info
UNION ALL
SELECT '', 'Total Education Records', COUNT(*)::text FROM education
UNION ALL
SELECT '', 'Total Languages', COUNT(*)::text FROM personal_languages
UNION ALL
SELECT 'WORK EXPERIENCE' AS section, '---' AS metric, '---' AS value
UNION ALL
SELECT '', 'Total Companies', COUNT(*)::text FROM companies
UNION ALL
SELECT '', 'Total Positions', COUNT(*)::text FROM work_experience
UNION ALL
SELECT '', 'Total Responsibilities', COUNT(*)::text FROM work_responsibilities
UNION ALL
SELECT '', 'Total Achievements', COUNT(*)::text FROM work_achievements
UNION ALL
SELECT 'TECHNICAL SKILLS' AS section, '---' AS metric, '---' AS value
UNION ALL
SELECT '', 'Total Skill Categories', COUNT(*)::text FROM skill_categories
UNION ALL
SELECT '', 'Total Technologies', COUNT(*)::text FROM technologies
UNION ALL
SELECT '', 'Technologies with Proficiency', COUNT(*)::text FROM personal_tech_proficiency
UNION ALL
SELECT '', 'Featured Skills', COUNT(*)::text FROM personal_tech_proficiency WHERE is_featured = true;

-- =====================================================
-- END OF STATISTICS
-- =====================================================