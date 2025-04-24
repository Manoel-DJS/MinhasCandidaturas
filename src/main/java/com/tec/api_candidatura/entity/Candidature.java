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
@Table(name = "tb_candidature")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long candidature_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "statusCandidature")
    private StatusCandidature statusCandidature;

    @Column(name = "createdCandi_date", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime candidatureDate;

    @Column(name = "updateCandi_date")
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updateDate;

    @PrePersist
    private void prePersist(){
        this.candidatureDate = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
