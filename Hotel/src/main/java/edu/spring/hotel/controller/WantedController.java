package edu.spring.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.service.HotelService;

@Controller
@RequestMapping("/member")
public class WantedController {
	private static final Logger logger =
			LoggerFactory.getLogger(WantedController.class);
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/myWanted")
	public void myWantedGET(Model model, HttpSession session) {
		logger.info("myWantedGET() »£√‚");
		String memberId = (String) session.getAttribute("memberId");
		List<HotelVO> list = hotelService.readByHeart(memberId);
		model.addAttribute("list", list);	
	} // end myWantedGET()
	
} // end WantedController
