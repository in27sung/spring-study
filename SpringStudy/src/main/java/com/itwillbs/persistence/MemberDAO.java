package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/**
 *	MemberDAO 인터페이스 
 *	Member관련된 테이블(tbl_member)의 정보를 처리하는 객체 
 *	-> 상속해서 구현 (추상메서드 사용) 
 *
 */
public interface MemberDAO {
	
	// 시간정보 조회동작 
	public String getTime();
	public String getTime2();
	
	// 회원가입 동작
	public void MemberJoin(MemberVO vo);
	
	// 로그인 체크 동작 
	public MemberVO MemberLogin(MemberVO vo);
	
	// accountInfo
	public MemberVO MemberInfo(String userid);
	
	// Update info 
	public void UpdateInfo(MemberVO uvo);
	
	// Delete account
	public int DeleteMember(MemberVO dvo);
	
	// 회원정보 목록(list)
	public List<MemberVO> MemberList();
	
}
