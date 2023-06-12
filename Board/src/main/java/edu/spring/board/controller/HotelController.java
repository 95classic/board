package edu.spring.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.board.service.HotelService;

@Controller 
@RequestMapping(value="/hotel") // url 
public class HotelController {
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private HotelService hotelService;
	
	@GetMapping
	public String hotelGET(Model model, Integer page, Integer numsPerPage, String sortBy, String keyword,
			RedirectAttributes reAttr) {
	return;	
	} // end hotelGET
	
	
	
} // end HotelController











