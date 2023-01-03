package persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/// 인스턴스를 생성해주는 Factory 클래스 
@Configuration
public class RepositoryFactory {
	
	
	// create 대신에 newInstance 사용해도 같은 의미를 가진다.
	// 매번 인스턴스를 생성해서 제공하게 된다.
	@Bean
	// 인스턴스를 만들어주는 메서드를 의미하게 된다.
	public static ItemRepository create() {
		return new ItemRepository();
	}
}
