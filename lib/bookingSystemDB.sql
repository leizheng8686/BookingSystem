
create database courseBooking;
use courseBooking;
/*
drop table grade;
drop table user_teacher;
drop table user_stu;
drop table courseinfo;
drop table course;
drop table student;
drop table class;
drop table dept;
drop table college;
*/

create table college(
collID char(2) primary key,collName varchar(60) not null
);

create table dept(
deptID char(4) primary key,collID char(2) not null,deptName varchar(60),
constraint dept_fk foreign key(collID) references college(collID)
);


create table major(
majorID char(6) primary key, deptID char(4), collID char(2) not null,
majorName varchar(60) not null,
constraint class_fk1 foreign key(deptID) references dept(deptID),
constraint class_fk2 foreign key(collID) references college(collID)
);


create table student(
stuID char(12) primary key,firstame varchar(20) not null,middlename varchar(20),lastname varchar(20) not null, 
stuGender char(6) check(stuGender='Male' or stuGender='Female'),
stuBirth date,nationality varchar(15),
collID char(2) not null,deptID char(4), majorID char(6) not null,
enrollTime date not null, graduateTime date,
constraint stu_fk1 foreign key(deptID) references dept(deptID),
constraint stu_fk2 foreign key(collID) references college(collID),
constraint stu_fk3 foreign key(majorID) references major(majorID)
);

create table course(
courseID char(8) primary key,courseName varchar(50) not null,credit numeric(3,1) not null,
collID char(2) not null, deptID char(4), majorID char(6) not null,
constraint cou_fk1 foreign key(deptID) references dept(deptID),
constraint cou_fk2 foreign key(collID) references college(collID),
constraint cou_fk3 foreign key(majorID) references major(majorID)
);

create table courseinfo(
courseID char(8),courseDay char(1),courseTime char(1), location char(6), teacher varchar(20) not null,
capacity tinyint unsigned default 30, restCapacity tinyint unsigned default 30,
description varchar(1000),
constraint couinfo_fk1 foreign key(courseID) references course(courseID),
constraint couinfo_key primary key(courseID,courseDay,courseTime,location)
);

create table grade(
stuID char(12),courseID char(8),grade tinyint unsigned default 0, credit numeric(4,1) default 0,
constraint grade_fk1 foreign key(courseID) references course(courseID),
constraint grade_fk2 foreign key(stuID) references student(stuID),
constraint grade_key primary key(stuID,courseID)
);

create table user_admin(
ID char(12) primary key,
PWD char(15) not null
);

create table user_stu(
stuID char(12) primary key,
PWD char(15) not null,
constraint user2_fk foreign key(stuID) references student(stuID)
);

insert into college values('01','School of Engineering & Science');
insert into college values('02','School of Business');
insert into college values('03','School of Systems & Enterprises');
insert into college values('04','College of Arts and Letters');

insert into dept values('0101','01','Computer Science');
insert into dept values('0102','01','Chemical Engineering & Materials Science');
insert into dept values('0103','01','Civil, Environmental & Ocean Engineering');
insert into dept values('0104','01','Electrical & Computer Engineering');
insert into dept values('0105','01','Mathematical Sciences');
insert into dept values('0106','01','Physics & Engineering Physics');

insert into major values('010401', '0104', '01','Electrical Engineering');
insert into major values('010402', '0104', '01','Computer Engineering');
insert into major values('010403', '0104', '01','Information and Data Engineering');
insert into major values('010101', '0101', '01','Computer Science');

insert into student values('10399614','Lei', '', 'Zheng', 'Male','1999-9-9','China','01','0104','010402','2015-9-1', '2017-5-15');
#insert into student values('10399614','Lei', '', 'Zheng', 'Male','1999-9-9','China','01','0104','010303','2015-9-1');

insert into user_stu values('10399614','10399614');
#insert into user_stu values('200501030218','200501030218');
#insert into user_stu values('200501020319','200501020319');
#insert into user_stu values('200502020319','200502020319');

insert into user_admin values('Lei','123456');
insert into user_admin values('Shengkai','123456');

insert into course values('EE810J','Engineering Programming: Java', 3.0,'01','0104', '010401');
insert into course values('EE810C','Engineering Programming: C++', 3.0,'01','0104', '010401');
insert into course values('CPE593B','Applied Data Structures and Algorithms', 3.0,'01','0104', '010402');
insert into course values('CPE695','Applied Machine Learning', 3.0,'01','0104', '010402');
insert into course values('CS561B','Database Management Systems I', 3.0,'01','0101', '010101');
insert into course values('CS555','Agile Methods for Software Developement', 3.0,'01','0101', '010101');

insert into courseinfo values('EE810J','1','3','X106', 'Dov Kruger', 30, 30, 'Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,[13] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA),[14] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[15] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture.');
insert into courseinfo values('EE810C','3','3','EE715', 'Dov Kruger ', 30, 30, 'Hello, I am an introduction.');
insert into courseinfo values('CPE593B','2','3','M205', 'Dov Kruger', 30, 30, 'Hello, I am an introduction.');
insert into courseinfo values('CPE695','3','4','BC210', 'Duan', 30, 30, 'Hello, I am an introduction.');
insert into courseinfo values('CS561B','4','4','E222', 'Kim Samuel', 30, 30, 'Hello, I am an introduction.');
insert into courseinfo values('CS555','3','3','BC304', 'Rowland James', 30, 30, 'Hello, I am an introduction.');

