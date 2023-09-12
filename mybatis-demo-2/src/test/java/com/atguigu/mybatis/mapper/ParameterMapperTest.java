package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {

    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> allUser = mapper.getAllUser();

        allUser.forEach(System.out::println);
    }

    @Test
    public void getUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");

        System.out.println(user);
    }

    @Test
    public void checkLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");

        System.out.println(user);
    }

    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");

        User user = mapper.checkLoginByMap(map);

        System.out.println(user);
    }

    @Test
    public void checkLoginByParam(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");

        System.out.println(user);
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        User user = new User();
        user.setUsername("Panda");
        user.setPassword("abcd");
        user.setAge(20);
        user.setGender("男");
        user.setEmail("abcd@qq.com");

        mapper.insertUser(user);
    }
}
