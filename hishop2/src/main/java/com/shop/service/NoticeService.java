package com.shop.service;

import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.shop.dto.NoticeDto;
import com.shop.dto.NoticeResponseDto;
import com.shop.dto.PageRequestDto;
import com.shop.dto.PageResultDto;
import com.shop.entity.Notice;
import com.shop.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class NoticeService {

	private final NoticeRepository noticeRepo;
	
   //게시글 등록(추상 메소드)
   @Override
	public Long register(NoticeResponseDto dto) {
	   log.info("DTO");
	   log.info(dto);
	   
	   NoticeResponseDto entity = dtoToEntity(dto);
	   log.info(entity);
	   
	   noticeRepo.save(entity);
	   
	   return dto.getGno();
   }
   
   /*
   //게시글 목록
   PageResultDto<NoticeDto, Notice> getList(PageRequestDto requestDto);
   
   //게시글 상세보기
   NoticeResponseDto read(Long gno);
   
   //게시글 업데이트
   NoticeResponseDto update(Long gno);
   */
   
   /*
   //자바 8버전부터 구체 메소드 사용 가능(default 키워드로 가능)
   default Notice dtoToEntity(NoticeDto dto) {
      Notice entity = Notice.builder()
                              .gno(dto.getGno())
                              .title(dto.getTitle())
                              .content(dto.getContent())
                              .writer(dto.getWriter())
                              .build();
      return entity;
   }
   
   default NoticeDto entityToDto(Notice entity) {
      NoticeDto dto = NoticeDto.builder()
               .gno(entity.getGno())
               .title(entity.getTitle())
               .content(entity.getContent())
               .writer(entity.getWriter())
               .regDate(entity.getRegTime())
               .modDate(entity.getUpdateTime())
               .build();
         return dto;
      }

   //.replyCount(replyCount.intValue())
   */
   
 //검색 처리
   /*
 	private BooleanBuilder getSearch(PageRequestDto requestDto) {
 		String type = requestDto.getType();
 		String keyword = requestDto.getKeyword();
 		
 		BooleanBuilder booleanBuilder = new BooleanBuilder();
 		qNotice qNotice = QNotice.notice;
 		
 		BooleanExpression expression = qNotice.gno.gt(0L); // gno > 0 
 		booleanBuilder.and(expression);
 		
 		//검색 조건이 없는 경우 null 처리
 		if(type == null || type.trim().length() == 0 ) {
 			return booleanBuilder;
 		}
 		
 		
 		//검색조건 작성
 		BooleanBuilder conditionBuilder = new BooleanBuilder();
 		if(type.contains("t")) {
 			conditionBuilder.or(qNotice.title.contains(keyword));
 		}
 		if(type.contains("c")) {
 			conditionBuilder.or(qNotice.content.contains(keyword));
 		}
 		if(type.contains("w")) {
 			conditionBuilder.or(qNotice.writer.contains(keyword));
 		}
 		//모든 조건 종합
 		booleanBuilder.and(conditionBuilder);
 		
 		return booleanBuilder;
 	}
 	*/
   
   
   
}