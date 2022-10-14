package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.domain.Board;
import com.boot.service.BoardService;

@Controller
public class BoardController {
   
   @Autowired
   private BoardService service;
   
   @GetMapping("/hello")
   public void hello() {
      //return "hello";
   }
   
   @GetMapping("/getBoardList")
   public String getBoardList(Model model) {
      List<Board> boardList = service.getBoardList();
      model.addAttribute("boardList",boardList);
      
      return "getBoardList";
   }
   
   //새글 등록
   @GetMapping("/insertBoard")
   public String insertBoard() {
	   return "insertBoard";	//board/insertboard
   }
   
   //새글 등록 처리
   @PostMapping("/insertBoard")
   public String insertBoard(Board board) {
	   service.insertBoard(board);
	   return "redirect:getBoardList";
   }
   
   //글 상세 보기
   @GetMapping("/getBoard")
   public String getBoard(Long seq, Model model) {
	   service.updateCount(seq); //조회수 증가
	   Board board = service.getBoard(seq);	//상세처리
	   
	   model.addAttribute("board" , board);
	   return "getBoard";
   }
   
   //글 삭제
   @GetMapping("/deleteBoard")
   public String deleteBoard(Board board) {
	   //게시글 1개 객체 삭제 
	   service.deleteBoard(board);
	   return "redirect:getBoardList";
   }
   
   // 글 수정
   @PostMapping("/updateBoard")
   public String updateBoard(Board board) {
	   service.updateBoard(board);
	   return "redirect:getBoardList";
   }
   
   
   
   
   
   
   
   
   
}