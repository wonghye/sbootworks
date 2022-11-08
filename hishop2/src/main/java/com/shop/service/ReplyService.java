package com.shop.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.shop.dto.ReplyDto;
import com.shop.dto.ReplyResponseDto;
import com.shop.dto.ReplyRequestDto;
import com.shop.entity.Member;
import com.shop.entity.Notice;
import com.shop.entity.Reply;
import com.shop.repository.MemberRepository;
import com.shop.repository.NoticeRepository;
import com.shop.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyService {
	
	private final ReplyRepository replyRepo;
	private final MemberRepository memberRepo;
	private final NoticeRepository noticeRepo;
	
	
	//댓글 등록
	@Transactional
	public Long replySave(String name, Long gno, ReplyRequestDto dto) {
		Member member = memberRepo.findByName(name);
		Notice notice = noticeRepo.findById(gno)
				.orElseThrow(() -> 
				new IllegalAccessError("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + gno));
		
		dto.setMember(member);
		dto.setNotice(notice);
		
		Reply replyList = dto.toEntity();
		replyRepo.save(replyList);
		
		return dto.getRno();
		
	}
	
	/*
	Long register(ReplyDto replyDTO);  //댓글 등록
	
	List<ReplyDto> getList(Long bno);  //특정 게시글의 댓글 목록
	
	void modify(ReplyDto replyDto);  //댓글 수정
	
	void remove(Long rno); //댓글 삭제
	
	//ReplyDto를 Reply 객체로 변환 Board 객체의 처리가 수반됨
	default Reply dtoToEntity(ReplyDto replyDto) {
		
		Notice notice = Notice.builder().gno(replyDto.getGno()).build();
		
		Reply reply = Reply.builder()
				.rno(replyDto.getRno())
				.text(replyDto.getText())
				.replyer(replyDto.getReplyer())
				.notice(notice)
				.build();
		
		return reply;		
	}
	
	//Reply 객체를 ReplyDto로 변환
	default ReplyDto entityToDto(Reply reply) {
		
		ReplyDto dto = ReplyDto.builder()
				.rno(reply.getRno())
				.text(reply.getText())
				.replyer(reply.getReplyer())
				.regDate(reply.getRegTime())
				.modDate(reply.getUpdateTime())
				.build();
		return dto;
	}
	*/
}









