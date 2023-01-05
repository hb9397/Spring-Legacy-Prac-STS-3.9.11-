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
}
