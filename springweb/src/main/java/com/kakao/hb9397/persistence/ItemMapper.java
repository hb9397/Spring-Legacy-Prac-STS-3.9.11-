package com.kakao.hb9397.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kakao.hb9397.domain.ItemEntity;
import com.kakao.hb9397.dto.ItemDTO;

@Repository
public interface ItemMapper {
	@Select("select * from item")
	public List<ItemEntity> allItem();
		
}