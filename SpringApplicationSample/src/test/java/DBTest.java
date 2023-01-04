import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")

public class DBTest {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try {
			// 여기서 예외가 발생한다면 이름이 잘못됬거나 의존성 설정을 잘못한것.
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 연결
			Connection con = DriverManager
					.getConnection("jdbc:mariadb://localhost:3306/SpringLegacy", "root", "8236");
			
			System.out.println(con);
			con.close();
			
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
