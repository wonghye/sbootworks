package com.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.shop.dto.NoticeDto;
import com.shop.dto.NoticeResponseDto;
import com.shop.dto.PageRequestDto;
import com.shop.dto.PageResultDto;
import com.shop.entity.Notice;

public interface NoticeRepository  extends JpaRepository<Notice, Long>,
	QuerydslPredicateExecutor<Notice>{
	
	
	
	//댓글(댓글수)
	/*
	@Query(value = "SELECT n, w, count(r) "
			+ "FROM Notice n "
			+ "LEFT JOIN n.writer w "
			+ "LEFT JOIN Reply r ON r.notice = n "
			+ "GROUP BY n",
			countQuery = "SELECT count(n) FROM Notice n")
	Page<Object[]> getNoticeWithReplycount(Pageable pageable);
	*/

}
