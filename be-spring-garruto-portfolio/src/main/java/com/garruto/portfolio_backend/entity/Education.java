package com.garruto.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "education")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_info_id", nullable = false)
    private PersonalInfo personalInfo;

    @Column(name = "institution_name", nullable = false, length = 255)
    private String institutionName;

    @Column(name = "institution_location", length = 255)
    private String institutionLocation;

    @Column(name = "degree_type", length = 100)
    private String degreeType;

    @Column(name = "field_of_study", length = 255)
    private String fieldOfStudy;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(length = 50)
    private String grade;

    @Column(name = "grade_max", length = 50)
    private String gradeMax;

    @Column(name = "thesis_title_it", columnDefinition = "TEXT")
    private String thesisTitleIt;

    @Column(name = "thesis_title_en", columnDefinition = "TEXT")
    private String thesisTitleEn;

    @Column(name = "thesis_description_it", columnDefinition = "TEXT")
    private String thesisDescriptionIt;

    @Column(name = "thesis_description_en", columnDefinition = "TEXT")
    private String thesisDescriptionEn;

    @Column(name = "display_order")
    @Builder.Default
    private Integer displayOrder = 0;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}