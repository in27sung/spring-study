package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController2 {

	private static final Logger logger 
		= LoggerFactory.getLogger(SampleController2.class);
	
	// http://localhost:8088/web/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		logger.info("doB() mapping");
		
		// 매핑된 메서드의 리턴타입이 String일 때,
		// 리턴 문자.jsp view page연결 
		return "itwill";
	}
	
	// http://localhost:8088/web/doB1
	@RequestMapping(value = "/doB1", method = RequestMethod.GET)
	public void /*double*/ /*int*/ doB1() {
		// * 매핑된 메서드의 리턴타입이 void, String이 아닌 경우 
		// 실행 불가(but, 나중에 사용가능) 
		logger.info("doB() mapping");
		
		// 매핑된 메서드의 리턴타입이 String일 때,
		// 리턴 문자.jsp view page연결 
	}
}
