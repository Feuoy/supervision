-- 数据库初始化脚本


-- 创建数据库
CREATE DATABASE supervision;


-- use database
use supervision;


-- create user_list table
CREATE TABLE user_list
(
    `user_id`     BIGINT       NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `name`        VARCHAR(128) NOT NULL COMMENT '用户名',
    `password`    VARCHAR(128) NOT NULL COMMENT '密码',
    `create_time` TIMESTAMP    NOT NULL DEFAULT current_timestamp COMMENT '创建时间',

    PRIMARY KEY (user_id),
    KEY idx_name (name),
    KEY idx_password (password),
    KEY idx_create_time (create_time)

)
# ENGINE = InnoDb
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT ='用户表';


# 初始化数据
insert into user_list(name, password)
values ('学生甲', '7c4a8d09ca3762af61e59520943dc26494f8941b'),/*123456*/
       ('学生乙', 'dd5fef9c1c1da1394d6d34b248c51be2ad740840');/*654321*/


# 登录记录表
CREATE TABLE login_record
(
    record_id    BIGINT       NOT NULL AUTO_INCREMENT COMMENT '记录id',
    user_name  VARCHAR(128) NOT NULL COMMENT '用户名',
    login_time TIMESTAMP    NOT NULL DEFAULT current_timestamp COMMENT '记录时间',

    PRIMARY KEY (record_id),
    KEY idx_user_name (user_name),
    KEY idx_login_time (login_time)

)
# ENGINE = innoDb
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT '登录记录表';


# # 连接mysql
# mysql -uroot -p