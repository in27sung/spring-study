package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MysqlConnectTest {
	
	//Java + Junit
	
	// 디비연결정보 
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/springdb";
	private static final String DBID = "root";
	private static final String DBPW = "1234";

	
	// 디비 연결
	@Test
	public void DBConnectTest() throws Exception {
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		System.out.println("드라이버 로드 성공");
		// 2. 디비연결 
		Connection con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println("디비연결 성공");
		System.out.println(con);
	}
	
}
