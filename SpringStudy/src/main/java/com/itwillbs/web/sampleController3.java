package com.itwillbs.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class sampleController3 {

	private static final Logger logger 
		= LoggerFactory.getLogger(SampleController2.class);
	
	// http://localhost:8088/web/doC?msg=hello
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(@ModelAttribute("msg") String msg) {
		//@ModelAttribute("저장할데이터명") 데이터를 저장하는 변수 
		// -> 주소줄에 잇는 데이터(파라메터)를 저장 
		
		logger.info("😘logger😘doC() mapping");
		logger.info("😘logger😘msg: " + msg);
		// 컨트롤러 -> JSP로 정보 전달
		
		
		return "doC";
	}
	
	// http://localhost:8088/web/doC1?id=hello&pw=itwill
	@RequestMapping(value = "/doC1", method = RequestMethod.GET)
	public String doC1(@ModelAttribute("id") String id,@ModelAttribute("pw") String pw) {
	
		
		logger.info("doC1() mapping");
		logger.info("😘logger😘id: " + id);
		logger.info("😘logger😘id: " + pw);
		return "doC";
	}
	

}
