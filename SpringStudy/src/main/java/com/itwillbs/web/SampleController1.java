package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class SampleController1 {
	
	
	// mylog 단축명령어
	private static final Logger logger 
		= LoggerFactory.getLogger(SampleController1.class);
	
	//http://localhost:8088/web/doA
	@RequestMapping(value = "/doA")
	public void doA() {
		// 메서드의 리턴타입이 void일 때
		// 주소의 이름.jsp 페이지를 자동 연결
		logger.info("doA() 실행");
	}
}
