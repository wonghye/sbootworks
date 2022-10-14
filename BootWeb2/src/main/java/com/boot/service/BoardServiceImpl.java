package com.boot.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

   @Autowired
   private BoardRepository boardRepo;
   
   //목록보기
   @Override
   public List<Board> getBoardList() {
      //findAll() - select * from board 가 내장됨
     // return boardRepo.findAll(); // 오름차순
	   return boardRepo.findAll(Sort.by(Sort.Direction.DESC, "seq"));  //내림차순
   }
   
   //새글 등록
	@Override
	public void insertBoard(Board board) {
		boardRepo.save(board);
	}

	//게시글 상세 보기 
	@Override
	public Board getBoard(Long seq) {
		//find by id . get - select * from ~ where
		return boardRepo.findById(seq).get();
	}

	//글 삭제
	@Override
	public void deleteBoard(Board board) {
		boardRepo.delete(board);
	}
	
	//글 수정
	@Override
	public void updateBoard(Board board) {		//파라미터에서 커맨드 객체(get/set 작동)
		/*
		Board findBoard = boardRepo.findById(board.getSeq()).get();
		findBoard.setTitle(board.getTitle());  		//입력 폼의 제목 셋팅
		findBoard.setContent(board.getContent());  //입력 폼의 내용 셋팅
		*/
		boardRepo.save(board);  // 다시 저장 (수정)
	}

	//조회수 증가 
	@Transactional	//트렌잭션 처리 
	@Override
	public void updateCount(Long seq) {
		boardRepo.updateCount(seq);
	}
	
	
	
	

}