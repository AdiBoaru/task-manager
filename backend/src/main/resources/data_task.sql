-- Task 1
INSERT INTO tasks(uuid, id, name, description, start_date, due_date, status, priority)
VALUES (UUID(),1, 'Task 1', 'Complete the project report', '2023-11-06', '2023-11-15', 'WORK_IN_PROGRESS', 'High');

-- Task 2
INSERT INTO tasks(uuid, id, name, description, start_date, due_date, status, priority)
VALUES (UUID(),2, 'Task 2', 'Prepare for the presentation', '2023-11-08', '2023-11-14', 'WORK_IN_PROGRESS', 'Medium');

-- Task 3
INSERT INTO tasks(uuid, id, name, description, start_date, due_date, status, priority)
VALUES (UUID(),3, 'Task 3', 'Review code changes', '2023-11-10', '2023-11-18', 'WORK_IN_PROGRESS', 'Low');

-- Task 4
INSERT INTO tasks(uuid, id, name, description, start_date, due_date, status, priority)
VALUES (UUID(),4, 'Task 4', 'Test new feature', '2023-11-12', '2023-11-17', 'WORK_IN_PROGRESS', 'High');

-- Task 5
INSERT INTO tasks(uuid, id, name, description, start_date, due_date, status, priority)
VALUES (UUID(),5, 'Task 5', 'Update documentation', '2023-11-14', '2023-11-20', 'WORK_IN_PROGRESS', 'Medium');
