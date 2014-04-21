drop database if exists join_together;

create database join_together;

use join_together;

create table users
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

create table user_footprints
(
  id bigint primary key auto_increment,
  longitude decimal (9,6),
  latitude decimal (9,6),
  user_id bigint,
  foreign key (user_id) references users(id)
);

create table user_friend_xref
(
  id bigint primary key auto_increment,
  user_id bigint,
  friend_id bigint,
  foreign key (user_id) references users(id),
  foreign key (friend_id) references users(id)
);

create table user_groups
(
  id bigint primary key auto_increment,
  group_name varchar(100),
  group_desc varchar(500)
);

create table user_group_xref
(
  id bigint primary key auto_increment,
  group_id bigint,
  user_id bigint,
  foreign key (group_id) references user_groups(id),
  foreign key (user_id) references users(id)
);
create unique index user_group_xref_unique_index on user_group_xref(user_id, group_id);

create table activity_recurring_settings
(
  id bigint primary key auto_increment,
  start_time char(8),
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
  recurring_setting_id bigint
#   foreign key (recurring_setting_id) references activity_recurring_settings(id)
);

create table activity_location
(
  id bigint primary key auto_increment,
  longitude decimal(9,6),
  latitude decimal(9,6),
  address varchar(100),
  city varchar(20),
  country varchar(10)
);

create table activities
(
  id bigint primary key auto_increment,
  title varchar (200),
  description varchar (1000),
  restriction_id bigint,
  location_id bigint,
  organizer_id bigint
#   foreign key (restriction_id) references activity_restrictions(id)
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

create table activity_joiners
(
  id bigint primary key auto_increment,
  activity_id bigint,
  joiner_id bigint,
  join_time datetime,
  foreign key (activity_id) references activities(id),
  foreign key (joiner_id) references users(id)
);
create unique index activity_joiners_unique_index on activity_joiners(activity_id, joiner_id);

create table activity_invitees
(
  id bigint primary key auto_increment,
  activity_id bigint,
  invitee_id bigint,
  invited_group_id bigint,
  invite_time datetime,
  foreign key (activity_id) references activities(id),
  foreign key (invitee_id) references users(id),
  foreign key (invited_group_id) references user_groups(id)
);

create table messages
(
  id bigint primary key auto_increment,
  message varchar (200),
  send_time datetime,
  sender_id bigint,
  activity_id bigint,
  foreign key (sender_id) references users(id)
#   foreign key (activity_id) references activities(id)
);

create table message_receivers
(
  id bigint primary key auto_increment,
  receiver_id bigint,
  message_id bigint,
  is_read tinyint,
  foreign key (receiver_id) references users(id),
  foreign key (message_id) references messages(id)
);
