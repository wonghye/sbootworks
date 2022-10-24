package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Item;

public interface Itemrepository extends JpaRepository<Item, Long> {

	//상품명으로 검색
	List<Item> findByItemNm(String itemNm);
	
	//가격순으로 정렬
	List<Item> findByPriceLessThanOrderByPriceDesc(Integer Price);
	
}
