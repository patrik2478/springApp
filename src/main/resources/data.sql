INSERT INTO student(first_name, last_name, birth_date, jmbag, number_of_ects)
VALUES ('Tomislav', 'Horvat', '1995-10-08', '0246077123', 120);
INSERT INTO student(first_name, last_name, birth_date, jmbag, number_of_ects)
VALUES ('Marija', 'Kovačević', '1995-10-05', '0246077222', 90);
INSERT INTO student(first_name, last_name, birth_date, jmbag, number_of_ects)
VALUES ('Novak', 'Đoković', '1990-10-03', '0246077242', 100);

INSERT INTO course (name, number_of_ects,semester)
VALUES ('Web aplikacije u Javi', 6,0);
INSERT INTO course (name, number_of_ects,semester)
VALUES ('Baze podataka', 5,1);
INSERT INTO course (name, number_of_ects,semester)
VALUES ('Matematika', 5,0);
INSERT INTO course (name, number_of_ects,semester)
VALUES ('Fizika', 5,1);

insert into user (id, username, password, first_name, last_name)
values (1, 'admin', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'admin', 'admin');
insert into user (id, username, password, first_name, last_name)
values (2, 'user', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'user', 'user');
insert into user (id, username, password, first_name, last_name)
values (3, 'deleter', '$2a$10$TYExkmI7uVXXVadrdTTa0OQTOorVV32jTjK.Py2BPQjEojbAx96yy', 'deleter', 'deleter');

INSERT INTO authority (name)
VALUES ('ROLE_ADMIN');
INSERT INTO authority (name)
VALUES ('ROLE_USER');
INSERT INTO authority (name)
VALUES ('DELETER');

insert into user_authority (user_id, authority_id)
values (1, 1);
insert into user_authority (user_id, authority_id)
values (2, 2);
insert into user_authority (user_id, authority_id)
values (3, 3);

INSERT INTO student_course VALUES (1, 1);
INSERT INTO student_course VALUES (1, 2);
INSERT INTO student_course VALUES (2, 1);
INSERT INTO student_course VALUES (2, 3);
INSERT INTO student_course VALUES (3, 1);
INSERT INTO student_course VALUES (3, 3);