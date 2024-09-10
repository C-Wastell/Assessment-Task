create table person
(
   id int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   first_name varchar(255) not null,
   last_name varchar(255) not null
);