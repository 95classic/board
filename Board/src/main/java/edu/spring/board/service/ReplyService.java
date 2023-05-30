package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.ReplyVO;

public interface ReplyService {
	int create(ReplyVO vo) throws Exception;
	List<ReplyVO> read(int boardId);
	int update(ReplyVO vo);
	int delete(int replyId, int boardId) throws Exception;
} // end ReplyService()
