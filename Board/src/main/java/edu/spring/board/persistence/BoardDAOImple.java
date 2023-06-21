package edu.spring.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;

@Repository // @Componet
// - ���� ����(Persistence Layer)�� DB�� ���� ����� ���
// - Spring Component bean���� ��ΰ���
// - servlet-context.xml�� component-scan�� ����
// 	 ������ Component�� ã�ƿ� bean���� ���
// - <context:component-scan ../>
public class BoardDAOImple implements BoardDAO{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.board.BoardMapper";
	
	// MyBatis�� sqlSession�� ����ϱ� ����
	// ������ �����ӿ�ũ�� ������ bean�� ����(injection)����
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		logger.info("insert()ȣ��");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert

	@Override
	public List<BoardVO> selectAllDefault() {
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_default");
	} // end selectAllDefault

	@Override
	public List<BoardVO> selectAllReplyCnt() {
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all_reply_cnt");
	} // end selectAllReplyCnt

	@Override
	public BoardVO select(int boardId) {
		logger.info("select()ȣ�� : boardId = " + boardId );
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_id", boardId);
	} // end select_by_boardId

	@Override
	public int update(BoardVO vo) {
		logger.info("update()ȣ��");
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update

	@Override
	public int delete(int boardId) {
		logger.info("delete()ȣ�� : boardId = " + boardId);
		return sqlSession.delete(NAMESPACE + ".delete", boardId);
	} // end delete

	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword, int start, int end) {
		logger.info("selectByTitleOrContent()ȣ�� : keyword = " + keyword);
		PageCriteria criteria = new PageCriteria(start, end);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("start", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", args);
	} // end selectByTitleOrContent ���� �Ǵ� �������� �˻�

	@Override
	public List<BoardVO> selectByMemberId(String keyword, int start, int end) {
		logger.info("select()ȣ�� : keyword = " + keyword);
		PageCriteria criteria = new PageCriteria(start, end);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("strat", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_member_id", args);
	} // end selectMemberId �ۼ��ڷ� �˻� 

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		logger.info("select()ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	} // end selectPaging  ����¡ ó�� 

	@Override
	public int getTotalCounts() {
		logger.debug("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	} // end getTotalCounts �� �Խñ� ��


	@Override
	public int updateReplyCnt(int amount, int boardId) {
		logger.info("updateReplyCnt()ȣ�� : boardId = " + boardId);
		Map<String, Integer> args = new HashMap<>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		return sqlSession.update(NAMESPACE + ".update_reply_cnt", args);
	} // end updateReplyCnt �Խ��� ��� �� 


	@Override
	public int selectBoardCnt(String memberId) {
		logger.info("selectBoardCnt() ȣ�� : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_board_cnt", memberId);
	} // end selectBoardCnt �Խñ� ��ȸ

	@Override
	public int updateHeartCnt(int amount, int boardId) {
		logger.info("updateHeartCnt() ȣ�� : boardId = " + boardId);
		Map<String , Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		return sqlSession.update(NAMESPACE + ".update_heart_cnt",args);
	} // end updateHeaertCnt ���ƿ� �� ��ȸ 

	@Override
	public List<BoardVO> selectByHeart(String memberId) {
		logger.info("selectByHeart()ȣ�� : memberId =" + memberId);
		return sqlSession.selectList(NAMESPACE + ".select_by_heart", memberId);
	} // end selectByHeart ���ƿ� ��� 
}
