CREATE SCHEMA `zevolve`;




CREATE TABLE sys_user
(
    id int,
    name varchar(20),
    password varchar(20),
    column_4 int,
    salt varchar(100)
);
ALTER TABLE sys_user COMMENT = '系统用户表';

CREATE TABLE sys_role
(
  id int
);
ALTER TABLE sys_role COMMENT = '角色表';

CREATE TABLE sys_permission
(
  id int
);
ALTER TABLE sys_permission COMMENT = '角色表';

CREATE TABLE sys_user_role
(
  id int
);
ALTER TABLE sys_user_role COMMENT = '角色表';

CREATE TABLE sys_role_permission
(
  id int
);
ALTER TABLE sys_role_permission COMMENT = '角色表';