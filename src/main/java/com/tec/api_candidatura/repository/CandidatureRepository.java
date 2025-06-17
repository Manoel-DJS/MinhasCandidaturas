package com.tec.api_candidatura.repository;

import com.tec.api_candidatura.entity.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository <Candidature, Long>{

}
