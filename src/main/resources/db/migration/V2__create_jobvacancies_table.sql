CREATE TABLE tb_job_vacancies(
    id SERIAL PRIMARY KEY NOT NULL,
    title VARCHAR(100) NOT NULL,
    job_company VARCHAR(100) NOT NULL,
    job_Description TEXT NOT NULL,
    location VARCHAR(120) NOT NULL,
    job_vacancy_type VARCHAR(30) NOT NULL,
    job_vacancy_status VARCHAR(30) NOT NULL,
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP,
    user_id UUID NOT NULL,
    CONSTRAINT fk_job_vacancies_user FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE
)