package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    @Test
    public void getEmpByIfCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        // 各信息都不为null/空字符串
        mapper.getEmpByIfCondition(new Emp(null, "Apple", 22, "女", "123@gmail.com"));
        // select * from t_emp where 1=1 and emp_name = ? and age = ? and email = ? and sex = ?

        mapper.getEmpByIfCondition(new Emp(null, "Apple", null, "女", "123@gmail.com"));

        // select * from t_emp where 1=1 and emp_name = ? and email = ? and sex = ?

        mapper.getEmpByIfCondition(new Emp(null, null, null, "女", "123@gmail.com"));
        // select * from t_emp where 1=1 and email = ? and sex = ?

    }

    @Test
    public void getEmpByWhereCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        mapper.getEmpByWhereCondition(new Emp(null, "Apple", 22, "女", "123@gmail.com"));
        // select * from t_emp WHERE emp_name = ? and age = ? and email = ? and sex = ?

        mapper.getEmpByWhereCondition(new Emp(null, "Apple", null, "女", "123@gmail.com"));
        // select * from t_emp WHERE emp_name = ? and email = ? and sex = ?

        mapper.getEmpByWhereCondition(new Emp(null, null, null, "女", "123@gmail.com"));
        // select * from t_emp WHERE email = ? and sex = ?
    }

    @Test
    public void getEmpByTrimCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        mapper.getEmpByTrimCondition(new Emp(null, "Apple", 22, "女", "123@gmail.com"));
        // select * from t_emp where emp_name = ? and age = ? or email = ? and sex = ?

        mapper.getEmpByTrimCondition(new Emp(null, "Apple", null, "女", "123@gmail.com"));
        // select * from t_emp where emp_name = ? and email = ? and sex = ?

        mapper.getEmpByTrimCondition(new Emp(null, null, null, "女", "123@gmail.com"));
        // select * from t_emp where email = ? and sex = ?

    }

    @Test
    public void getEmpByChooseCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

        mapper.getEmpByChooseCondition(new Emp(null, "Apple", 22, "女", "123@gmail.com"));
        // select * from t_emp WHERE emp_name = ?

        mapper.getEmpByChooseCondition(new Emp(null, null, null, "女", "123@gmail.com"));
        // select * from t_emp WHERE sex = ?

        mapper.getEmpByChooseCondition(new Emp(null, null, null, null, null));
        // select * from t_emp WHERE did = 1
    }

    @Test
    public void getEmpByForeachCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        mapper.getEmpByForeachCondition(Arrays.asList(1, 2, 3));
        // select * from t_emp where eid in ( ? , ? , ? )
    }

    @Test
    public void getEmpByForeachOrCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        mapper.getEmpByForeachOrCondition(Arrays.asList(1, 2, 3));
        //  select * from t_emp where eid = ? or eid = ? or eid = ?
    }

    @Test
    public void insertMoreByList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = Arrays.asList(
                new Emp(null, "Tom", 12, "女", "123@gmail.com"),
                new Emp(null, "Jack", 23, "女", "123@gmail.com"),
                new Emp(null, "Steve", 34, "男", "123@gmail.com")
                );

        mapper.insertMoreByList(list);
    //    insert into t_emp (emp_name, age, sex, email) values (?,?,?,?) , (?,?,?,?) , (?,?,?,?)
    }

    @Test
    public void getAllEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        mapper.getAllEmp();
        // select eid,emp_name,age,sex,email from t_emp
    }
}