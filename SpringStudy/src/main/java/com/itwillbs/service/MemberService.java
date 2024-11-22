package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {
	
	//실행하려는 동작 추상메서드로 구현 
	
	//회원가입 
	public void memberJoin(MemberVO vo);
	
	//로그인
	public MemberVO memberLogin(MemberVO vo);
	
	//회원정보 조회
	public MemberVO memberInfo(String userid);
	
	//회원정보 수정 
	public void UpdateInfo(MemberVO uvo);
	
	// Delete account
	public int DeleteMember(MemberVO dvo);
	
	// 회원정보 목록(list)
	public List<MemberVO> MemberList();
}
