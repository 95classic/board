package edu.spring.board.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.board.domain.HeartVO;
import edu.spring.board.persistence.BoardDAO;
import edu.spring.board.persistence.HeartDAO;

@Service
public class HeartServiceImple implements HeartService {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartServiceImple.class);
	
	@Autowired
	private HeartDAO heartDAO;
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public int read(int boardId, String memberId) {
		logger.info("read() 호출");
		logger.info("boardId = " + boardId);
		logger.info("memberId = " + memberId);
		return heartDAO.select(boardId, memberId);
	} // end read

	@Transactional(value="transactionManager")
	@Override
	public int create(HeartVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		heartDAO.insert(vo);
		logger.info("하트 개수 1개 증가");
		boardDAO.updateHeartCnt(1, vo.getBoardId());
		return 1;
	} // end create

	@Transactional(value="transactionManager")
	@Override
	public int delete(int boardId, String memberId) {
		logger.info("delete() 호출");
		logger.info("boardId = " + boardId);
		logger.info("memberId = " + memberId);
		heartDAO.delete(boardId, memberId);
		logger.info("하트 개수 1개 감소");
		boardDAO.updateHeartCnt(-1, boardId);
		return 1;
	} // end delete

	
	
}
