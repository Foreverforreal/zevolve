CREATE SCHEMA if not exists `zevolve`;

drop table if exists zevolve.sys_user;
CREATE TABLE zevolve.sys_user
(
    id int primary key auto_increment,
    user_name varchar(20) NOT NULL,
    password varchar(50) NOT NULL,
    nick_name varchar(20),
    salt varchar(50),
    mobile varchar(20),
    group_id smallint,
    eamil varchar(64),

    create_time datetime,
    update_time datetime,
    create_user_id int,
    update_user_id int,
    del_flag boolean,
    status char(3),
    remark varchar(200)
);
CREATE UNIQUE INDEX sys_user_user_name_uindex ON `zevolve`.sys_user (user_name);
ALTER TABLE zevolve.sys_user COMMENT = '系统用户表';

drop table if exists zevolve.sys_role;
CREATE TABLE zevolve.sys_role
(
    id int primary key auto_increment,
    role_name varchar(20),

    create_time datetime,
    update_time datetime,
    create_user_id int,
    update_user_id int,
    del_flag boolean,
    status char(3),
    remark varchar(200)
);
ALTER TABLE zevolve.sys_role COMMENT = '角色表';

drop table if exists zevolve.sys_permission;
CREATE TABLE zevolve.sys_permission
(
    id int primary key auto_increment,
    perms_name varchar(20),
    perms_sign varchar(50),
    herf varchar(20),
    parent_perms int,
    sort smallint,
    is_show boolean,
    level smallint,

    create_time datetime,
    update_time datetime,
    create_user_id int,
    update_user_id int,
    del_flag boolean,
    status char(3),
    remark varchar(200)
);
ALTER TABLE zevolve.sys_permission COMMENT = '权限表';

drop table if exists zevolve.sys_user_role;
CREATE TABLE zevolve.sys_user_role
(
    id int primary key auto_increment,
    user_id int,
    role_id int,

    create_time datetime,
    update_time datetime,
    create_user_id int,
    update_user_id int,
    del_flag boolean,
    status char(3),
    remark varchar(200)
);
ALTER TABLE zevolve.sys_user_role COMMENT = '用户角色表';

drop table if exists zevolve.sys_role_permission;
CREATE TABLE zevolve.sys_role_permission
(
    id int primary key auto_increment,
    role_id int,
    perms_id int,

    create_time datetime,
    update_time datetime,
    create_user_id int,
    update_user_id int,
    del_flag boolean,
    status char(3),
    remark varchar(200)
);
ALTER TABLE zevolve.sys_role_permission COMMENT = '角色权限表';