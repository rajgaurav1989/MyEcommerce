create table category (
    id varchar(36) primary key,
    name varchar(100) not null,
    description varchar(500) not null,
    parent_id varchar(36)
);