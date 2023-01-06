package com.kakao.hb9397;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kakao.hb9397.dto.ItemDTO;
import com.kakao.hb9397.service.ItemService;
import com.lowagie.text.pdf.AcroFields.Item;

@RestController
public class JSONController {
	
	// csv�� ��ȯ�ϴ� �޼���
	@RequestMapping(value="itemlist.csv", method=RequestMethod.GET)
	public String csv() {
		return "csv, xml, json";
	}
	
	// json dmf ��ȯ�ϴ� �޼���
	@Autowired
	private ItemService itemService;
	@RequestMapping(value="itemlistrest.json", method=RequestMethod.GET)
	public List<ItemDTO> json() {
		return itemService.allItem();
	}
}
