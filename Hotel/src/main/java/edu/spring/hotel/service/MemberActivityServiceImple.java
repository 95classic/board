package edu.spring.hotel.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.MemberActivity;
import edu.spring.hotel.persistence.BoardDAO;
import edu.spring.hotel.persistence.HeartDAO;
import edu.spring.hotel.persistence.MemberDAO;
import edu.spring.hotel.persistence.ReplyDAO;
import edu.spring.hotel.persistence.ReviewDAO;

@Service
public class MemberActivityServiceImple implements MemberActivityService {
	private static final Logger logger =
			LoggerFactory.getLogger(MemberActivityServiceImple.class);
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	@Autowired
	private HeartDAO heartDAO;

	@Override
	public MemberActivity read(String memberId) {
		logger.info("read() 호출 : memberId = " + memberId);
		Date memberDateCreated = memberDAO.selectMemberDateCreated(memberId);
		int boardCnt = boardDAO.selectBoardCnt(memberId);
		int replyCnt = replyDAO.selectReplyCnt(memberId);
		int reviewCnt = reviewDAO.selectReviewCnt(memberId);
		int heartCnt = heartDAO.selectHeartCnt(memberId);
		MemberActivity activity = 
				new MemberActivity(memberDateCreated, boardCnt, replyCnt, reviewCnt, heartCnt);
		return activity;
	}

} // end MemberActivityServiceImple()
