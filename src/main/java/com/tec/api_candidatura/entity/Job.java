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
@Table(name = "tb_jobvacancy")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long job_id;

    @Column(nullable = false, length = 100)
    private String jobTitle;
    @Column(nullable = false, length = 100)
    private String jobCompany;
    @Column(nullable = false, length = 250)
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
    private LocalDateTime createdJobVacancy;

    @Column(name = "updated_job_vacancy")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedJobVacancy;

    @PrePersist
    private void prePersist(){
        this.createdJobVacancy = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updatedJobVacancy = LocalDateTime.now();
    }

}
