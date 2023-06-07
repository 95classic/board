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

import edu.spring.hotel.domain.ReplyVO;
import edu.spring.hotel.persistence.ReplyDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void testReplyDAO() {
		testInsert();
//		testSelectAll();
//		testUpdate();
//		testDelete();
	} // end testReplyDAO()

	private void testInsert() {
		ReplyVO vo = new ReplyVO(0, "test", 12, "테스트입니다.", null);
		int result = dao.insert(vo);
		logger.info(result + "행 삽입");
	}

	private void testSelectAll() {
		List<ReplyVO> list = dao.selectAll(4);
		for (ReplyVO vo : list) {
			logger.info(vo.toString());
		}
	}

	private void testUpdate() {
		ReplyVO vo = new ReplyVO(6, "test", 3, "뭐냐", null);
		int result = dao.update(vo);
		logger.info(result + "행 수정");
	}

	private void testDelete() {
		int result = dao.delete(5);
		logger.info(result + "행 삭제");
	}
	
}
