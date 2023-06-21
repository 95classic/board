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
import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;

@Repository
public class HotelDAOImple implements HotelDAO{
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.board.HotelMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public HotelVO select(int hotelId) {
		logger.info("select() 호출 : hotelId = " + hotelId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_hotel_id",hotelId);
	} // end select 상세 검색

	@Override
	public List<HotelVO> selectAllByDefault(PageCriteria criteria) {
		logger.info("selectAllByDefault()호출");
		logger.info("strat = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_default", criteria);
	} // selectAllByDefault 전체 검색 기본

	@Override
	public List<HotelVO> selectAllByReviewDesc(PageCriteria criteria) {
		logger.info("selectAllByReviewDesc()호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_review_desc", criteria);
	} // end selectAllByReviewDesc 전체 검색 리뷰순

	@Override
	public List<HotelVO> selectAllByStarAvgDesc(PageCriteria criteria) {
		logger.info("selectAllByStarAvgDesc() 호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_star_avg_desc", criteria);
	} // end selectAllByStarAvgDesc 별점 평균 순서로 전체 검색

	@Override
	public List<HotelVO> selectAllByHotelNameDesc(PageCriteria criteria) {
		logger.info("selectAllByHotelNameDesc()호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_hotel_name_desc", criteria);
	} // end selectAllByHotelNameDesc 이름순 전체 검색 

	@Override
	public List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria) {
		logger.info("selectByHotelName() 호출 : keyword = " + keyword);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("start", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_hotel_name", args);
	} // selelctByHotelName 호텔 이름으로 검색

	@Override
	public int getTotalCount() {
		logger.info("getTotalCounts()호출");
		return sqlSession.selectOne(NAMESPACE + ".total_counnt");
	} // end getTotalCount 전체 호텔 수 불러오기 

	@Override
	public int updateReviewCntAndAvg(int amount, int hotelId) {
		logger.info("updateReviewCntAndAvg()호출");
		logger.info("amout = " + amount);
		logger.info("hotelId = " + hotelId);
		Map<String, Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("hotelId", hotelId);
		return sqlSession.update(NAMESPACE + ".update_review_cnt_and_hotel_review_star_avg", args);
	} // end udpateReviewCntAndAvg 리뷰 등록 삭제시 평균 별점과 리뷰 개수 수정 

	
	
	
	
	
}
