package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.JsonUtil;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SelectMapperTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(2);
        JsonUtil.prettyPrint(user);
    }

    @Test
    public void getAllUser() {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUser = mapper.getAllUser();

        JsonUtil.prettyPrint(allUser);

    }

    @Test
    public void getCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void getUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> user = mapper.getUserByIdToMap(2);

        JsonUtil.prettyPrint(user);
    }

    @Test
    public void getAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        //allUserToMap.forEach(System.out::println);

        JsonUtil.prettyPrint(allUserToMap);
    }

    @Test
    public void getAllUserToMapKey() throws JsonProcessingException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> allUserToMapKey = mapper.getAllUserToMapKey();

        JsonUtil.prettyPrint(allUserToMapKey);
    }


}