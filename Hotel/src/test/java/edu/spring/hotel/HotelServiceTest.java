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

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.service.HotelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class HotelServiceTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelServiceTest.class);
	
	@Autowired
	private HotelService Service;
	
	@Test
	public void testService() {
//		testread();
//		testreadPaging();
//		testreadAllReviewDesc();
//		testGetTotalCounts();
	}

	private void testGetTotalCounts() {
		logger.info("count()호출");
		int totalCounts = Service.getTotalCounts();
		logger.info("전체 호텔 수 : " + totalCounts);
		
	}

	private void testreadPaging() {
		logger.info("read()호출");
		PageCriteria criteria = new PageCriteria(1, 3);
		List<HotelVO> list = Service.read(criteria);
		for(HotelVO vo : list) {
			logger.info(vo.toString());
		}
	} // end testreadPaging 전체 검색 페이징처리 


	private void testread() {
		HotelVO vo = Service.read(1);
		logger.info(vo.toString());
		
	} // end testread 상세 검색



	
	
} // end HotelServiceTest
