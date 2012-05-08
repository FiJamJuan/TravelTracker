create table users(username varchar(50) not null primary key, password varchar(50) not null, enabled boolean not null);
create table authorities(username varchar(50) not null, authority varchar(50) not null); 
create unique index ix_auth_username on authorities (username, authority);
create table USERDATA(id serial, username varchar(50) not null unique, email varchar(50),  home varchar(50) , primary key (id));
create table TRIPS(id serial, deptdate varchar(50),  exitdate varchar(50), departure varchar(50), destination varchar(50), route varchar(50), username varchar(50), days integer, primary key (id));
ALTER TABLE authorities ADD CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username);
ALTER TABLE USERDATA ADD CONSTRAINT fk_userdata_users FOREIGN KEY(username) REFERENCES users(username);

