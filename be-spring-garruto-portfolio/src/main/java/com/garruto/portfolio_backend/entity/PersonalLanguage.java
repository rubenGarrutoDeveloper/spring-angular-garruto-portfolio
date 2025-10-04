package com.garruto.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "personal_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonalLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_info_id", nullable = false)
    private PersonalInfo personalInfo;

    @Column(name = "language_name_it", nullable = false, length = 100)
    private String languageNameIt;

    @Column(name = "language_name_en", nullable = false, length = 100)
    private String languageNameEn;

    @Column(name = "proficiency_level", length = 50)
    private String proficiencyLevel;

    @Column(name = "is_native")
    @Builder.Default
    private Boolean isNative = false;

    @Column(name = "certificate_name", length = 255)
    private String certificateName;

    @Column(name = "certificate_score", length = 50)
    private String certificateScore;

    @Column(name = "certificate_max_score", length = 50)
    private String certificateMaxScore;

    @Column(name = "certificate_date")
    private LocalDate certificateDate;

    @Column(name = "certificate_url", length = 500)
    private String certificateUrl;

    @Column(name = "notes_it", columnDefinition = "TEXT")
    private String notesIt;

    @Column(name = "notes_en", columnDefinition = "TEXT")
    private String notesEn;

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