package di.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Good2;

@Repository
public class HibernateRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertGood(Good2 good) {
		Session session = sessionFactory.getCurrentSession();
		
		// 데이터 추가
		session.save(good);
	}
}
