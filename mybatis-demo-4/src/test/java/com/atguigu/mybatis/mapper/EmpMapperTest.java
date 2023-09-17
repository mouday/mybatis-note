package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.atguigu.mybatis.utils.JsonUtil;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.PrintWriter;

import static org.junit.Assert.*;

public class EmpMapperTest {

    @Test
    public void selectByExample() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        EmpExample example = new EmpExample();
        example.createCriteria()
                .andEmpNameEqualTo("张三")
                .andAgeGreaterThan(20);

        mapper.selectByExample(example);
        // select eid, emp_name, age, sex, email, did from t_emp WHERE ( emp_name = ? and age > ? )
    }

    @Test
    public void updateByPrimaryKeySelective() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        Emp record = new Emp();
        record.setEid(1);
        record.setAge(18);

        mapper.updateByPrimaryKeySelective(record);
        //  update t_emp SET age = ? where eid = ?
    }

    @Test
    public void selectByExamplePage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        mapper.selectByExample(null);
        // select eid, emp_name, age, sex, email, did from t_emp

        // 使用分页
        Page<Emp> page = PageHelper.startPage(3, 2);
        mapper.selectByExample(null);
        // SELECT count(0) FROM t_emp
        // select eid, emp_name, age, sex, email, did from t_emp LIMIT ?, ?
        // 4, 2
        PageInfo<Emp> pageInfo = page.toPageInfo();

        JsonUtil.prettyPrint(pageInfo);

    }
}