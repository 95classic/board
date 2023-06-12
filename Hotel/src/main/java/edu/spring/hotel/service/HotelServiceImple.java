package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.HotelDAO;

@Service 
public class HotelServiceImple implements HotelService {
	private static final Logger logger =
			LoggerFactory.getLogger(HotelServiceImple.class);
	
	@Autowired
	private HotelDAO dao;

	@Override
	public HotelVO read(int hotelId) {
		logger.info("read()호출 : hotelId = " + hotelId);
		return dao.select(hotelId);
	} // end read 상세검색

	@Override
	public List<HotelVO> read(PageCriteria criteria) {
		logger.info("read()호출");
		return dao.select(criteria);
	} // end readAll 전체 검색(페이징 처리)

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()호출");
		return dao.getTotalCounts();
	} // end getTotalCounts 전체 호텔 수 불러오기 
	
	@Override
	public List<HotelVO> readOrderByReviewDesc(PageCriteria criteria) {
		logger.info("readOrderByReviewDesc() 호출");
		return dao.selectAllByReviewDesc(criteria);
	} // end readOrderByReviewDesc 리뷰 내림차순 전체 검색

	@Override
	public List<HotelVO> readOrderByReviewAvgDesc(PageCriteria criteria) {
		logger.info("readOrderByReviewAvgDesc() 호출");
		return dao.selectAllByReviewAvgDesc(criteria);
	}

	@Override
	public List<HotelVO> readOrderByHotelNameAsc(PageCriteria criteria) {
		logger.info("readOrderByHotelNameDesc() 호출");
		return dao.selectAllByHotelNameAsc(criteria);
	}

	@Override
	public List<HotelVO> readByHotelName(String keyword, PageCriteria criteria) {
		logger.info("readByHotelName() 호출 : keyword = " + keyword);
		return dao.selectByHotelName(keyword, criteria);
	}

	@Override
	public List<HotelVO> readByHeart(String memberId) {
		logger.info("readByHeart() 호출 : memberId = " + memberId);
		return dao.selectByHeart(memberId);
	}

}
