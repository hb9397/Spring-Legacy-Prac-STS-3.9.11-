package di.persistence;

import di.entity.MemberEntity;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public MemberEntity findById(String id) {
		MemberEntity memberEntity = 
				MemberEntity.builder()
				.id("adam")
				.password("password")
				.nickname("nickname")
				.build();
		return memberEntity;
	}

}
