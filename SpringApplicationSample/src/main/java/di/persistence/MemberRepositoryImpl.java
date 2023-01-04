package di.persistence;

import org.springframework.stereotype.Repository;

import di.entity.MemberEntity;

// bean 을 자동으로 생성해주는 어노테이션
@Repository
public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public MemberEntity findById(String id) {
		MemberEntity memberEntity = 
				MemberEntity.builder()
				.id("adam")
				.password("1234")
				.nickname("1234")
				.build();
		return memberEntity;
	}

}
