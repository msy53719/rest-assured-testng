CREATE SCHEMA `TestCase` DEFAULT CHARACTER SET utf8 ;
CREATE database `testdb` DEFAULT CHARACTER SET utf8 ;

use testdb;
create table user_info(
id integer NOT NULL AUTO_INCREMENT COMMENT 'id',
name varchar(255) NOT NULL COMMENT '名称',
phone varchar(255) NOT NULL COMMENT '电话',
create_time  DATETIME   DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time  DATETIME  DEFAULT NULL  COMMENT '修改时间',
PRIMARY KEY (id)
)ENGINE=INNODB CHARSET=utf8;


insert into user_info values(1,'test001','13211111111',now(),now());
insert into user_info values(2,'test002','13211111112',now(),now());
insert into user_info values(3,'test003','13211111113',now(),now());
insert into user_info values(4,'test004','13211111114',now(),now());
insert into user_info values(5,'test005','13211111115',now(),now());
insert into user_info values(6,'test006','13211111116',now(),now());
insert into user_info values(7,'test007','13211111117',now(),now());
insert into user_info values(8,'test008','13211111118',now(),now());
insert into user_info values(9,'test009','13211111119',now(),now());
commit;
--
--
--select * from teset_time;
--
--
--
--drop table teset_time;
--
drop table server_info;
drop table interface_info;
drop table test_case_info;
drop table expected_data;
drop table request_data;

use testdb;
create table server_info(
service_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '服务器id',
service_ip varchar(255) NOT NULL COMMENT '服务器地址',
service_port INT DEFAULT NULL COMMENT '端口',
service_base_path varchar(255)  COMMENT 'url地址',
server_des varchar(255) DEFAULT NULL COMMENT '服务描述',
create_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time DATETIME  DEFAULT NULL  COMMENT  '修改时间',
PRIMARY KEY (service_id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table interface_info(
interface_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '接口id',
service_id BIGINT NOT NULL COMMENT '服务id',
interface_name varchar(255) NOT NULL COMMENT '接口名称',
intercase_des varchar(255) DEFAULT NULL COMMENT '接口描述',
create_time  DATETIME NOT  NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time DATETIME DEFAULT NULL  COMMENT  '修改时间',
PRIMARY KEY (interface_id)
)ENGINE=INNODB;

create table test_case_info(
case_id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
interface_id BIGINT NOT NULL COMMENT 'ID',
case_name varchar(255) NOT NULL COMMENT '名称',
case_des varchar(255) DEFAULT NULL COMMENT '描述',
case_status varchar(255) DEFAULT '0' COMMENT '状态 0 -初始,1-失败 2-成功 ' ,
create_time  DATETIME NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time DATETIME DEFAULT NULL  COMMENT  '修改时间',
PRIMARY KEY (case_id) 
)ENGINE=INNODB;

create table request_data(
id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
case_id BIGINT NOT NULL COMMENT '测试用例id',
requset_key varchar(255) NOT NULL COMMENT '请求数据的key',
requset_value varchar(255) DEFAULT NULL COMMENT '请求数据的value',
create_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time DATETIME DEFAULT NULL  COMMENT  '修改时间',
PRIMARY KEY (id) 
)ENGINE=INNODB;

create table expected_data(
id BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
case_id BIGINT NOT NULL COMMENT '用例id',
response_jsonpath varchar(255) NOT NULL COMMENT '返回结果的jsonpath',
expected_value varchar(255) DEFAULT NULL COMMENT '预期结果值',
create_time  DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
modify_time DATETIME DEFAULT NULL  COMMENT  '修改时间',
PRIMARY KEY (id)
)ENGINE=INNODB CHARSET=UTF8;


insert into server_info values(1,'https://www.sojson.com',null,'/open/api/weather',now(),null);
COMMIT;

select * from interface_info;


insert into interface_info values (1,1,'/json.shtml',' 获取天气接口',now(),null);
commit;

insert into test_case_info  values ();

insert into request_data  values ();

insert into expected_data values();
commit;

--DROP TABLE IF EXISTS tablename;
--use testdb;--删除数据库
--drop table server_info;
--drop table interface_info;
--drop table  test_case_info;
--drop table request_data;
--drop table expected_data;
--
--select * from server_info;
--
--INSERT INTO server_info values('','','','');
--alert table