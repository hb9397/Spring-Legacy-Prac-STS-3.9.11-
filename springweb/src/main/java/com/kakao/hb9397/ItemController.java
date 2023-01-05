package com.kakao.hb9397;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kakao.hb9397.dto.ItemDTO;
import com.kakao.hb9397.service.ItemService;

import lombok.RequiredArgsConstructor;

//Controller를 만들기 위한 어노테이션
@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// 서비스 메서드 호출
		List<ItemDTO> list = itemService.allItem();
		
		// 결과 저장
		model.addAttribute("list",list);
		
		// 반환하는 문자열이 View의 이름이다. 이부분이 /src/main/resource/WEB-INF/spring/appServlet의 servlet-context.xml 로 전달되어
		// View Resolver 설정 부분에서 반환한 뷰 이름과 설정이 합쳐저서 /WEB-INF/views/home.jsp 로 등록되게 된다
		// /WEB-INF/views/home.jsp 위치에서 확인 할 수 있다.
		return "home";
	}
}
