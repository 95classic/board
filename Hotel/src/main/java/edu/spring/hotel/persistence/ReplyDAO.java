package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReplyVO;

public interface ReplyDAO {
	// 댓글 등록
	int insert(ReplyVO vo);
	// 댓글 전체검색
	List<ReplyVO> selectAll(int boardId);
	// 댓글 수정
	int update(ReplyVO vo);
	// 댓글 삭제
	int delete(int replyId);
	// 내가 작성한 댓글 수 검색
	int selectReplyCnt(String memberId);

} // end ReplyDAO
