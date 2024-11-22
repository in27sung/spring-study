package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController5 {

	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	//http://localhost:8088/web/doE?msg=itwill
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
	public String doE(RedirectAttributes rttr/* @ModelAttribute("msg") String msg */) {
		             // model.addAttrutbue("msg",msg);
		logger.info("doE() 실행");
		
		// 데이터를 URI에 표시 O, F5 데이터 유지 
//		rttr.addAttribute("msg", "itwill");
		
		// 데이터를 URI에 표시 X, F5 데이터 유지 X (반드시 redirect이동시 사용가능)
		rttr.addFlashAttribute("msg", "itwillbusan");
		// session에 담겨서 움직임 

//		return "redirect:/doF"; // sendRedirect()방식으로 이동 
//		return "forward:/doF"; // forward()방식으로 이동 
//		logger.info("😘logger😘msg: " + msg);
		return "redirect:/doF";
	}
	//http://localhost:8088/web/doF
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
	public void doF(@ModelAttribute("msg") String msg) {
		logger.info("doF() 실행");
		logger.info("😘logger😘msg: " + msg);
	}
	
}