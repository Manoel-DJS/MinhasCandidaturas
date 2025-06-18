package com.tec.api_candidatura.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tec.api_candidatura.entity.enums.StatusCandidature;
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
@Table(name = "tb_candidatures")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusCandidature")
    private StatusCandidature statusCandidature;

    @Column(name = "createdCandi_date", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(name = "updateCandi_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "job_vacancy_id")
    private JobVacancy jobVacancy;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    private void prePersist(){
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
