package com.food.dao;import org.apache.ibatis.session.SqlSession;import org.apache.ibatis.session.SqlSessionFactory;import javax.annotation.Resource;import java.util.List;/** * Created by user on 16-11-13. */public class BaseDao {    protected SqlSessionFactory getSqlSession() {        SqlSessionFactory sqlSessionFactory = null;        return sqlSessionFactory;    }    protected <T> T selectOne(SqlSessionFactory sqlSessionFactory, String mapperFunctionUrl, Object paramObj) {        T result = null;        SqlSession sqlSession = null;        try {            sqlSession = sqlSessionFactory.openSession();            result = sqlSession.selectOne(mapperFunctionUrl, paramObj);            return result;        } catch (Throwable throwable) {            throwable.printStackTrace();        } finally {            sqlSession.close();        }        return null;    }    protected <T> List<T> selectList(SqlSessionFactory sqlSessionFactory, String mapperFunctionUrl, Object paramObj) {        List<T> resultList = null;        SqlSession sqlSession = null;        try {            sqlSession = sqlSessionFactory.openSession();            resultList = sqlSession.selectList(mapperFunctionUrl, paramObj);            return resultList;        } catch (Throwable throwable) {            throwable.printStackTrace();        } finally {            sqlSession.close();        }        return null;    }    protected int insert(SqlSessionFactory sqlSessionFactory, String mapperFunctionUrl, Object paramObj) {        SqlSession sqlSession = null;        int count = 0;        try {            sqlSession = sqlSessionFactory.openSession();            count = sqlSession.insert(mapperFunctionUrl, paramObj);            return count;        } catch (Throwable throwable) {            throwable.printStackTrace();        } finally {            sqlSession.close();        }        return 0;    }    protected int update(SqlSessionFactory sqlSessionFactory, String mapperFunctionUrl, Object paramObj) {        SqlSession sqlSession = null;        int count = 0;        try {            sqlSession = sqlSessionFactory.openSession();            count = sqlSession.update(mapperFunctionUrl, paramObj);            return count;        } catch (Throwable throwable) {            throwable.printStackTrace();        } finally {            sqlSession.close();        }        return 0;    }    protected int delete(SqlSessionFactory sqlSessionFactory, String mapperFunctionUrl, Object paramObj) {        SqlSession sqlSession = null;        int count = 0;        try {            sqlSession = sqlSessionFactory.openSession();            count = sqlSession.delete(mapperFunctionUrl, paramObj);            return count;        } catch (Throwable throwable) {            throwable.printStackTrace();        } finally {            sqlSession.close();        }        return 0;    }}