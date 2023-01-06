package com.kakao.hb9397;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	// @RequestMapping(value="detail", method=RequestMethod.GET)
	@RequestMapping(value="detail/{itemid}", method=RequestMethod.GET)
	// public String detail(Model model, @RequestParam("itemid") int itemid) {
	public String detail(Model model, @PathVariable("itemid") int itemid) {
		// 서비스 메서드 호출
		ItemDTO dto = itemService.getItem(itemid);
		
		// 데이터 전달
		model.addAttribute("item", dto);
		
		// 출력할 view 이름 설정
		return "detail";
	}
	
	// item.xls 요청이 왔을 때 excel 이라는 뷰로 출력
	@RequestMapping(value = "item.xls", method=RequestMethod.GET)
	public String excel(Model model) {
		
		List<ItemDTO> list = itemService.allItem();
		model.addAttribute("list", list);
		
		return "excel";
	}
	
	// item.pdf 요청이 왔을 때  pdf 이라는 뷰로 출력
	@RequestMapping(value = "item.pdf", method=RequestMethod.GET)
	public String pdf(Model model) {
			
		List<ItemDTO> list = itemService.allItem();
		model.addAttribute("list", list);
			
		return "pdf";
	}
	
	// itemlist.json 요청이 왔을 때  json 이라는 뷰로 출력gkehfhr cjfl
	@RequestMapping(value = "itemlist.json", method=RequestMethod.GET)
	public String jsonReport(Model model) {
				
		List<ItemDTO> list = itemService.allItem();
		model.addAttribute("list", list);
				
		return "itemlist";
	}
	
	@RequestMapping(value="exception",method=RequestMethod.GET)
		public String input(Model model) {
		return "input";
	}
	
	@RequestMapping(value="exception", method=RequestMethod.POST)
	public String input(Model model, 
			@RequestParam("num1") int num1,
			@RequestParam("num2") int num2) {
		int result = num1 + num2;
		model.addAttribute("result", result);
		return "result";
	}
}


