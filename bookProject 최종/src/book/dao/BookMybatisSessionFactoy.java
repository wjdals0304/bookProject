package book.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BookMybatisSessionFactoy {
	//
	private static BookMybatisSessionFactoy instance;
	private SqlSessionFactory sessionFactory;
	
	private BookMybatisSessionFactoy() {
		//
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BookMybatisSessionFactoy createInstance() {
		//
		if(instance == null) {
			instance = new BookMybatisSessionFactoy();
		}
		
		return instance;
	}
	
	public SqlSession getSqlSession() {
		//
		return sessionFactory.openSession(true);
	}
}
