package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.board.domain.ReplyVO;
import edu.spring.board.persistence.BoardDAO;
import edu.spring.board.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;

	@Autowired
	private BoardDAO boardDAO;
	
	// @Transactional
	// - 두 개의 데이터베이스 변경이 생길 때,
	// 위의 쿼리는 수행이 되었고, 아래 쿼리가 에러가 발생하면
	// 위의 쿼리는 rollback 되어야 한다.
	// 이런 기능을 제공해주는 Spring annotation
	// - root-context.xml에서 설정
	
	@Transactional(value="transactionManager")
	@Override
	public int create(ReplyVO vo) throws Exception {
		// 댓글(replyReply)의 데이터가 증가하면
		// 게시판(replyReply)의 댓글 개수(reply_cnt)가 변경되어야 함
		// replyReply 테이블에 insert를 수행하면
		// replyReply 테이블에 update를 수행한다.
		
		logger.info("create()호출 : vo = " + vo.toString());
		replyDAO.insert(vo);
		logger.info("댓글 입력 성공!");
		boardDAO.updateReplyCnt(1, vo.getBoardId());
		logger.info("게시글 수정 성공!");
		return 1;
	} // end create

	@Override
	public List<ReplyVO> read(int boardId) {
		logger.info("read()호출 : boardId = " + boardId);
		return replyDAO.select(boardId);
	} // end read

	@Override
	public int update(ReplyVO vo) {
		logger.info("댓글 update() 호출 : vo = " + vo.toString());
		return replyDAO.update(vo);
	} // end update

	@Transactional(value="transactionManager")
	@Override
	public int delete(int replyId, int boardId) throws Exception {
		logger.info("delete()호출 : replyId = " + replyId);
		replyDAO.delete(replyId);
		logger.info("댓글 삭제 성공!");
		boardDAO.updateReplyCnt(-1, boardId);
		return 1;
	} // end delete
	
	
	
} // end ReplyServiceImple
