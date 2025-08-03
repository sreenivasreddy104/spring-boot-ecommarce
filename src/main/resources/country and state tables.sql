create table country (
    id NUMBER(5) primary key,
    code varchar2(50),
    name varchar2(250)
);

create table state (
    id NUMBER(5) PRIMARY KEY,
    name varchar2(250),
    country_id number(5),
    foreign key (country_id) references country(id)
);