package edu.spring.hotel;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.domain.ReplyVO;
import edu.spring.hotel.persistence.HeartDAO;
import edu.spring.hotel.persistence.ReplyDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class HeartDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(HeartDAOTest.class);
	
	@Autowired
	private HeartDAO dao;
	
	@Test
	public void tesHeartDAO() {
//		testInsert();
		testSelect();
//		testUpdate();
//		testDelete();
	} // end testReplyDAO()

	private void testSelect() {
		logger.info("testSelect() 호출");
		int list = dao.select(12, "1");
		logger.info("list : " + list);
	}

	private void testInsert() {
		HeartVO vo = new HeartVO(0, 13, "test");
		int result = dao.insert(vo);
		logger.info(result + "행 삽입");
	}

	

	
	private void testDelete() {
		int result = dao.delete(5, null);
		logger.info(result + "행 삭제");
	}
	
}
