package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.domain.Board;
import com.boot.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

   @Autowired
   private BoardRepository boardRepo;
   
   @Override
   public List<Board> getBoardList() {
      //findAll() 사용
      return boardRepo.findAll();
   }

}