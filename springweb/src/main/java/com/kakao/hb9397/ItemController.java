package com.kakao.hb9397;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kakao.hb9397.dto.ItemDTO;
import com.kakao.hb9397.dto.Member;
import com.kakao.hb9397.service.ItemService;
import com.kakao.hb9397.validation.MemberValidator;

import lombok.RequiredArgsConstructor;

//Controller�� ����� ���� ������̼�
@Controller
@RequiredArgsConstructor
public class ItemController {
	private final ItemService itemService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		// ���� �޼��� ȣ��
		List<ItemDTO> list = itemService.allItem();
		
		// ��� ����
		model.addAttribute("list",list);
		
		// ��ȯ�ϴ� ���ڿ��� View�� �̸��̴�. �̺κ��� /src/main/resource/WEB-INF/spring/appServlet�� servlet-context.xml �� ���޵Ǿ�
		// View Resolver ���� �κп��� ��ȯ�� �� �̸��� ������ �������� /WEB-INF/views/home.jsp �� ��ϵǰ� �ȴ�
		// /WEB-INF/views/home.jsp ��ġ���� Ȯ�� �� �� �ִ�.
		return "home";
	}
	// @RequestMapping(value="detail", method=RequestMethod.GET)
	@RequestMapping(value="detail/{itemid}", method=RequestMethod.GET)
	// public String detail(Model model, @RequestParam("itemid") int itemid) {
	public String detail(Model model, @PathVariable("itemid") int itemid) {
		// ���� �޼��� ȣ��
		ItemDTO dto = itemService.getItem(itemid);
		
		// ������ ����
		model.addAttribute("item", dto);
		
		// ����� view �̸� ����
		return "detail";
	}
	
	// item.xls ��û�� ���� �� excel �̶�� ��� ���
	@RequestMapping(value = "item.xls", method=RequestMethod.GET)
	public String excel(Model model) {
		
		List<ItemDTO> list = itemService.allItem();
		model.addAttribute("list", list);
		
		return "excel";
	}
	
	// item.pdf ��û�� ���� ��  pdf �̶�� ��� ���
	@RequestMapping(value = "item.pdf", method=RequestMethod.GET)
	public String pdf(Model model) {
			
		List<ItemDTO> list = itemService.allItem();
		model.addAttribute("list", list);
			
		return "pdf";
	}
	
	// itemlist.json ��û�� ���� ��  json �̶�� ��� ���gkehfhr cjfl
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
	
	// ���ܰ� �߻����� �� ó���ϱ� ���� �޼���
	@ExceptionHandler(Exception.class)
	public String handleException(Model model, Exception e) {
		model.addAttribute("result", e.getLocalizedMessage());
		
		return "error/exception";
	}
	
	// 메시지 요청을 처리할 메서드
	// 유효성 검사에 실패했을 때 이전 입력한 내용을 가지고 logingform 으로 가도록 수정
	@RequestMapping(value="message", method=RequestMethod.GET)
	public String form(@ModelAttribute("member") Member member) {
		return "loginform";
	}
	
	// @ModelAttribute 가 추가된 메서드는 반환하는 데이터르 모든 뷰에 전송한다.
	@ModelAttribute("loginTypes")
	public List<String> loginTypes(){
		List<String>list = new ArrayList<String>();
		list.add("일반회원");
		list.add("기업회원");
		list.add("비회원");
		return list;
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String submit(@ModelAttribute("member") Member member,
			Member memberInfo, BindingResult result) {
	    //유효성 검사 수행
		new MemberValidator().validate(memberInfo,result);
		if(result.hasErrors()) {
			return "loginform";
		}else {
			return "created";
		}
	}
	
}


