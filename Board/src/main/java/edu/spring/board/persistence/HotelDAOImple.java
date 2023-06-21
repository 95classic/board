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
		logger.info("select() ȣ�� : hotelId = " + hotelId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_hotel_id",hotelId);
	} // end select �� �˻�

	@Override
	public List<HotelVO> selectAllByDefault(PageCriteria criteria) {
		logger.info("selectAllByDefault()ȣ��");
		logger.info("strat = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_default", criteria);
	} // selectAllByDefault ��ü �˻� �⺻

	@Override
	public List<HotelVO> selectAllByReviewDesc(PageCriteria criteria) {
		logger.info("selectAllByReviewDesc()ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_review_desc", criteria);
	} // end selectAllByReviewDesc ��ü �˻� �����

	@Override
	public List<HotelVO> selectAllByStarAvgDesc(PageCriteria criteria) {
		logger.info("selectAllByStarAvgDesc() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_star_avg_desc", criteria);
	} // end selectAllByStarAvgDesc ���� ��� ������ ��ü �˻�

	@Override
	public List<HotelVO> selectAllByHotelNameDesc(PageCriteria criteria) {
		logger.info("selectAllByHotelNameDesc()ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_all_hotel_name_desc", criteria);
	} // end selectAllByHotelNameDesc �̸��� ��ü �˻� 

	@Override
	public List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria) {
		logger.info("selectByHotelName() ȣ�� : keyword = " + keyword);
		Map<String, Object> args = new HashMap<>();
		args.put("keyword", "%" + keyword + "%");
		args.put("start", criteria.getStart());
		args.put("end", criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".select_by_hotel_name", args);
	} // selelctByHotelName ȣ�� �̸����� �˻�

	@Override
	public int getTotalCount() {
		logger.info("getTotalCounts()ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_counnt");
	} // end getTotalCount ��ü ȣ�� �� �ҷ����� 

	@Override
	public int updateReviewCntAndAvg(int amount, int hotelId) {
		logger.info("updateReviewCntAndAvg()ȣ��");
		logger.info("amout = " + amount);
		logger.info("hotelId = " + hotelId);
		Map<String, Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("hotelId", hotelId);
		return sqlSession.update(NAMESPACE + ".update_review_cnt_and_hotel_review_star_avg", args);
	} // end udpateReviewCntAndAvg ���� ��� ������ ��� ������ ���� ���� ���� 

	
	
	
	
	
}
