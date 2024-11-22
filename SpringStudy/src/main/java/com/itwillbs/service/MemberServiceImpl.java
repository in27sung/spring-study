package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// 서비스동작: DAO메서드 호출 
// @Service: 해당 객체를 서비스 객체로 등록(root-context.xml)

@Service
public class MemberServiceImpl implements MemberService{
	
	

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Inject
	private MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberVO vo) {
		mdao.MemberJoin(vo);
		
//		mdao.MemberJoinOracle(vo); -> 각각의 비지니스 로직을 처리 
//		mdao.MemberJoinMySQL(vo);
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.info("memberLogin(MemberVO vo) 호출");
		
		// DAO 로그인체크 동작 실행 
		MemberVO resultVO = mdao.MemberLogin(vo);
		
		
		return resultVO;
	}

	@Override
	public MemberVO memberInfo(String userid) {
		logger.info("memberInfo(String userid) 호출");
		
		// DAO 회원정보 조회 동작 실행 
		return mdao.MemberInfo(userid);
	}

	@Override
	public void UpdateInfo(MemberVO uvo) {
		logger.info("UpdateInfo(MemberVO uvo) 호출");
		
		// DAO 회운정보 수정메서드 호출 
		mdao.UpdateInfo(uvo);
	}

	@Override
	public int DeleteMember(MemberVO dvo) {
		logger.info("DeleteMember(MemberVO dvo) 호출");
		
		// 쿼리 실행시 리턴 1 else 0
		return mdao.DeleteMember(dvo);
	}

	@Override
	public List<MemberVO> MemberList() {
		logger.info("MemberList() 호출");
		
		return mdao.MemberList();
	}
	
	
	
	
}
