package com.shop.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.shop.entity.Notice;

import lombok.Getter;


@Getter
public class NoticeResponseDto {
   private Long gno;
   private String title;
   private String content;
   private String writer;
   private LocalDateTime regDate, modDate;
   private Long memberId; //멤버 번호
   private List<ReplyResponseDto> replyList;
   
   
   //entity -> dto
   	public NoticeResponseDto(Notice notice) {
   		this.gno = notice.getGno();
   		this.title = notice.getTitle();
   		this.content = notice.getContent();
   		this.writer = notice.getWriter();
   		this.regDate = notice.getRegTime();
   		this.modDate = notice.getUpdateTime();
   		this.memberId = notice.getMember().getId();
   		this.replyList = notice.getReplyList().stream()
   				.map(ReplyResponseDto::new).collect(Collectors.toList());
}
   
   
}