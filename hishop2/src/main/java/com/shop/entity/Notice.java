package com.shop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.shop.config.BaseEntity;
import com.shop.dto.NoticeDto;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
public class Notice extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gno;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(length = 1500, nullable = false)
	private String content;
	
	@Column(nullable = false)
	private String writer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@OrderBy("rno asc")	//댓글 정렬
	private List<Reply> replyList;
	
	
	//수정 시간 테스트 메서드 생성
	public void changeTitle(String title ) {
		this.title = title;
	}
	public void changeContent(String content) {
		this.content = content;
	}
	
   Notice dtoToEntity(NoticeDto dto) {
  Notice entity = Notice.builder()
                      .gno(dto.getGno())
                      .title(dto.getTitle())
                      .content(dto.getContent())
                      .writer(dto.getWriter())
                      .build();
      return entity;
   }
	
	
}
