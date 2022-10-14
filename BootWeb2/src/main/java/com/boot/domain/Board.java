package com.boot.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Board {
	
	@Id @GeneratedValue
	private long seq;		//글번호
	
	private String title;	//글제목
	
	@Column(updatable = false)	// 수정 update 할 때 수정 불가로 설정
	private String writer;	//글쓴이
	private String content;	//글내용
	
	@Column(insertable = false, updatable = false, 
			columnDefinition ="timestamp default current_timestamp") //입력을 수동하지 않게 설정 (자동으로)
	private Date createDate;//작성일
	
	@Column(insertable = false, updatable = false,
			columnDefinition ="bigint default 0")
	private long cnt;		//조회수
}
