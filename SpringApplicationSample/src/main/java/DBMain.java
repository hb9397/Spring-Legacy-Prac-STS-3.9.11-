import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Hibernate;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.persistence.HibernateRepository;
import domain.Good2;

public class DBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// XML 을 이용한 Bean 사용
		   try(GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml")){
			   
			   SqlSessionFactory sqlFactory = context.getBean("sqlSessionFactory", SqlSessionFactory.class);
			   
			   System.out.println(sqlFactory);
			   
			   SqlSession session = sqlFactory.openSession();
			   System.out.println(session);
			   
			   
			
			  // GoodRepository repository = context.getBean(GoodRepository.class);
			   
			// insert Test
			 /* Good good
			 * = Good.builder().code(2).name("사과").manufacture("나주").price(5000).build();
			 * repository.insertGood(good);
			 */
			   
			   //Select Test
			/*
			 * List<Good> list = repository.allGood(); for(Good good : list) {
			 * System.out.println(good); }
			 */
			 
			 // 항상 존재하지 않는 데이터도 해보기
			 // Good good = repository.getGood(10);
			/*
			 * Good good = repository.getGood(1); System.out.println(good);
			 */
			  
			/*
			 * GoodMapper repository = context.getBean(GoodMapper.class); List<Good> list =
			 * repository.allGood(); for(Good good : list) { System.out.println("Good:" +
			 * good); }
			 */
			  
			  HibernateRepository repository = context.getBean(HibernateRepository.class);
			  
			  Good2 good = Good2.builder()
					  .code(301)
					  .name("단갑")
					  .manufacture("진영")
					  .price(10000)
					  .build();
			 repository.insertGood(good);
		   }catch(Exception e) {
			   System.out.println(e.getLocalizedMessage());
		   }
	}

}
