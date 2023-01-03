import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import domain.Item;
import persistence.ItemRepository;
import persistence.RepositoryFactory;

public class Main {
   public static void main(String[] args) {
	  // ItemRepository itemRepository = new ItemRepository();
      
      // 인스턴스 생성을 다른 팩토리 클래스를 이용해서 생성
      // 다른 클래스의 메서드를 이용해서 인스턴스를 생성하는 것을
      // Factory Method Pattern 이라고 함.
      
      // 스프링이 인스턴스를 생성
      // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RepositoryFactory.class);
		/*
		 * ItemRepository itemRepository = RepositoryFactory.create(); ItemRepository
		 * itemRepository1 = RepositoryFactory.create();
		 */
      
      //RepositoryFactory 클래스의 create 메서드를 호출해서 ItemRepository 클래스의 인스턴스를 생성
		/*
		 * ItemRepository itemRepository = context.getBean("create",
		 * ItemRepository.class);
		 * 
		 * Item item = itemRepository.get(); System.out.println(item);
		 * 
		 * ItemRepository itemRepository1 = context.getBean("create",
		 * ItemRepository.class);
		 * 
		 * // 스프링은 싱글톤 패턴으로 생성하므로 2개의 해시코드는 일치
		 * System.out.println(System.identityHashCode(itemRepository));
		 * System.out.println(System.identityHashCode(itemRepository1));
		 * context.close();
		 */
	   
	   try(GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml")){
		   ItemRepository itemRepository = context.getBean("itemRepository", ItemRepository.class);
		   Item item = itemRepository.get();
		   System.out.println(item);
	   }catch(Exception e) {
		   System.out.println(e.getLocalizedMessage());
	   }
	   
   }
}