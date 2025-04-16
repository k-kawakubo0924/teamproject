drop table student if exists;

create table student (
	NO varchar(10) primary key,
	NAME varchar (10) default null,
	ENT_YEAR integer default null,
	CLASS_NUM char(3) default null,
	IS_ATTEND boolean default null,
	SCHOOL_CD CHAR(3) default null
	);

insert into student values('2231111','大原太郎',2023,'131',TRUE,'oom');