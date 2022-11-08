package com.shop.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.shop.entity.Member;
import com.shop.entity.Notice;
import com.shop.entity.Reply;

import lombok.Getter;
import lombok.Setter;


@Getter 
public class ReplyResponseDto {
	
	private Long rno;
	private String text;	//댓글 내용
	private String regDate, modDate =
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
	private String name;
	private Long gno;
	
	
	// entity -> dto
	public ReplyResponseDto(Reply reply) {
		this.rno = reply.getRno();
		this.text = reply.getText();
		this.regDate = reply.getRegDate();
		this.modDate = reply.getModDate();
		this.name = reply.getMember().getName();
		this.gno = reply.getNotice().getGno();
	}
				
}

