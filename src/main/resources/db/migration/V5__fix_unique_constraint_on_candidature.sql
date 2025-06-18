-- Remove a constraint antiga errada
ALTER TABLE tb_candidatures DROP CONSTRAINT IF EXISTS uklpjja0fxlm1lk1r7tc01v0v76;

-- Adiciona a constraint correta
ALTER TABLE tb_candidatures
ADD CONSTRAINT unique_user_job UNIQUE (user_id, job_vacancy_id);
