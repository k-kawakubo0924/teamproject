drop table school if exists;

create table school (
	CD char(3) primary key,
	NAME varchar(20) default null,
);

insert into school values('oom','学校');