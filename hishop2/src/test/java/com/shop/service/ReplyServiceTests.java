package com.shop.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.dto.ReplyDto;


@SpringBootTest
public class ReplyServiceTests {
	
	@Autowired
	ReplyService service;
	
	@Test
	public void testGetList() {
		Long gno = 1L;
		
		List<ReplyDto> replyDtoList = service.getList(gno);
		
		replyDtoList.forEach(replyDto -> System.out.println(replyDto));
	}
}
