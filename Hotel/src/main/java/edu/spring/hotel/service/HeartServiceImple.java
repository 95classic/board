package edu.spring.hotel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.persistence.HeartDAO;
import edu.spring.hotel.persistence.HotelDAO;

@Service
public class HeartServiceImple implements HeartService {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartServiceImple.class);
	
	@Autowired
	private HeartDAO heartDAO;
	
	@Autowired
	private HotelDAO hotelDAO;

	
	@Override
	public int read(int hotelId, String memberId) {
		logger.info("read() 호출");
		logger.info("hotelId = " + hotelId);
		logger.info("memberId = " + memberId);
		return heartDAO.select(hotelId, memberId);
	} // end read()

	@Transactional(value="transactionManager")
	@Override
	public int create(HeartVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		heartDAO.insert(vo);
		logger.info("하트개수 1개 증가");
		hotelDAO.updateHeartCnt(1, vo.getHotelId());
		return 1;
	} // end create()

	@Transactional(value="transactionManager")
	@Override
	public int delete(int hotelId, String memberId) {
		logger.info("delete() 호출");
		logger.info("hotelId = " + hotelId);
		logger.info("memberId = " + memberId);
		heartDAO.delete(hotelId, memberId);
		logger.info("하트개수 1개 감소");
		hotelDAO.updateHeartCnt(-1, hotelId);
		return 1;
	} // end delete()

}
