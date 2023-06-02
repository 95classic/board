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
// - 영송 계층(Persistence Layer)의 DB와 관련 기능을 담당
// - Spring Component bean으로 등로갛ㅁ
// - servlet-context.xml의 component-scan을 통해
// 	 설정된 Component를 찾아와 bean으로 등록
// - <context:component-scan ../>
public class BoardDAOImple implements BoardDAO{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.board.BoardMapper";
	
	// MyBatis의 sqlSession을 사용하기 위해
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		logger.info("insert()호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert

	@Override
	public List<BoardVO> selectAllDefault() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all_default");
	} // end selectAllDefault

	@Override
	public List<BoardVO> selectAllReplyCnt() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all_reply_cnt");
	} // end selectAllReplyCnt

	@Override
	public BoardVO select(int boardId) {
		logger.info("select()호출 : boardId = " + boardId );
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_id", boardId);
	} // end select_by_boardId

	@Override
	public int update(BoardVO vo) {
		logger.info("update()호출");
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update

	@Override
	public int delete(int boardId) {
		logger.info("delete()호출 : boardId = " + boardId);
		return sqlSession.delete(NAMESPACE + ".delete", boardId);
	} // end delete

	@Override
	public List<BoardVO> selectByTitleOrContent(String keyword, int start, int end) {
		logger.info("selectByTitleOrContent()호출 : keyword = " + keyword);
		PageCriteria criteria = new PageCriteria(start, end);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("start", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_title_content", args);
	} // end selectByTitleOrContent 제목 또는 내용으로 검색

	@Override
	public List<BoardVO> selectByMemberId(String keyword, int start, int end) {
		logger.info("select()호출 : keyword = " + keyword);
		PageCriteria criteria = new PageCriteria(start, end);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("strat", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_member_id", args);
	} // end selectMemberId 작성자로 검색 

	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		logger.info("select()호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	} // end selectPaging  페이징 처리 

	@Override
	public int getTotalCounts() {
		logger.debug("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	} // end getTotalCounts 총 게시글 수


	@Override
	public int updateReplyCnt(int amount, int boardId) {
		logger.info("updateReplyCnt()호출 : boardId = " + boardId);
		Map<String, Integer> args = new HashMap<>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		return sqlSession.update(NAMESPACE + ".update_reply_cnt", args);
	} // end updateReplyCnt 게시판 댓글 수 


	@Override
	public int selectBoardCnt(String memberId) {
		logger.info("selectBoardCnt() 호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_board_cnt", memberId);
	} // end selectBoardCnt 게시글 조회

	@Override
	public int updateHeartCnt(int amount, int boardId) {
		logger.info("updateHeartCnt() 호출 : boardId = " + boardId);
		Map<String , Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("boardId", boardId);
		return sqlSession.update(NAMESPACE + ".update_heart_cnt",args);
	} // end updateHeaertCnt 좋아요 수 조회 
	
}
