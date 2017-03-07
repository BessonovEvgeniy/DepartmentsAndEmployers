INSERT INTO departments (name) VALUES ('Dep 1');
INSERT INTO departments (name) VALUES ('Dep 2');
INSERT INTO departments (name) VALUES ('Dep 3');

INSERT INTO employers (department_id, name, email, birthday, rank) VALUES (1, 'Emp 1', 'emp1@gmail.com', NOW(), 1);
INSERT INTO employers (department_id, name, email, birthday, rank) VALUES (1, 'Emp 2', 'emp2@gmail.com', NOW(), 2);
INSERT INTO employers (department_id, name, email, birthday, rank) VALUES (2, 'Emp 3', 'emp3@gmail.com', NOW(), 3);
