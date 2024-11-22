package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController4 {

	private static final Logger logger 
		= LoggerFactory.getLogger(SampleController4.class);
	
	//http://localhost:8088/web/doD?userid=admin&userpw=1234&msg=hello
	//@RequestMapping(value = "/doD", method = RequestMethod.GET)
	@GetMapping(value = "/doD")
	public void doD(/*@ModelAttribute*/ MemberVO vo,
						@ModelAttribute("msg") String msg) {
		logger.info("😘logger😘doD() mapping");
		logger.info("객체를 사용해서 정보 전달");
		
		///*@ModelAttribute*/ MemberVO vo
		// 1) 파라미터 정보를 저장
		// 2) 전달된 정보를 객체(Model)에 저장 
		
		// model.add(vo);
		// model.add("msg",msg);
		
		// 파라메터정보를 자동 수집이 가능
		// 해당객체가 포함된 파라메터정보라면 자동으로 객체에 정보 저장
		logger.info("vo: " + vo);
		logger.info("msg: " + msg);
		
	}
	//http://localhost:8088/web/doD1?userid=admin&userpw=1234&msg=hello
	@GetMapping(value = "/doD1")
	public String doD1(Model model/*MemberVO vo1*/) {
		// Model: 컨트롤러의 정보를 뷰페이지로 전달하는 객체
		logger.info("😘SampleController4😘doD1() mapping");
		
		// MemberVO 객체 생성 -> DB에서 가져온 객체 
		MemberVO vo = new MemberVO();
		vo.setUserid("DBID");
		vo.setUserpw("DBPW");
		vo.setUsername("DBNAME");
		
		// model 객체에 정보를 저장 
//		model.addAttribute("vo", vo); // 이름, 전달정보(객체)
		model.addAttribute(vo); // 전달정보(객체)
		// -> 전달하는 객체의 이름이 없을때
		//    전달하는 객체의 데이터타입을 첫글자 소문자로 변경 후 
		//    이름으로 사용해서 (memberVO) 전달됨 
		
		return "/doD";
	}
	
	
	//http://localhost:8088/web/doD2?userid=admin&userpw=1234
	@GetMapping(value = "/doD2")
	public String doD2(Model model,@ModelAttribute("pvo") MemberVO pvo) {
		// Model: 컨트롤러의 정보를 뷰페이지로 전달하는 객체
		logger.info("😘SampleController4😘doD1() mapping");
		
		// MemberVO 객체 생성 -> DB에서 가져온 객체 
		MemberVO dvo = new MemberVO();
		dvo.setUserid("DBID");
		dvo.setUserpw("DBPW");
		dvo.setUsername("DBNAME");
		
		// model 객체에 정보를 저장 
//		model.addAttribute("vo", vo); // 이름, 전달정보(객체)
		model.addAttribute(dvo); // 전달정보(객체)
		// -> 전달하는 객체의 이름이 없을때
		//    전달하는 객체의 데이터타입을 첫글자 소문자로 변경 후 
		//    이름으로 사용해서 (memberVO) 전달됨 
		
		return "/doD";
	}
}
