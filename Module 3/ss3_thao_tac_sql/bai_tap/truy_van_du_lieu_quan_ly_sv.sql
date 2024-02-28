drop database if exists quan_ly_sinh_vien;
CREATE DATABASE if not exists quan_ly_sinh_vien;
USE quan_ly_sinh_vien;
CREATE TABLE class_room  
(
    Class_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Class_name VARCHAR(60) NOT NULL,
    Start_date DATETIME    NOT NULL,
    Status_class    BIT
);
CREATE TABLE student
(
    Student_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Student_name VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status_student      BIT,
    Class_id     INT         NOT NULL,
    FOREIGN KEY (Class_id) REFERENCES class_room (Class_id)
);
CREATE TABLE Subject_info  
(
    Sub_id   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sub_name VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status_subject  BIT                  DEFAULT 1
);

CREATE TABLE Mark
(
    Mark_id    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Sub_id     INT NOT NULL,
    Student_id INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    Exam_times TINYINT DEFAULT 1,
    UNIQUE (Sub_id, Student_id),
    FOREIGN KEY (Sub_id) REFERENCES Subject_info (Sub_id),
    FOREIGN KEY (Student_id) REFERENCES Student (Student_id)
);

INSERT INTO class_room(Class_id, Class_name, Start_date, Status_class)
VALUES (1, 'A1', '2008-12-20', 1),
       (2, 'A2', '2008-12-22', 1),
       (3, 'B3', current_date, 0);
       
INSERT INTO Student (Student_id ,Student_name, Address, Phone, Status_student, Class_id)
VALUES 	(1 ,'Hung', 'Ha Noi', '0912113113', 1, 1),
		(2 ,'Hoa', 'Hai phong',null, 1, 1),
        (3 ,'Manh', 'HCM', '0123123123', 0, 2);
        
INSERT INTO Subject_info( Sub_id, Sub_name, Credit, Status_subject)
VALUES 	(1, 'CF', 5, 1),
		(2, 'C', 6, 1),
		(3, 'HDJ', 5, 1),
		(4, 'RDBMS', 10, 1);
        
INSERT INTO Mark (Sub_id, Student_id, Mark, Exam_times)
VALUES 	(1, 1, 8, 1),
		(1, 2, 10, 2),
		(2, 1, 12, 1);
        
select Student_name 
from student
where Student_name like 'h%';

select *
from class_room
having month(Start_date) = 12;

select * 
from Subject_info
where Credit between 3 and 5;

set sql_safe_updates = 0;

update Student
set Class_id = 2
where Student_name = 'Hung';

set sql_safe_updates = 1;

select Student.Student_name, Subject_info.Sub_name, Mark.Mark
from Student, Subject_info, Mark
order by Mark desc, Student_name asc;
