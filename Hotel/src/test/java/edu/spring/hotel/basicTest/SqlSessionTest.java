package edu.spring.hotel.basicTest;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.hotel.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class SqlSessionTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(SqlSessionTest.class);
	
	private static final String NAMESPACE = 
			"edu.spring.hotel.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO("test", "1234", "둘리", "010-1234-1234", "test@test.com", null);
		int result =sqlSession.insert(NAMESPACE + ".insert", vo);
	
		logger.info(result + "행 삽입");
	} // end testInsert()
	

} // end SqlSessionTest
