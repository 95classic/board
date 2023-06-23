package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.RoomVO;

@Repository
public class RoomDAOImple implements RoomDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(RoomDAOImple.class);
	
	private static final String NAMESPACE =
			"edu.spring.hotel.RoomMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<RoomVO> selectByHotelId(int hotelId) {
		logger.info("selectByHotelId() 호출 : hotelId = " + hotelId);
		return sqlSession.selectList(NAMESPACE + ".select_by_hotel_id", hotelId);
	}

	@Override
	public RoomVO select(int roomId) {
		logger.info("select() 호출 : roomId = " + roomId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_room_id", roomId);
	}

	@Override
	public int updateRoomCnt(int amount, int roomId) {
		logger.info("updateRoomCnt() 호출");
		logger.info("amount = " + amount + ",  roomId = " + roomId);
		Map<String, Object> args = new HashMap<>();
		args.put("amount", amount);
		args.put("roomId", roomId);
		return sqlSession.update(NAMESPACE + ".update", args);
	}
	
} // end RoomDAOImple
