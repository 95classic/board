package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.persistence.HotelDAO;

@Service 

public class HotelServiceImple implements HotelService{
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelServiceImple.class);
	
	@Autowired
	private HotelDAO dao;

	@Override
	public HotelVO read(int hotelId) {
		logger.info("read()ȣ�� hotelId = " + hotelId);
		return dao.select(hotelId);
	} // end read ȣ�� �� �˻� 

	@Override
	public List<HotelVO> read(PageCriteria criteria) {
		logger.info("read()ȣ��");
		return dao.selectAllByDefault(criteria);
	} // end read ��ü �˻� �⺻ 

	@Override
	public List<HotelVO> readOrderByReviewDesc(PageCriteria criteria) {
		logger.info("readOrederByReviewDesc()ȣ��");
		return dao.selectAllByReviewDesc(criteria);
	} // end readOrderByReviewDesc ����� ��ü �˻�

	@Override
	public List<HotelVO> readOrderByStarAvgDesc(PageCriteria criteria) {
		logger.info("readOrederByStarAvgDesc()ȣ��");
		return dao.selectAllByStarAvgDesc(criteria);
	} // end readOrederByStarAvgDesc ������ ��ü �˻�

	@Override
	public List<HotelVO> readOrderByHotelNameDesc(PageCriteria criteria) {
		logger.info("readOrederByHotelNameDesc()ȣ��");
		return dao.selectAllByHotelNameDesc(criteria);
	} // end readOrderByHotelNameDesc ȣ�� �̸��� ��ü �˻�

	@Override
	public List<HotelVO> readByHotelName(String keyword, PageCriteria criteria) {
		logger.info("readByHotelName()ȣ��");
		return dao.selectByHotelName(keyword, criteria);
	} // end readHotelName ȣ�� �̸����� �˻�

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()ȣ��");
		return dao.getTotalCount();
	} // end getTotalCounts ��ü ȣ�� �� �ҷ����� 

	


}
