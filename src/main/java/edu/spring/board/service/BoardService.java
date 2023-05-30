package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface BoardService {
	int create(BoardVO vo); //  등록
	List<BoardVO> read(PageCriteria criteria); // 전체검색
	List<BoardVO> readByTitleOrContent(String keyword, int start, int end);// 제목,내용 검색
	List<BoardVO> readByMemberId(String keyword, int start, int end); // 작성자 검색
	BoardVO read(int boardId);// 상세검색
	int update(BoardVO vo); // 수정
	int delete(int boardId); // 삭제
	int getTotalCounts(); // 총 게시글 수 

} // end BoardService
