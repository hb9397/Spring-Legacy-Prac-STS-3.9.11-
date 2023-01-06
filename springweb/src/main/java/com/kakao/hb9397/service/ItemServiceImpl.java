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
	
	// @Autowired 대신에  상단에 @RequiredArgsConstructor + final를 붙혀서 사용하던지 둘중에 하나 사용
	private final ItemMapper itemMapper;
	
	// Service 인터페이스의 모든데이터를 가져오는 메서드 재정의
	@Override
	public List<ItemDTO> allItem() {
		List<ItemDTO> list = new ArrayList<>();
		//Repository 메서드 호출
		List<ItemEntity> result = itemMapper.allItem();
		// 결과 변환
		for (ItemEntity entity : result) {
			list.add(entityToDTO(entity));
		}
		return list;
	}
	@Override
	public ItemDTO getItem(int itemid) {
		ItemDTO dto = null;
		// 데이터 가져오기
		ItemEntity entity = itemMapper.getItem(itemid);
		
		// null 여부  확인하고 변환
		if(entity != null) {
			dto = entityToDTO(entity);
		}
		return dto;
	}
}
