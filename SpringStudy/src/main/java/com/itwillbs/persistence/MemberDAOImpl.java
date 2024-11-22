package com.itwillbs.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

/**
 * MemberDAO인터페이스의 동작을 직접 구현 
 * -> 추상메서드를 구현(오버라이딩)  
 *
 */
// @Repository: 해당DAO객체를 스프링(root-context.xml)에 빈(객체)등록 
// -> MemberDAO 동작을 수행 

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	

	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	// SqlSessionFactory 객체 정보를 주입 (root-context.xml)을 받아와야 주입이 완료됨 
	@Inject
	private SqlSessionFactory sqlFactory;
	// SqlSession 객체 정보를 주입(root-context.xml)
	// -> 디비 연결 자동수행 
	@Inject
	private SqlSession sqlSession;
	
	// mapper의 경로를 상수로 저장 
	private static final String NAMESPACE = 
			"com.itwillbs.mapper.MemberMapper.";
	@Override
	public String getTime() {
		System.out.println("DAOImpl: getTime() 실행!");
		
		// 1.2. 디비연결 
		SqlSession sqlSession = sqlFactory.openSession();
		
		// 3. SQL작성 & pstmt객체
		
		// 3-1. ???
		
		// 4. SQL 실행
		//sqlSession.selectOne(sql구문);
		String date = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		// 5. 데이터 처리(rs)
		
		return date;
		
		
	}


	@Override
	public String getTime2() {
		
		//1.2. 디비연결 (자동)
		// 3. sql 구문 & pstmt 객체
		String date2 = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// 4. sql 실행
		// 5. 데이터 실행 
		
		return date2;
	}
	
	@Override
	public void MemberJoin(MemberVO vo) {
		// 'li' 단축명령어 
		logger.info("memberJoin(Member VO) 실행");
		
		// 1.2 디비연결 -> 생략 
		// 3. SQL 작성 & pstmt 객체 -> X (mapper / myBatis 자동생성)
		// 4. SQL 실행
		// sqlSession.insert("SQL 구문", 전달데이터);
		sqlSession.insert("com.itwillbs.mapper.MemberMapper.insertMember", vo);
		
		logger.info("회원가입 완료");		
	}


	@Override
	public MemberVO MemberLogin(MemberVO vo) {
		logger.info("memberLogin(MemebrVO vo) 실행");
		
		// SQL 실행 
		MemberVO resultVO = 
			sqlSession.selectOne(NAMESPACE + "loginCheck", vo);
		
		return resultVO;
	}


	@Override
	public MemberVO MemberInfo(String userid) {
		logger.info("memberAccountInfo(String userid) 실행");
		
		// SQL구문 실행 -> 회원정보 가져오기 
		
		return sqlSession.selectOne(NAMESPACE + "accountInfo", userid);
	}


	@Override
	public void UpdateInfo(MemberVO uvo) {
		logger.info("memberUpdateInfo(MemberVO uvo) 실행");
		
		// SQL 실행
		sqlSession.update(NAMESPACE + "updateMember", uvo);
		logger.info("회원정보 수정 완료");
	}


	@Override
	public int DeleteMember(MemberVO dvo) {
		logger.info("DeleteMember(MemberVO dvo) 실행");
		// ID, PW정보를 사용해서 삭제 
//		String id;
//		String pw;
//		Map<String, Object> paramObject
//			= new HashMap<String, Object>();
//		
//		paramObject.put("#이름에 해당하는 값", id);
//		paramObject.put("#이름에 해당하는 값", pw);
		
		return sqlSession.delete(NAMESPACE + "deleteMember", dvo);
	}

	@Override
	public List<MemberVO> MemberList() {
		logger.info("GetMemberList() 실행");
		
		
		return sqlSession.selectList(NAMESPACE + "memberList");
	}

	
}
