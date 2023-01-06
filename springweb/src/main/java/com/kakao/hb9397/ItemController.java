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
}


