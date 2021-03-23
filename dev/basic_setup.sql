CREATE DATABASE Illustris
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

GRANT ALL PRIVILEGES ON DATABASE Illustris TO postgres;
GRANT ALL PRIVILEGES ON DATABASE Illustris TO ajfurey;

CREATE TABLE  User (
    id int8 NOT NULL,
    firstName varchar(30) NOT NULL,
    lastName varchar(30) NOT NULL,
    email varchar(30) NOT NULL,
    password varchar(16) NOT NULL,
    phone varchar(12),
	dob date,
    primary key (id)
)

INSERT INTO "User"
VALUES ("Nick", "Fury", "nfury01", "nfury@shield.com", "GooseIsNotAC@", "555-555-5555", "04-14-1970", true, false, true, "Director","01-01-1987");


