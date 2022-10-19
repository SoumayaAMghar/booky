create database if not exists booky;

use booky;

create table if not exists users
(
    id       int primary key auto_increment,
    name     varchar(255)            not null,
    username varchar(255)            not null,
    cin      varchar(255)            not null,
    password varchar(255)            not null,
    role     enum ('ADMIN','CLIENT') not null
);

create table if not exists rooms
(
    id          int primary key auto_increment,
    type        enum ('SINGLE','DOUBLE','TRIPLE','SUITE') not null,
    number      int                                       not null,
    floor       int                                       not null,
    description varchar(255)                              not null
);

create table if not exists room_images
(
    id      int primary key auto_increment,
    room_id int          not null references rooms (id),
    url     varchar(255) not null
);

create table if not exists rates
(
    id         int primary key auto_increment,
    type       enum ('SINGLE','DOUBLE','TRIPLE','SUITE') not null,
    price      double                                    not null,
    start_date date                                      not null,
    end_date   date                                      not null
);

create table if not exists Promotions
(
    id         int primary key auto_increment,
    type       enum ('SINGLE','DOUBLE','TRIPLE','SUITE') not null,
    reduction  double                                    not null,
    start_date date                                      not null,
    end_date   date                                      not null
);

create table if not exists reservations
(
    id         int                                     not null auto_increment,
    user_id    int                                     not null references users (id),
    room_id    int                                     not null references rooms (id),
    start_date date                                    not null,
    end_date   date                                    not null,
    status     enum ('PENDING','CONFIRMED','CANCELED') not null,
    primary key (id, user_id, room_id)
);

create table if not exists extras
(
    id    int primary key auto_increment,
    type  enum ('BREAKFAST','LUNCH','DINNER','FRUITS','MUSIC','SPA','MASSAGE','CARE','EXCURSION') not null,
    price double                                                                                  not null
);

create table if not exists reservation_extras
(
    extra_id       int not null references extras (id),
    reservation_id int not null references reservations (id),
    primary key (extra_id, reservation_id)
);

create table if not exists payments
(
    id             int primary key auto_increment,
    reservation_id int                    not null references reservations (id),
    total          double                 not null,
    type           enum ('CASH','ONLINE') not null,
    date           date                   not null
);