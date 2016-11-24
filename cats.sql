

create table cats(
id int unsigned not null auto_increment, #Unique id for the record
name	 varchar(150) not null,  # name of the cat
owner 	varchar(150) not null,  # owner of the cat
birth	date not null,       	# birthday of the cat
primary key (id)    # Make the ID the primary key
);


insert into cats (name, owner, birth) values
('Sandy', 'Lennon', '2015-01-03'),
('Cookie', 'Casey', '2013-11-13'),
('Charlie', 'River', '2014-06-21');