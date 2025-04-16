drop table test if exists;

create table test (
	STUDENT_NO varchar(10),
	SUBJECT_CD char(3),
	SCHOOL_CD char(10),
	NO integer(10),
	POINT integer(10) default null,
	CLASS_NUM varchar(5)default null,
	PRIMARY KEY (STUDENT_NO,SUBJECT_CD,SCHOOL_CD,NO)
);

insert into test values('2231111','A02','oom',1,100,'131');