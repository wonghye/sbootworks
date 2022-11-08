package com.shop.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.ReplyDto;
import com.shop.dto.ReplyRequestDto;
import com.shop.entity.Member;
import com.shop.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/replies/")
@RestController
public class ReplyController {
	
	private final ReplyService replyService;
	
	//댓글 쓰기
	@PostMapping("notice/{gno}/replyList")
	public ResponseEntity replySave(@PathVariable Long gno, @RequestBody ReplyRequestDto dto,
			Member member) {
		return ResponseEntity.ok(replyService.replySave(member.getName(), gno, dto));
	}
	

	/*
	//댓글 목록
	@GetMapping(value = "/notice/{gno}", produces = 
			MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyDto>> getListByNotice(@PathVariable("gno") Long gno){
		return new ResponseEntity<>(replyService.getList(gno), HttpStatus.OK);
	}
	
	//댓글 쓰기
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody ReplyDto replyDto){
		Long rno = replyService.register(replyDto);
		return new ResponseEntity<>(rno, HttpStatus.OK);
	}
	
	//댓글 삭제
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		replyService.remove(rno);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	//댓글 수정
	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyDto replyDto){
		replyService.modify(replyDto);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	*/
	
}






