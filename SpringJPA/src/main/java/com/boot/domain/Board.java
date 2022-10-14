package com.boot.domain;



import java.util.Date;

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
	private String writer;	//글쓴이
	private String content;	//글내용
	private Date createDate;//작성일
	private long cnt;		//조회수
}
