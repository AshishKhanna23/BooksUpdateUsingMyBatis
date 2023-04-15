// database- bookdb

create table book_details(
id int NOT NULL auto_increment,
book_name varchar(100) NOT NULL,
author_name varchar(100) NOT NULL,
price int,
is_Available tinyint(1) DEFAULT '1',
PRIMARY KEY (`id`)
);