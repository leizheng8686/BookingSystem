drop table grade;
drop table user_teacher;
drop table user_stu;
drop table courseinfo;
drop table course;
drop table student;
drop table class;
drop table dept;
drop table college;


create table college(
coll_id char(2) primary key,coll_name varchar(30) not null
);

create table dept(
dept_id char(4) primary key,coll_id char(2) not null,dept_name varchar(30),
constraint dept_fk foreign key(coll_id) references college(coll_id)
);

create table class(
class_id char(6) primary key,dept_id char(4) not null,coll_id char(2),
class_name varchar(6) not null,
constraint class_fk1 foreign key(dept_id) references dept(dept_id),
constraint class_fk2 foreign key(coll_id) references college(coll_id)
);

create table student(
stu_id char(12) primary key,stu_name varchar(20) not null,stu_gender char(6) 
check(stu_gender='Male' or stu_gender='Female'),stu_birth datetime,
nativeplace varchar(60),coll_id char(2) not null,dept_id char(4) not null,
class_id char(6) not null,cometime datetime not null,
constraint stu_fk1 foreign key(class_id) references class(class_id),
constraint stu_fk2 foreign key(dept_id) references dept(dept_id),
constraint stu_fk3 foreign key(coll_id) references college(coll_id)
);

create table course(
cou_id char(6) primary key,cou_name varchar(40) not null,xuefen numeric(3,1) not null,
coll_id char(2) not null,dept_id char(4) not null,
constraint cou_fk1 foreign key(dept_id) references dept(dept_id),
constraint cou_fk2 foreign key(coll_id) references college(coll_id)
);

create table courseinfo(
cou_id char(6),cou_day char(1),cou_time char(1),teacher varchar(20) not null,
onchosing char(1) default '0',
constraint couinfo_fk1 foreign key(cou_id) references course(cou_id),
constraint couinfo_key primary key(cou_id,cou_day,cou_time)
);

create table grade(
stu_id char(12),cou_id char(6),score numeric(4,1) default 0,isdual numeric(1) default 0,
constraint grade_fk1 foreign key(cou_id) references course(cou_id),
constraint grade_fk2 foreign key(stu_id) references student(stu_id),
constraint grade_key primary key(stu_id,cou_id)
);

create table user_teacher(
uid char(6) primary key,
pwd char(12) not null,
coll_id char(2) not null,
constraint user1_fk foreign key(coll_id) references college(coll_id)
);

create table user_stu(
stu_id char(12) primary key,
pwd char(12) not null,
constraint user2_fk foreign key(stu_id) references student(stu_id)
);

insert into college values('01','ComputerCollege');
insert into college values('02','MechanicCollege');

insert into dept values('0101','01','Automation');
insert into dept values('0102','01','Instrument');
insert into dept values('0103','01','Computer');

insert into dept values('0201','02','Mechanical Design');
insert into dept values('0202','02','Industrial Engineering');
insert into dept values('0203','02','Mechanical Engineering');

insert into class values('010101','0101','01','Class1');
insert into class values('010102','0101','01','Class2');
insert into class values('010201','0102','01','Class1');
insert into class values('010202','0102','01','Class2');
insert into class values('010301','0103','01','Class1');
insert into class values('010302','0103','01','Class2');
insert into class values('010303','0103','01','Class3');


insert into class values('020101','0201','01','Class1');
insert into class values('020102','0201','01','Class2');
insert into class values('020201','0202','01','Class1');
insert into class values('020202','0202','01','Class2');
insert into class values('020301','0203','01','Class1');
insert into class values('020302','0203','01','Class2');
insert into class values('020303','0203','01','Class3');


insert into student values('200501030318','ZhangSan','Male','1986-11-1','Shanghai','01','0103','010303','2005-9-1');
insert into student values('200501030218','LiSi','Male','1986-12-10','Zhejiang','01','0103','010302','2005-9-1');
insert into student values('200501020319','WangWu','Male','1986-11-1','Jiangsu','01','0102','010303','2005-9-1');
insert into student values('200502020319','ZhaoLiu','Male','1986-11-1','Fujian','02','0202','010303','2005-9-1');

insert into user_stu values('200501030318','200501030318');
insert into user_stu values('200501030218','200501030218');
insert into user_stu values('200501020319','200501020319');
insert into user_stu values('200502020319','200502020319');

insert into user_teacher values('ysk','123456','01');
insert into user_teacher values('zl','123456','02');

insert into course values('010301','Computer Culture',2.5,'01','0103');
insert into course values('010302','Computer Concepts',2,'01','0103');
insert into course values('010303','Assembly Language',3.5,'01','0103');
insert into course values('010201','Digital Circuit',2.5,'01','0102');
insert into course values('010202','Analogous Circuit',3.5,'01','0102');
insert into course values('010101','Principle of Automation',3.5,'01','0101');

insert into course values('020101','CAD',3.5,'02','0201');
insert into course values('020201','Principles of Industrial Engineering',3.5,'02','0202');
insert into course values('020301','Machinery Manufacturing Foundation',3.5,'02','0203');
insert into course values('020302','Foundry Engieering',3.5,'02','0203');
