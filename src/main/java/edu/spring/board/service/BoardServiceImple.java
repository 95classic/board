package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.persistence.BoardDAO;

@Service // @Component
// * 서비스 계층(Service/Business Laye)
// - 표현 계층(presentation Layer)과 영속 계층(persistence Layer)사이를
//   연결하여 두 계층이 직접적으로 통신하지 않도록 하는 역할
// - 트랜잭션(tranaction)관리
// - DB와 상관없이 데이터를 처리 가능

public class BoardServiceImple implements BoardService{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardServiceImple.class);

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		logger.info("create()호출 : vo = " + vo.toString());
		return dao.insert(vo);
	} // end create

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("read() 호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria);
	} // end readPaging 페이징처리

	@Override
	public BoardVO read(int boardId) {
		logger.info("read() 호출 : boardId = " + boardId);
		return dao.select(boardId);
	} // end read 상세 검색

	@Override
	public int update(BoardVO vo) {
		logger.info("update()호출 : vo = " + vo.toString());
		return dao.update(vo);
	} // end update 수정

	@Override
	public int delete(int boardId) {
		logger.info("delete()호출 : boardId = " + boardId);
		return dao.delete(boardId);
	} // end delete 삭제

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	} // end getTotalCounts 총 게시굴 수

	@Override
	public List<BoardVO> readByTitleOrContent(String keyword, int start, int end) {
		logger.info("readByTitleOrContent");
		PageCriteria criteria = new PageCriteria(start, end);
		return dao.selectByTitleOrContent(keyword, criteria.getStart(), criteria.getEnd());
	} // end readByTitleOrContent 제목 내용으로 검색

	@Override
	public List<BoardVO> readByMemberId(String keyword, int start, int end) {
		logger.info("readByMemberId");
		PageCriteria criteria = new PageCriteria(start, end);
		return dao.selectByMemberId(keyword, criteria.getStart(), criteria.getEnd());
	} // end readByMemberId 작성자로 검색

}
