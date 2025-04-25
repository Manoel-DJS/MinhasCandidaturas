CREATE TABLE tb_candidatures (
    id SERIAL PRIMARY KEY,
    status_candidature VARCHAR(20) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP,
    job_id BIGINT NOT NULL,
    user_id UUID NOT NULL,
    CONSTRAINT fk_candidature_job_vacancy FOREIGN KEY (job_id) REFERENCES tb_job_vacancies(id) ON DELETE CASCADE,
    CONSTRAINT fk_candidature_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
)