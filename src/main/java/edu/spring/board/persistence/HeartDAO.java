package edu.spring.board.persistence;

import edu.spring.board.domain.HeartVO;

public interface HeartDAO {
	
	int select(int boardId, String memberId); // 좋아요 여부 검색
	
	int insert(HeartVO vo); // 좋아요 등록
	
	int delete(int boardId, String memberId); // 좋아요 삭제
	
	int selectHeartCnt(String memberId); // 내가 좋아요 한 개수 검색

}
