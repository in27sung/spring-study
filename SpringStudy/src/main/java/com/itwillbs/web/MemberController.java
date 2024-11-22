package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*") 
// *.me 와 같이 member로 시작하는 모든 주소를 여기서 실행 
public class MemberController {

	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	//MemberDAO 객체 root-context.xml주입
	@Inject
//	private MemberDAO mdao;
	private MemberService mService;
	
	//http://localhost:8088/member/join
	// 회원가입(sign up) - 정보입력 / GET 방식
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.info("/member/join -> memberJoinGET() 실행");
		logger.info("주소에 맞는 view페이지 매핑(보여주기)");
		
//		return "/member/join"; = /view/member/join.jsp 연결
	}
	
	// 회원가입(sign up) - 정보처리 / POST 방식(Form 태그) 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberJoinPost(/*@ModelAttribute*/ MemberVO vo) {
		logger.info("/member/join -> memberJoinAction() 실행");
		
		
		// 전달정보 저장 
		logger.info("vo: " + vo);
		
		// MemberDAO객체가 필요 -> 주입
		// DB에 정보를 전달 - 회원가입 동작 실행 
		// 서비스 -> DAO 호출
//		mdao.memberJoin(vo); -> 잘못됨(tight coupled)
		mService.memberJoin(vo);
		
		//로그인 페이지 이동
		return "redirect:/member/login"; // /view/join.jsp 연결
	}
	
	//http://localhost:8088/member/login (GET)
	// 로그인 - 정보입력 / GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberLoginGET() {
		logger.info("memberLoginGET() 호출");
		logger.info("/member/login.jsp 뷰페이지 연결");
		
	}
	
	// 로그인 - 정보처리 / POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberLoginPOST(MemberVO vo, 
								  RedirectAttributes rttr,
								  HttpSession session) {
		logger.info("memberLoginPOST() 호출");
		
		// 전달정보(입력한 로그인정보) 저장 
		logger.info("vo: " + vo);
		
		// 서비스 -> DAO(로그인 체크) 호출
		MemberVO resultVO = mService.memberLogin(vo);
		
		// 호출결과에 따라 main페이지/로그인 페이지로 이동 
		if(resultVO != null) {
			// 로그인 성공 
			logger.info("로그인 성공");
			logger.info("/member/main -> /member/main.jsp 뷰페이지 연결");
			
			// 로그인 정보 전달
			rttr.addFlashAttribute("result", resultVO.getUserid());
			// 사용자의 정보(아이디) 세션에 저장 
			session.setAttribute("userid", resultVO.getUserid());
			return "redirect:/member/main";
		}

		logger.info("로그인 실패");
		return "redirect:/member/login";
	}
	
	//http://localhost:8088/member/main (GET)
	// 메인페이지 - GET
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void memberMainGET() {
		logger.info("memberMainGET() 호출");
		logger.info("/member/main.jsp 뷰페이지 연결");
		
	}
	
	//http://localhost:8088/member/logout (GET)
	// 로그아웃 - GET
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.info("memberLogoutGET() 호출");
		logger.info("/member/main.jsp 뷰페이지 연결");
		
		// 로그아웃 처리(세션정보 초기화)
		session.invalidate();
		
		// 로그아웃 처리 후 페이지 이동
		return "redirect:/member/main";
	}
	
	//http://localhost:8088/member/info (GET)
	// 회원정보 조회 - GET
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void memberInfoGET(Model model,
			@SessionAttribute(name = "userid") String userid) {
		logger.info("memberInfoGET() 호출");
		
		// 세션에 저장된 아이디 정보를 가져오기 
		logger.info("userid: " + userid);
		
		// 서비스 -> DAO 호출 (회원정보 조회)
		MemberVO resultVO = mService.memberInfo(userid);
		
		// 결과정보를 저장 view페이지 전달 & 출력 (Model 객체)
		model.addAttribute("resultVO", resultVO);
		
		logger.info("/member/info.jsp 뷰페이지 연결");
	}
	
	//http://localhost:8088/member/update (GET)
	// 회원정보 수정 - GET
	// 기존정보를 가져와서 보여주고, 수정할 정보를 입력
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void memberUpdateGET(
			@SessionAttribute(name = "userid") String userid,
			Model model) {
		logger.info("memberUpdateGET(userid, model) 호출");
		
		//사용자의 ID정보를 가져오기(세션)
		logger.info("userid: " + userid);
		
		// 서비스 -> DAO 회원정보 가져오는 동작 호출 
		MemberVO resultVO = mService.memberInfo(userid);
		
		// 연결된 뷰페이지에 출력 
		// -> model 객체에 정보 저장 
		model.addAttribute("resultVO",resultVO);
		// /member/update.jsp 뷰페이지 연결
		
	}
	
	// 회원정보 수정 - POST
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdatePOST(@ModelAttribute MemberVO uvo) {
		logger.info("memberUpdatePOST(vo) 호출");

		// 전달정보(수정정보) 저장 
		logger.info("😘😘😘😘vo: " + uvo);
		
		// 서비스 -> DAO 호출 (회원정보 수정)
		mService.UpdateInfo(uvo);
		
		// 수정완료시 메인페이지로 이동 
		return "redirect:/member/main";
		
	}
	
	// 회원정보 삭제 - GET
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void memberDeleteGET() {
		logger.info("memberDeleteGET() 실행");
		logger.info("/member/delte.jsp 페이지 연결");
		
	}
	
	// 회원정보 삭제 - POST
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String memberDeletePOST(RedirectAttributes rttr,
			MemberVO dvo,
			HttpSession session) {
		logger.info("memberDeleteGET() 호출");
		
		logger.info("vo: " + dvo);
		// 서비스 -> DAO 회원정보 가져오는 동작 호출 
		int result = mService.DeleteMember(dvo);
		
		if(result == 0) {
			// 로그인 정보 전달
			rttr.addFlashAttribute("result", result);
			return "redirect:/member/delete";
		}
		
		// 로그아웃 처리(세션정보 초기화)
		session.invalidate();		
		// 연결된 뷰페이지에 출력 	
		return "redirect:/member/main";
	}
	
	// 회원목록 조회 - 회원정보를 리스트 형태로 가져오기 (GET)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberListGET(Model model) {
		logger.info("memberListGET() 호출");
		
		// 서비스 -> DAO (회원 리스트 가져오기 동작)
		List<MemberVO> memberList = mService.MemberList();
		// <>: diamond operator// generric(templet(C_++)
		// MemberVO 전용 배열 
		
		// 테이블의 행(row) 수 출력 
		logger.info("회원수: " + memberList.size());
		
		// 뷰페이지에 정보를 전달(model 객체)
		model.addAttribute("memberList", memberList);
		
		return "/member/list";
	}
}
