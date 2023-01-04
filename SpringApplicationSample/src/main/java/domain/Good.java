package domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// getter, setter, equals, hashCode, toString 생성
@Data

// 매개변수 없는 생성자   
@NoArgsConstructor

// 모든 매개변수를 받는 생성자
@AllArgsConstructor

// 빌더 패턴을 이용해서 최대 매개변수 만큼의 생성자를 호출할 수 있도록 해주는 어노테이션
// @NoArgsConstructor 이 무조건 있어야 한다.
@Builder
public class Good {
	private int code;
	private String name;
	private String manufacture;
	private int price;
	private Date shelflife;
}
