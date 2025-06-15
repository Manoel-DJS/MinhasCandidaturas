package com.tec.api_candidatura.repository;

import com.tec.api_candidatura.entity.JobVacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobVacancyRepository extends JpaRepository<JobVacancy, Long> {

}
