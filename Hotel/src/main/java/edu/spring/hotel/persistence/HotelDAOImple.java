package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class HotelDAOImple implements HotelDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(HotelDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.HotelMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public HotelVO select(int hotelId) {
		logger.info("select()호출 : hotelId = " + hotelId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_hotel_id", hotelId);
 	} // end select 상세 검색

	@Override
	public List<HotelVO> select(PageCriteria criteria) {
		logger.info("select()호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	} // select 호텔 페이징 처리 

	@Override
	public int getTotalCounts() {
		logger.info("getTotalcount()호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	} // getTotalCounts 전체 호텔 수 불러오기
	
	@Override
	public int updateReviewCntAndAvg(int amount, int hotelId) {
	    logger.info("updateReviewCntAndAvg() 호출");
	    logger.info("amount = " + amount);
	    logger.info("hotelId = " + hotelId);
	    Map<String, Object> args = new HashMap<>();
	    args.put("amount", amount);
	    args.put("hotelId", hotelId);
	    return sqlSession.update(NAMESPACE + ".update_review_cnt_and_hotel_review_star_avg", args);
	}

	@Override
	public List<HotelVO> selectAllByReviewDesc(PageCriteria criteria) {
		logger.info("selcet()호출");
		return sqlSession.selectList(NAMESPACE + ".select_all_review_desc", criteria);
	} // end selectAllByReviewDesc 리뷰 내림차순 전체검색

	@Override
	public List<HotelVO> selectAllByReviewAvgDesc(PageCriteria criteria) {
		logger.info("selectAllByReviewAvgDesc() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all_hotel_review_avg_desc", criteria);
	}

	@Override
	public List<HotelVO> selectAllByHotelNameAsc(PageCriteria criteria) {
		logger.info("selectAllByHotelNameDesc() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all_hotel_name_asc", criteria);
	}

	@Override
	public List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria) {
		logger.info("selectByHotelName() 호출 : keyword = " + keyword);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("start", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_hotel_name", args);
	}

	@Override
	public int updateHeartCnt(int amount, int hotelId) {
		logger.info("updateHeartCnt() 호출 ");
		Map<String, Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("hotelId", hotelId);
		
		return sqlSession.update(NAMESPACE + ".update_heart_cnt", args);
	}

	@Override
	public List<HotelVO> selectByHeart(String memberId) {
		logger.info("selectByHeart() 호출 : memberId = " + memberId);
		return sqlSession.selectList(NAMESPACE + ".select_by_heart", memberId);
	}


} // end HotelDAOImple
