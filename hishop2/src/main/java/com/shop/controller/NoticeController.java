package com.shop.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shop.dto.NoticeDto;
import com.shop.dto.NoticeResponseDto;
import com.shop.dto.PageRequestDto;
import com.shop.dto.ReplyRequestDto;
import com.shop.dto.ReplyResponseDto;
import com.shop.entity.Member;
import com.shop.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/notice")
@Controller
public class NoticeController {

   private final NoticeService service;
   
   @GetMapping("/list")
   public String list(PageRequestDto pageRequestDto, Model model) {
      model.addAttribute("result", service.getList(pageRequestDto));
      return "/notice/list";
   }
   
   //글쓰기 폼 요청
   @GetMapping("/register")
   public void register() {}
   
   //글쓰기 처리
   @PostMapping("/register")
   public String register(NoticeDto dto, Model model, RedirectAttributes redirectAttributes,@AuthenticationPrincipal NoticeDto noticeDto) {
      Long gno = service.register(dto);
      redirectAttributes.addFlashAttribute("msg", gno);
      model.addAttribute("notice", noticeDto);
      return "redirect:list";
   }
   
   //상세보기
   @GetMapping("/read/{gno}")
   public String read(@PathVariable Long gno, Model model, Member member,
		   @ModelAttribute("requestDto") PageRequestDto requestDto ) {
	   
	   NoticeResponseDto dto = service.read(gno);
	   List<ReplyResponseDto> replyList = dto.getReplyList();
	   
	   //댓글 관련
	   if( replyList != null && !replyList.isEmpty()) {
		   model.addAttribute("replyList" ,replyList);
	   }
	   
	   //멤버 관련
	   if(member != null) {
		   model.addAttribute("member", member.getName());
		   
		   //게시글 작성자 본인인지 확인
		   if(dto.getMemberId().equals(member.getId())) {
			   model.addAttribute("writer", true);
		   }
	   }
	   service.update(gno);
	   model.addAttribute("notice", dto);
	   return "notice/read";
	   
   }
   
   /*
   @GetMapping("/read")
   public void read(Long gno, Model model , 
         @ModelAttribute("requestDto") PageRequestDto requestDto) {
      NoticeDto dto = service.read(gno);   //게시글 1개
      model.addAttribute("dto", dto);
   }*/
   
   
   
}