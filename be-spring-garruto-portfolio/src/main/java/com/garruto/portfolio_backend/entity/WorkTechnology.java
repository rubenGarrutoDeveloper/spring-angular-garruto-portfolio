package com.garruto.portfolio_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_technologies",
        uniqueConstraints = @UniqueConstraint(columnNames = {"work_experience_id", "technology_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_experience_id", nullable = false)
    private WorkExperience workExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "technology_id", nullable = false)
    private Technology technology;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}