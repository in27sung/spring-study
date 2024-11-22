package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * root-context.xml에서 생성된 객체(Bean)을 가져와서
 * 디비연결을 수행하는 테스트
 *
 */
// -> 스프링으로 테스트 진행하겠다
// -> 스프링의 자원을 사용/접근 가능하게 됨 
@RunWith(SpringJUnit4ClassRunner.class)
// -> 테스트시 필요한 설정정보/파일의 위치 설정 
// -> root-context.xml(디비 연결정보) 파일정보를 가져오기
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	// Spring + JUnit
	
	// 디비 연결 테스트 
	
	// 디비연결정보 가져오기 -> 디비연결정보가 필요하다 -> 의존하고있다
	// -> 의존관계 주입
	// -> 스프링이 생성해놓은 객체를 주입 
	//    받아서 사용(개발자가 별도의 다른 객체 생성,처리x)
	@Inject
	private DataSource ds;
	
	
	// -> Junit이 테스트를 실행하기 위해서 사용하는 어노테이션
	// -> @Test 없으면 Junit실행x
	//@Test
	public void checkDS() {
		System.out.println("객체 주입정보 확인");
		System.out.println(ds);
	}
	
	@Test
	public void dsConnection() {
		System.out.println("디비 연결 확인");
		try {
			Connection con = ds.getConnection();
			System.out.println("디비 연결 성공!");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
		
}
