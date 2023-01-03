package di.service;

import di.dto.MemberDTO;

public interface MemberService {
	// 기본키 1개를 받아서 하나의 데이터를 반화나흔 메서드
	// 매개변수나 반환형에 Entity Type 을 사용하면 안된다.
	public MemberDTO findById(String id);
}
