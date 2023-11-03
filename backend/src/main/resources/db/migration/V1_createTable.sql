CREATE TABLE employees (
    id UUID PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    birth_date DATE,
    account_id UUID,
    task_id UUID,
    project_uuid UUID,
  )