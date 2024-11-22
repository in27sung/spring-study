package com.itwillbs.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
//@Setter
//@Getter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class MemberVO {
	// MemberDTO(Data Transfer Object)
	// MemberVO(Value Object)
	
	private String userid;
	private String userpw;
	private String username;
	private String useremail;
	private Timestamp regdate;
	private Timestamp updateDate;
}
