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
import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.BoardDAO;
import edu.spring.hotel.persistence.HotelDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class HotelDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(HotelDAOTest.class);
	
	@Autowired
	private HotelDAO dao;
	
	@Test
	public void testBoardDAO() {
//		testInsert();
//		testSelectAllDefault();
//		testSelectAllReplyCnt();
//		testSelect();
//		testUpdate();
//		testDelete();
//		testSelectByTitleOrContent();
//		testSelectByMemberId();
//		testGetTotalCounts();
		testSelectPaging();
	} // end testBoardDAO()

	private void testSelectPaging() {
		PageCriteria criteria = new PageCriteria(1, 3);
		List<HotelVO> list = dao.select(criteria);
		for (HotelVO vo : list) {
			logger.info(vo.toString());
		}
	}


	
} // BoardDAOTest
