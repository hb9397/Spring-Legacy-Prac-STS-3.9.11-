package com.kakao.hb9397.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kakao.hb9397.domain.ItemEntity;
import com.kakao.hb9397.dto.ItemDTO;
import com.kakao.hb9397.persistence.ItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
	/*
	 * @Autowired private ItemMapper itemMapper;
	 */
	
	// @Autowired ��ſ�  ��ܿ� @RequiredArgsConstructor + final�� ������ ����ϴ��� ���߿� �ϳ� ���
	private final ItemMapper itemMapper;
	
	// Service �������̽��� ��絥���͸� �������� �޼��� ������
	@Override
	public List<ItemDTO> allItem() {
		List<ItemDTO> list = new ArrayList<>();
		//Repository �޼��� ȣ��
		List<ItemEntity> result = itemMapper.allItem();
		// ��� ��ȯ
		for (ItemEntity entity : result) {
			list.add(entityToDTO(entity));
		}
		return list;
	}
	@Override
	public ItemDTO getItem(int itemid) {
		ItemDTO dto = null;
		// ������ ��������
		ItemEntity entity = itemMapper.getItem(itemid);
		
		// null ����  Ȯ���ϰ� ��ȯ
		if(entity != null) {
			dto = entityToDTO(entity);
		}
		return dto;
	}
}
