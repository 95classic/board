package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ReservationVO;

@Repository
public class ReservationDAOImple implements ReservationDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(ReservationDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.ReservationMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReservationVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ReservationVO> select(String memberId) {
		logger.info("select() 호출 : memberId = " + memberId);
		return sqlSession.selectList(NAMESPACE + ".select_by_memberId", memberId);
	}

	@Override
	public int delete(int reservationId, int roomId) {
		logger.info("delete() 호출 : reservationId = " + reservationId);
		Map<String, Object> args = new HashMap<>();
		args.put("reservationId", reservationId);
		args.put("roomId", roomId);
		return sqlSession.delete(NAMESPACE + ".delete", args);
	}

} // end ReservationDAOImple
