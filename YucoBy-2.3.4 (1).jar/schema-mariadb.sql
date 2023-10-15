drop table if exists audiovisual;
create table if not EXISTS audiovisual (
    id int primary key auto_increment,
    title varchar(50),
    description varchar(250),
    duration_time varchar(10),
    link varchar(500),
    image varchar(250),
    updated_at Datetime not null default now()
);