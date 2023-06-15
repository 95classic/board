package edu.spring.board.persistence;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;

public interface BoardDAO {
	int insert(BoardVO vo); // 등록
	List<BoardVO> selectAllDefault(); // 전체 출력 기본
	List<BoardVO> selectAllReplyCnt(); // 전체 검색 댓글순
	BoardVO select(int boardId); // 상세 출력
	int update(BoardVO vo); // 수정
	int delete(int boardId); //삭제
	List<BoardVO> selectByTitleOrContent(String keyword, int start, int end); // 제목이랑 내용으로 검색
	List<BoardVO> selectByMemberId(String keyword, int start, int end); // 작성자로 검색
	List<BoardVO> select(PageCriteria criteria); // 페이징 처리
	int getTotalCounts(); //  총 게시글 수
	int updateReplyCnt(int amount, int boardId); // 게시판 댓글 개수 업데이트
	int selectBoardCnt(String memberId); // 게시글 조회
	int updateHeartCnt(int amount, int boardId); // 하트 개수 수정
	List<BoardVO> selectByHeart(String memberId); // 사용자가 찜한 게시판 목록 전체검색
}
