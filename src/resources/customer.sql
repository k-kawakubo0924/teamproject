drop table customer if exists;

create table customer (
	id int auto_increment primary key,
	login varchar(100) not null unique,
	password varchar(100) not null
);

insert into customer values(null, '林', 'ryouta');
insert into customer values(null, '川久保', 'kazuya');
insert into customer values(null, '犬塚', 'hayato');

