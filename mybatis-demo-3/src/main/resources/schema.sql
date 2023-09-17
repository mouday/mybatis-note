-- 部门表
create table t_dept(
  did int primary key not null auto_increment,
  dept_name varchar(50)
) comment '部门表';


-- 员工表
create table t_emp(
  eid int primary key not null auto_increment,
  emp_name varchar(50),
  age int,
  sex char(1),
  email varchar(50),
  did int
) comment '员工表';


-- 部门表
INSERT INTO MyBatis.t_dept (did, dept_name) VALUES (1, '财务部');
INSERT INTO MyBatis.t_dept (did, dept_name) VALUES (2, '技术部');
INSERT INTO MyBatis.t_dept (did, dept_name) VALUES (3, '销售部');

-- 员工表
INSERT INTO MyBatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (1, '曹操', 20, '男', '123456@qq.com', 1);
INSERT INTO MyBatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (2, '刘备', 24, '男', 'liubei@qq.com', 2);
INSERT INTO MyBatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (3, '孙尚香', 20, '女', 'sun@qq.com', 3);
INSERT INTO MyBatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (4, '张飞', 22, '男', 'zhang@163.com', 2);
INSERT INTO MyBatis.t_emp (eid, emp_name, age, sex, email, did) VALUES (5, '关羽', 23, '男', 'guan@126.com', 1);