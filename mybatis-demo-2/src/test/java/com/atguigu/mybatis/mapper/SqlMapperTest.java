package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.JsonUtil;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SqlMapperTest {

    @Test
    public void getUserByLikeUsername() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> users = mapper.getUserByLikeUsername("ad");

        JsonUtil.prettyPrint(users);
    }


    @Test
    public void deleteBatch() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        int count = mapper.deleteBatch("1,2,3");

        System.out.println(count);
    }

    @Test
    public void getUserByTable() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);
        List<User> users = mapper.getUserByTable("t_user");

        JsonUtil.prettyPrint(users);
    }

    @Test
    public void insertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SqlMapper mapper = sqlSession.getMapper(SqlMapper.class);

        User user = new User();
        user.setUsername("Panda");
        user.setPassword("abcd");
        user.setAge(20);
        user.setGender("男");
        user.setEmail("abcd@qq.com");

        mapper.insertUser(user);

        JsonUtil.prettyPrint(user);

    }
}