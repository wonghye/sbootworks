package com.shop.entity;

import java.awt.ItemSelectable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.shop.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@Entity
public class Item {	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private Long id;	//자동순번
	
	@Column(nullable = false, length = 50)
	private String itemNm;	//상품 이름
	
	@Column(nullable = false )
	private int price;		//상품 가격
	
	@Column(nullable = false )
	private int stockNumber;//재고 수량
	
	@Lob //large object
	@Column(nullable = false )
	private String itemDetail;//상세 설명
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	private LocalDateTime regTime; 		// 등록 시간
	
	private LocalDateTime updateTime;	//수정 시간
	
}
