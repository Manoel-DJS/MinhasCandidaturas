package com.tec.api_candidatura.repository;

import com.tec.api_candidatura.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatureRepository extends JpaRepository <Candidature, Long>{
    Optional<Candidature> findByUserIdAndJobVacancyId(UUID userId, long jobVacancyId);
}
