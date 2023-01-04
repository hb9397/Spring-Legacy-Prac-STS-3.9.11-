package di.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepository {
	@Autowired
	private SimpleJdbcInsert template;
	
	public void insert() {
		template.withTableName("goods");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 100);
		map.put("name", "쌀");
		map.put("manufacture", "경기도 이천");
		map.put("price", 10000);
		
		template.execute(map); // 정상작동
		map.put("code", 100); // 기본키 중복으로 인한 에러 발생
	}
}