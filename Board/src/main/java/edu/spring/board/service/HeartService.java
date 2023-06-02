package edu.spring.board.service;

import edu.spring.board.domain.HeartVO;

public interface HeartService {
	
	int read(int boardId, String memberId);
	
	int create(HeartVO vo);
	
	int delete(int boardId, String memberId);
	

	
	
} // end HeartService
