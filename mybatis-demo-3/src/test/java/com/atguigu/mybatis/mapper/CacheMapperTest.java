package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CacheMapperTest {

    @Test
    public void getEmpByIdOfSameMapper() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        mapper.getEmpById(1);
        mapper.getEmpById(1);
        // 相同sql和相同参数，只进行一次查询
        // select * from t_emp where eid = ?
    }

    @Test
    public void getEmpByIdOfSameSession() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        mapper1.getEmpById(1);

        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        mapper2.getEmpById(1);
        // 只进行一次查询
        // select * from t_emp where eid = ?
    }

    @Test
    public void getEmpByIdOfTwoCache() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        mapper1.getEmpById(1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        mapper2.getEmpById(1);
        sqlSession1.close();
    }
}