package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.shop.entity.Notice;
import com.shop.entity.Reply;


public interface ReplyRepository extends JpaRepository<Reply, Long>{
	
	//notice 삭제시에 댓글들 삭제
	//@Modifying
	//@Query("DELETE FROM Reply r WHERE r.notice.gno = :gno")
	//void deleteByGno(Long gno);
	
	//게시물로 댓글 목록 보기
	//List<Reply> getRepliesByNoticeOrderByRno(Notice notice);
}
