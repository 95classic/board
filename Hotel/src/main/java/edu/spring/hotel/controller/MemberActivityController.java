package edu.spring.hotel.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.MemberActivity;
import edu.spring.hotel.service.MemberActivityService;

@Controller
@RequestMapping(value="/member") 
public class MemberActivityController {
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberActivityController.class);
	
	@Autowired
	private MemberActivityService activityService;
	
	@GetMapping("/myActivity")
	public void myActivityGET(Model model, HttpSession session) {
		logger.info("myActivityGET() 호출");
		String memberId = (String) session.getAttribute("memberId");
		MemberActivity activity = activityService.read(memberId);
		model.addAttribute("activity", activity);
	} // end myActivityGET()
	
} // end MemberActivityController
