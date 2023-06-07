package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.RoomVO;
import edu.spring.hotel.persistence.RoomDAO;

@Service
public class RoomServiceImple implements RoomService {
	private static final Logger logger = 
			LoggerFactory.getLogger(RoomServiceImple.class);
	
	@Autowired
	private RoomDAO dao;
	
	
	@Override
	public List<RoomVO> read(int hotelId) {
		logger.info("read() 호출 : hotelId = " + hotelId);
		return dao.selectByHotelId(hotelId);
	}

	@Override
	public RoomVO selectRead(int roomId) {
		logger.info("selectRead() 호출 : roomId = " + roomId);
		return dao.select(roomId);
	}

}
