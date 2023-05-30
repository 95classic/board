package edu.spring.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.board.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.board.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert

	@Override
	public List<ReplyVO> select(int boardId) {
		logger.info("select()호출 : boardId = " + boardId);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_board_id", boardId);
	} // end selectall

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update

	@Override
	public int delete(int replyId) {
		logger.info("delete() 호출 : replyId "  + replyId);
		return sqlSession.delete(NAMESPACE + ".delete", replyId);
	}// end delete

}
