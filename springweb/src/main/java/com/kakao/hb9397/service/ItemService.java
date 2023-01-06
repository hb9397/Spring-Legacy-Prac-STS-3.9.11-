package com.kakao.hb9397.service;

import java.util.List;

import com.kakao.hb9397.domain.ItemEntity;
import com.kakao.hb9397.dto.ItemDTO;

public interface ItemService {
	// ��ü �����͸� �������� �޼���
	public List<ItemDTO> allItem();
	
	// �ϳ��� �����͸� �������� �޼���
	public ItemDTO getItem(int itemid);
	
	//DTO�� Entity�� ��ȯ�ϴ� �޼���
	public default ItemEntity dtoToEntity(ItemDTO dto) {
	ItemEntity entity = ItemEntity.builder()
			.itemid(dto.getItemid())
			.itemname(dto.getItemname())
			.description(dto.getDescription())
			.pictureurl(dto.getPictureurl())
			.price(dto.getPrice())
			.build();
				
		return entity;
	}
		
//Entity�� DTO�� ��ȯ�ϴ� �޼���
	public default ItemDTO entityToDTO(ItemEntity entity) {
		ItemDTO dto = ItemDTO.builder()
				.itemid(entity.getItemid())
				.itemname(entity.getItemname())
				.description(entity.getDescription())
				.pictureurl(entity.getPictureurl())
				.price(entity.getPrice())
				.build();
		return dto;
	}
}
