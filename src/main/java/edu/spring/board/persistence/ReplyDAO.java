package edu.spring.board.persistence;

import java.util.List;

import edu.spring.board.domain.ReplyVO;

public interface ReplyDAO {
	int insert(ReplyVO vo);
	List<ReplyVO> select(int boardId);
	int update(ReplyVO vo);
	int delete(int replyId);
}
