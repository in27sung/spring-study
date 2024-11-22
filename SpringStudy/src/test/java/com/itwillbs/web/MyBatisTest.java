package com.itwillbs.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MyBatisTest {
	// Spring + JUnit + MyBatis
	
	// 디비연결 + MyBatis
	@Inject
	private SqlSessionFactory sqlFactory;
	// private SqlSessionFactory sqlFactory = new SqlSessionFactoryBean();
	
	@Test
	public void sqlFactoryTest() {
		System.out.println(sqlFactory);
		System.out.println("디비 연결 + MyBatis 설정 완료");
	}
	@Test
	public void sqlFactoryConnect() {
		SqlSession sqlSession = sqlFactory.openSession(); //디비연결
		System.out.println("디비연결 + MyBatis 설정 완료");
		System.out.println(sqlSession);
		//sqlSession.insert(statement)
	}
	
}
