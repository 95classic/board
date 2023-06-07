
package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ReplyVO;

//CRUD(Create, Read, Update, Delete)

public interface ReplyService {
	// 댓글 작성
	int create(ReplyVO vo);
	// 댓글 읽기
	List<ReplyVO> read(int boardId);
	// 댓글 수정
	int update(ReplyVO vo);
	// 댓글 삭제
	int delete(int replyId, int boardId) throws Exception;
}
