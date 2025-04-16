drop table subject if exists;

create table subject (
	SCHOOL_CD char(3),
	CD char(3),
	NAME varchar(20),
	PRIMARY KEY(SCHOOL_CD,CD)
);

insert into subject values('oom','A02','国語');