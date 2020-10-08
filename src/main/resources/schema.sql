DROP TABLE IF EXISTS student;
CREATE TABLE student (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    birth_date DATE NOT NULL,
    jmbag VARCHAR(10) NOT NULL,
    number_of_ects INT
);

DROP TABLE IF EXISTS course;
CREATE TABLE course (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    number_of_ects INT NOT NULL,
    semester SMALLINT
);

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS  authority;
CREATE  TABLE authority(
    id INT AUTO_INCREMENT PRIMARY  KEY,
    name VARCHAR(250) NOT NULL
);


DROP TABLE IF EXISTS student_course;
CREATE TABLE student_course (
    student_id INT,
    course_id INT
);


DROP TABLE IF EXISTS user_authority;
CREATE TABLE user_authority(
    user_id bigint not null,
    authority_id bigint not null,
    constraint fk_user foreign key (user_id) references user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);

