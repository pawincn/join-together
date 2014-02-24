drop database if exists join_together;

create database join_together;

use join_together;

create table participants
(
  id bigint primary key auto_increment,
  nick_name varchar (50),
  first_name varchar (50),
  last_name varchar (50),
  gender tinyint (1),
  age int,
  email varchar (50),
  mobile_number varchar (20),
  wechat_id varchar (50),
  weibo_id varchar (50)
);

create table participant_footprints
(
  id bigint primary key auto_increment,
  longitude decimal (9,6),
  latitude decimal (9,6),
  participant_id bigint,
  foreign key (participant_id) references participants(id)
);

create table activity_recurring_settings
(
  id bigint primary key auto_increment,
  start_time time,
  recurring_end datetime,
  monday bool,
  tuesday bool,
  wednesday bool,
  thursday bool,
  friday bool,
  saturday bool,
  sunday bool
);

create table activity_restrictions
(
  id bigint primary key auto_increment,
  distance_in_km int default 10,
  participant_count_max int,
  participant_gender tinyint default 0,
  age_range_min int default 12,
  age_range_max int default 100,
  start_in_minutes int default 30,
  start_at_datetime datetime,
  recurring_setting_id bigint,
  foreign key (recurring_setting_id) references activity_recurring_settings(id)
);

create table activities
(
  id bigint primary key auto_increment,
  title varchar (200),
  description varchar (1000),
  restriction_id bigint,
  foreign key (restriction_id) references activity_restrictions(id)
);

create table activity_tags
(
  id bigint primary key auto_increment,
  tag varchar (50)
);

create table activity_tag_xref
(
  id bigint primary key auto_increment,
  activity_id bigint,
  tag_id bigint,
  foreign key (activity_id) references activities(id),
  foreign key (tag_id) references activity_tags(id)
);

create table activity_participant_xref
(
  id bigint primary key auto_increment,
  activity_id bigint,
  participant_id bigint,
  linking_time datetime,
  isOrganizer bool
);

create table messages
(
  id bigint primary key auto_increment,
  message varchar (200),
  sent_time datetime,
  isSent bool,
  isReceived bool,
  activity_id bigint,
  foreign key (activity_id) references activities(id)
);

create table message_participant_xref
(
  id bigint primary key auto_increment,
  participant_id bigint,
  from_to bool
);
