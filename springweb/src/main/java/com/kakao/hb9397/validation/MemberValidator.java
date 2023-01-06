package com.kakao.hb9397.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kakao.hb9397.dto.Member;

public class MemberValidator implements Validator {
	
	
	// 유효성 검사를 수행할 DTO 설정
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// 유효성 검사를 수행할 메서드 
	@Override
	public void validate(Object target, Errors errors) {
		// 검사를 할 대상의 원래 자료형으로 형 변환
		Member member = (Member) target;	
		
		// 검사
		if(member.getEmail() == null || member.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		
		if(member.getPw() == null || member.getPw().trim().isEmpty()) {
			errors.rejectValue("pw", "required");
		}
	}

}
