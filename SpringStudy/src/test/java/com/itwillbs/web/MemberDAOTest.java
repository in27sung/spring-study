package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class MemberDAOTest {
	
	// MemberDAO - getTime()메서드 실행(test)
	
	// Logger 객체생성(mylog 단축명령어 실행) 
	private static final Logger logger 
		= LoggerFactory.getLogger(MemberDAOTest.class);
	
	// MeberDAO 객체가 필요함 -> MemberDAO 객체를 의존하고 있다 
	@Inject
	private MemberDAO mdao;
	// private MemberDAO mdao = new MemberDAOImpl();
	
//	@Test
//	public void daoTest() {
//		// DAO 객체가 있는지 체크 
//		System.out.println("-------------------------------------");
//		System.out.println(mdao);
//		System.out.println("-------------------------------------");
//	}
	//@Test
	public void getTimeTest() {
		System.out.println("-------------------------------------");
		String date = mdao.getTime();
		System.out.println(date);
		
		String date2 = mdao.getTime2();
//		System.out.println(date2);
		logger.info(date2);
		System.out.println("-------------------------------------");
	}
	// logger 단축키 생성 
//	logger.info("");
	
	
	//회원가입 테스트
	//@Test
	public void memberJoinTest() {
		
		// MemberDAO 객체에 필요한 회원가입 동작 작성 
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin3");
		vo.setUserpw("1234");
		vo.setUsername("관리자3");
		vo.setUseremail("admin3@admin.com");
		
		// MemberDAO 객체 생성x, 객체 주입o
		mdao.MemberJoin(vo);
		
		logger.info("회원가입 완료");
	}
	
	//@Test
	public void loginTest() {
		logger.info("로그인 테스트");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		MemberVO resultVO = mdao.MemberLogin(vo);
		if(resultVO != null) {
			logger.info("로그인 성공");
		} else {
			logger.info("로그인 실패");
		}
		
	}
	
	//@Test
	public void accountInfo() {
		logger.info("회원정보 조회");
		

		MemberVO vo = mdao.MemberInfo("admin");
		if(vo != null) {
			logger.info("vo: " + vo);
			logger.info("회원정보 조회 완료");
		} else {
			logger.info("세션정보 없음");
		}
	}
	
	//@Test
	public void Updateuser() {
		logger.info("회원정보 수정");
		
		//수정할 내용 객체 생성 
		MemberVO uvo = new MemberVO();
		uvo.setUserid("admin");
		uvo.setUserpw("1234");
		uvo.setUsername("관리자1");
		
		mdao.UpdateInfo(uvo);
		logger.info("uvo: " + uvo);
	}
	
	//@Test
	public void DeleteMember() {
		logger.info("회원정보 삭제");
			
		//수정할 내용 객체 생성 
		MemberVO dvo = new MemberVO();
		dvo.setUserid("admin");
		dvo.setUserpw("1234");
			
		// 회원 삭제
		int result = mdao.DeleteMember(dvo);
		
		if(result >= 1) {
			logger.info("회원정보 삭제 완료");
		}else {
			logger.info("회원정보 삭제 실패");
		}
	}
	
	@Test
	public void memberListTest() {
		
		List<MemberVO> memberList = mdao.MemberList();
		logger.info("👍0  memberList: " + memberList);
		logger.info("😁👍1 memberList: " + memberList);
		logger.info("😁😁👍2 memberList: " + memberList);
		logger.info("😁😁😁👍3 memberList: " + memberList);
 	} 
	
}
