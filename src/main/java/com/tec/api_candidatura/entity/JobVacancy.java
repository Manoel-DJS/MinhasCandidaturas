package com.tec.api_candidatura.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tec.api_candidatura.entity.enums.JobVacancyStatus;
import com.tec.api_candidatura.entity.enums.JobVacancyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_job_vacancies")
public class JobVacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String jobTitle;
    @Column(nullable = false, length = 100)
    private String jobCompany;
    @Column(nullable = false)
    private String jobDescription;
    @Column(nullable = false, length = 120)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_vacancy_type")
    private JobVacancyType jobVacancyType;

    @Enumerated (EnumType.STRING)
    @Column(name = "job_vacancy_status")
    private JobVacancyStatus jobVacancyStatus;

    @Column(name = "created_jog_vacancy", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(name = "updated_job_vacancy")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "jobVacancy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Candidature candidature;

    @PrePersist
    private void prePersist(){
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedDate = LocalDateTime.now();
    }

}
