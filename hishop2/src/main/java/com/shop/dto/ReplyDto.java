package com.shop.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.shop.entity.Member;
import com.shop.entity.Notice;
import com.shop.entity.Reply;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReplyDto {
	
	private Long rno;
	private String text;	//댓글 내용
	private String regDate, modDate =
			LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
	private Member member;
	private Notice notice;
	
	//dto -> entity
	public Reply toEntity() {
		Reply replyList = Reply.builder()
				.rno(rno)
				.text(text)
				.regDate(regDate)
				.modDate(modDate)
				.member(member)
				.notice(notice)
				.build();
				
		return replyList;		
				
	}
}
