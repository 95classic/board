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


public class HotelDAOImple implements HotelDAO{
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.board.HotelMapper";

	@Override
	public HotelVO select(int hoteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> selectAllByDefault(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> selectAllByReviewDesc(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> selectAllByStarAvgDesc(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> selectAllByHotelNameDesc(PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReviewCntAndAvg(int amount, int hoteId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHeartCnt(int amount, int hotelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HotelVO> selectByHeart(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}
			
	
	
	
	
	
}
