-- Script for create all tables for Gaam project

drop table users
create table users
(
  user_id serial not null,
  email varchar(300) not null,
  password varchar(150) not null,
  status varchar(20) not null,
  role varchar(50) not null,
  unique(user_id, email),
  constraint user_pk primary key(user_id)
)

create table insurance_company 
(
  insurance_company_id serial not null,
  name varchar(300) not null,
  phone varchar(150) not null,
  address varchar(300) not null,
  observation varchar(300) not null,
  unique(insurance_company_id, name),
  constraint insurance_company_pk primary key(insurance_company_id)
) 

create table customer 
(
  customer_id serial not null,
  user_id int not null,
  name varchar(300) not null,
  phone varchar(150) not null,
  address varchar(300) not null,
  birth_date varchar(10) not null,
  cpf varchar(150) not null,
  rg varchar(10) not null,
  insurance_company_id int not null,
  insurance_company_identification varchar(300) not null,
  observation varchar(300) not null,
  unique(customer_id, cpf),
  constraint customer_pk primary key(customer_id)
)

create table medic 
(
  medic_id serial not null,
  user_id int not null,
  name varchar(300) not null,
  phone varchar(150) not null,
  address varchar(300) not null,
  crm varchar(150) not null,
  observation varchar(300),
  unique(medic_id, user_id),
  constraint medic_pk primary key(medic_id)
)

create table medic_insurance_company
(
  medic_id integer not null,
  insurance_company_id integer not null,
  constraint medic_fk foreign key(medic_id) references medic(medic_id) on delete cascade,
  constraint insurance_company_fk foreign key(insurance_company_id) references insurance_company(insurance_company_id) on delete cascade
)

create table role 
(
  role_id serial not null,
  name varchar(300) not null,
  unique(role_id),
  constraint role_pk primary key(role_id)
)

create table medic_category 
(
  medic_category_id serial not null,
  name varchar(300) not null,
  unique(medic_category_id),
  constraint medic_category_pk primary key(medic_category_id)
)

-- Just for learn
drop table credential
create table credential -- n�o foi implementada
(
  credential_id serial not null,
  user_id serial not null,
  title varchar(200) not null,
  user_name varchar(150) not null,
  password varchar(150) not null,
  unique(credential_id, title),
  constraint credential_pk primary key(credential_id)
  constraint user_fk foreign key(user_id) references users(user_id) on delete cascade
), 

drop table task
create table task -- n�o foi implementada
(
  task_id serial not null,
  title varchar(150) not null,
  description text not null,
  status varchar(50) not null,
  creation_data varchar(50) not null,
  end_date varchar(50) not null,
  unique(task_id, title),
  constraint task_pk primary key(task_id)
),

drop table stage
create table stage -- n�o foi implementada
(
  stage_id serial not null,
  task_id serial not null,
  description text not null,
  creation_date varchar(50) not null,
  unique(stage_id),
  constraint stage_pk primary key(stage_id)
  constraint task_fk foreign key(task_id) references task(task_id) on delete cascade
),

drop table article
create table article
(
  article_id serial not null,
  title varchar(150) not null,
  article_body text not null,
  creation_date varchar(50) not null,
  user_id int not null, -- chave estrangeira
  category_id int not null, --chave estrangeira
  unique(article_id, title),
  constraint article_pk primary key(article_id),
  constraint user_fk foreign key(user_id) references users(user_id) on delete cascade,
  constraint category_fk foreign key(category_id) references category(category_id) on delete cascade
),

drop table category
create table category
(
  category_id serial not null,
  name varchar(150) not null,
  description text,
  creation_date varchar(50) not null,
  user_id int not null, -- chave estrangeira
  unique(category_id, name),
  constraint category_pk primary key(category_id),
  constraint user_fk foreign key(user_id) references users(user_id) on delete cascade
),

drop table project
create table project -- n�o foi implementada
(
  project_id serial not null,
  name varchar(150) not null,
  description text,
  creation_date varchar(50) not null,
  user_id int not null, -- chave estrangeira
  unique(project_id, name),
  constraint project_pk primary key(project_id),
  constraint user_fk foreign key(user_id) references users(user_id) on delete cascade
),


-- Inserts for EasyDays project:
insert into users(email, password, creation_date)
values ('everson.figueiro@gmail.com', 'scorpion', '03/09/2012')

-- as tabelas abaixo s�o somente para exemplos...
drop table project
create table project
(
  project_id serial not null,
  title varchar(200) not null,
  phase varchar(200) not null,
  owner varchar(200) not null,
  status varchar(100) not null,
  description text not null,
  creation_date varchar(50) not null,
  unique(project_id, title),
  constraint project_pk primary key(project_id)
),

drop table users_project
create table users_project
(
  user_id integer not null,
  project_id integer not null,
  constraint user_fk foreign key(user_id) references users(user_id) on delete cascade,
  constraint project_fk foreign key(project_id) references project(project_id) on delete cascade
),

drop table topic
create table topic
(
  topic_id serial not null,
  title varchar(200) not null,       
  created_by varchar(200) not null,
  status varchar(100) not null,
  creation_date varchar(50) not null,
  project_id integer not null,
  unique(topic_id, title),
  constraint topic_pk primary key(topic_id),
  constraint project_fk foreign key(project_id) references project(project_id) on delete cascade
),

drop table post
create table post
(
  post_id serial not null,
  created_by varchar(200) not null,
  message text not null,
  creation_date varchar(50) not null,
  topic_id integer not null,
  unique(post_id),
  constraint post_pk primary key(post_id),
  constraint topic_fk foreign key(topic_id) references topic(topic_id) on delete cascade
),

-- Queries and insert***************************************************************************
select * from users
insert into users(user_name, email, password, status, creation_date, profile_id)
values('everson.figueiro', 'everson.figueiro@gmail.com', 'scorpion', 'hold', 'teste', '1'),

-- Insert for page
select * from page
insert into page(title, url, status, description, creation_date)
values('Create Page', '/modules/page/create.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Retrieve Page', '/modules/page/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Create Profile', '/modules/profile/create.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Retrieve Profile', '/modules/profile/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Create User', '/modules/user/create.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Retrieve User', '/modules/user/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Create Project', '/modules/project/create.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Retrieve Project', '/modules/project/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012'),

insert into page(title, url, status, description, creation_date)
values('Forum(Topics)', '/modules/topic/retrieve.xhtml', 'active', 'desc', 'Apr 27, 2012'),

-- Insert for profile
select * from profile
insert into profile(title, status, description, creation_date)
values('Admin', 'activated', 'desc', 'teste'),

-- Insert for profile_page
insert into profile_page(profile_id, page_id)
values(1,1),

insert into profile_page(profile_id, page_id)
values(1,2),

insert into profile_page(profile_id, page_id)
values(1,3),

insert into profile_page(profile_id, page_id)
values(1,4),

insert into profile_page(profile_id, page_id)
values(1,5),

insert into profile_page(profile_id, page_id)
values(1,6),

insert into profile_page(profile_id, page_id)
values(1,7),

insert into profile_page(profile_id, page_id)
values(1,8),

insert into profile_page(profile_id, page_id)
values(1,9),

-- selects
select * from users
select * from profile
select * from page
select * from project
select * from topic
select * from post

select * from profile_page
select * from users_project
