-- Remove constraint de unicidade incorreta que impede mais de uma candidatura por vaga
DO $$
DECLARE
    constraint_name TEXT;
BEGIN
    SELECT conname INTO constraint_name
    FROM pg_constraint
    WHERE conrelid = 'tb_candidatures'::regclass
      AND contype = 'u'
      AND conkey = ARRAY[
          (SELECT attnum FROM pg_attribute
           WHERE attrelid = 'tb_candidatures'::regclass AND attname = 'job_vacancy_id')
      ];

    IF constraint_name IS NOT NULL THEN
        EXECUTE format('ALTER TABLE tb_candidatures DROP CONSTRAINT %I', constraint_name);
    END IF;
END$$;

