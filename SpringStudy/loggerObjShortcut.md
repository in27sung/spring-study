Window -> Preferences -> Java -> Editor -> Templates

1) new 버튼 클릭
2) 
 Name : mylog
 Context : Java
 Automatically insert : yes(check)
 Desciption : 로거 객체를 생성(사용준비)
 Pattern :
${:import(org.slf4j.Logger,org.slf4j.LoggerFactory)}

private static final Logger logger
   = LoggerFactory.getLogger(${enclosing_type}.class);

--------------------------------------------------------

1) new 버튼 클릭
2) 
 Name : li
 Context : Java
 Automatically insert : yes(check)
 Desciption : logger.info() 메서드 사용
 Pattern :
 logger.info("${cursor}");

--------------------------------------------------------

1) new 버튼 클릭
2) 
 Name : ld
 Context : Java
 Automatically insert : yes(check)
 Desciption : logger.debug() 메서드 사용
 Pattern :
 logger.debug("${cursor}");

