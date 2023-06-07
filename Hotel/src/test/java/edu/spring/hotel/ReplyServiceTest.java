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
import edu.spring.hotel.service.ReplyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class ReplyServiceTest {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void test() throws Exception {
		testCreate();
//		testRead();
//		testUpdate();
//		testDelete();
	}

	private void testCreate() {
		logger.info("Create() 호출");
		ReplyVO vo = new ReplyVO(0, "test", 18, "테스트해보기", null);
		replyService.create(vo);
		
	} // end testCreate()

	private void testRead() {
		logger.info("Read() 호출");
		List<ReplyVO> list = replyService.read(29);
		for (ReplyVO vo : list) {
			logger.info(vo.toString());
		}
	} // end testRead()

	private void testUpdate() {
		logger.info("update() 호출");
		ReplyVO vo = new ReplyVO(7, "test", 29, "수정테스트", null);
		int result = replyService.update(vo);
		logger.info(result + "행 수정완료");
	}

	private void testDelete() throws Exception {
		logger.info("delete() 호출");
		int result = replyService.delete(6, 3);
		logger.info(result + "행 삭제완료");
		
	} // end testDelete()

} // end ReplyServiceTest
