package com.neuedu.ruidaoexam.test;




import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * hibernate框架会话Session类   ，mybatis 会话类 sqlSession
 * getSqlSessionFactory() 会话工厂方法
 * getSession()  获取会话的
 * closeSession() 关闭会话
 
 * 注意:
 * sqlSessionFactory.openSession(true)--带有自动提交事务的功能
 * sqlSessionFactory.openSession()    --不带自动提交,需要session.commit()进行手动提交事务 
 * @author Administrator
 *
 */
public class MyBatisSessionFactory {
	private MyBatisSessionFactory(){
	}
	private static final String RESOURCE = "mybatis-config.xml";
	private static SqlSessionFactory sqlSessionFactory = null;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	
	static {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(RESOURCE);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sqlSessionFactory = builder.build(reader);
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new ExceptionInInitializerError("初始化MyBatis错误，请检查配置文件或数据库");
			
		}
	}
	//获取数据库连接的对象sqlSessionFactory
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	//创建会话的方法
	public static SqlSession getSession(){
		SqlSession session = threadLocal.get();
		if (session == null){
			session = (sqlSessionFactory !=null) ?sqlSessionFactory.openSession():null;
			threadLocal.set(session);
		}
		return session;
	}
	//关闭会话的方法
	public static void closeSession(){
		SqlSession session = (SqlSession) threadLocal.get(); 
		threadLocal.set(null);
		if (session !=null){
			session.close();
		}
	}
}
