package edu.spring.board.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.board.domain.HeartVO;

@Repository
public class HeartDAOImple implements HeartDAO {
	private static Logger logger = 
			LoggerFactory.getLogger(HeartDAOImple.class);
	private static final String NAMESPACE = 
			"edu.spring.board.HeartMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int select(int boardId, String memberId) {
		logger.info("select() 호출");
		logger.info("boardId = " + boardId);
		logger.info("memberId = " + memberId);
		Map<String, Object> args = new HashMap<>();
		args.put("boardId", boardId);
		args.put("memberId", memberId);
		return sqlSession.selectOne(NAMESPACE + ".select", args);
	}

	@Override
	public int insert(HeartVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int delete(int boardId, String memberId) {
		logger.info("delete() 호출");
		logger.info("boardId = " + boardId);
		logger.info("memberId = " + memberId);
		Map<String, Object> args = new HashMap<>();
		args.put("boardId", boardId);
		args.put("memberId",memberId);
		return sqlSession.delete(NAMESPACE + ".delete",args);
	}

	
	@Override
	public int selectHeartCnt(String memberId) {
		logger.info("selectHeartCnt() 호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_heart_cnt", memberId);
	}


} // end HeartDAOImple