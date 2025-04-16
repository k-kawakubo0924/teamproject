drop table class_num if exists;

create table class_num (
	school_cd char(100)  primary key,
	class_num varchar(5) not null,
);

insert into class_num values('oom','131');