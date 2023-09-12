package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 获取所有成员
     *
     * @return
     */
    List<User> getAllUser();

    /**
     * 通过用户名获取用户
     *
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 用户登录
     *
     * @return
     */
    User checkLogin(String username, String password);

    /**
     * 用户登录
     *
     * @param map
     * @return
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    User checkLoginByParam(
            @Param("username") String username,
            @Param("password") String password
    );

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    int insertUser(User user);
}
