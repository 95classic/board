package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.service.MemberService;

@RestController
@RequestMapping(value="/member")
public class FindRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(FindRESTController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/find-memberId", method = RequestMethod.POST)
	public String findMemberId(@RequestParam("memberName") String memberName, 
	                           @RequestParam("memberPhone") String memberPhone, 
	                           @RequestParam("memberEmail") String memberEmail) {
	    logger.info("findMemberId() 호출 vo = " + memberName + ", " + memberPhone + ", " + memberEmail);
	    MemberVO vo = new MemberVO(null, null, memberName, memberPhone, memberEmail, null);
	    String memberId = memberService.findMemberId(vo);
	    return memberId;
	}
	
	@RequestMapping(value = "/find-memberPw", method = RequestMethod.POST)
	public String findMemberPw(@RequestParam("memberId") String memberId,
							   @RequestParam("memberName") String memberName, 
							   @RequestParam("memberPhone") String memberPhone, 
							   @RequestParam("memberEmail") String memberEmail) {
		logger.info("findMemberPw() 호출");
		MemberVO vo = new MemberVO(memberId, null, memberName, memberPhone, memberEmail, null);
		String memberPw = memberService.findMemberPw(vo);	
		return memberPw;
	}
	
	
	
}
