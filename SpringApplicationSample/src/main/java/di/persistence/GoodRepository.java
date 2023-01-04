package di.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Good;

// 레포지토리 인스턴스를 생성하도록
//@Repository
public class GoodRepository {
	
	// 생성자, 필드, setter의 경우 Autowired 사용가능, 기본값이 true로 의존성 주입할 대상을 찾지 못하면 컴파일 실패
	// SqlSession 의 생성자를 주입받는 필드로 @Autowired를 사용한 경우다.
	//@Autowired
	private SqlSession sqlSession;
	
	public int insertGood(Good good) {
		
		// 삽입을 제외한 모든 메서드의 반환형은 int이다.
		return sqlSession.insert("insertGood", good);
	}
	
	// Select 문 중 여러개를 뽑아오는 구문은 List로 가져ㅑ온다.
	public List<Good> allGood(){
		return sqlSession.selectList("allGood");
	}

	public Good getGood(int code) {
		return sqlSession.selectOne("getGood", code);
	}
}
