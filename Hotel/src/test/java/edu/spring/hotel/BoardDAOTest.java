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

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class BoardDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void testBoardDAO() {
		testInsert();
//		testSelectAllDefault();
//		testSelectAllReplyCnt();
//		testSelect();
//		testUpdate();
//		testDelete();
//		testSelectByTitleOrContent();
//		testSelectByMemberId();
//		testGetTotalCounts();
//		testSelectPaging();
	} // end testBoardDAO()

	private void testSelectPaging() {
		PageCriteria criteria = new PageCriteria(1, 3);
		List<BoardVO> list = dao.select(criteria);
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
	}

	private void testGetTotalCounts() {
		int totalCounts = dao.getTotalCounts();
		
		logger.info("총 게시글 수 : " + totalCounts);
	}




	private void testInsert() {
		BoardVO vo = new BoardVO(0, "test", "test", "test", null, 0);
		int result = dao.insert(vo);
		logger.info(result + "행 삽입");
	}

	private void testSelectAllDefault() {
		List<BoardVO> list = dao.selectAllDefault();
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testSelectAllReplyCnt() {
		List<BoardVO> list = dao.selectAllReplyCnt();
		for (BoardVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testSelect() {
		BoardVO vo = dao.select(2);
		logger.info(vo.toString());
		
	}

	private void testUpdate() {
		BoardVO vo = new BoardVO(2, "test", "ㅎㅇㅎㅇ", "ㅎㅇㅎㅇ", null, 0);
		int result = dao.update(vo);
		logger.info(result + "행 수정");
	}

	private void testDelete() {
		int result = dao.delete(2);
		logger.info(result + "행 삭제");
	}
	
} // BoardDAOTest
