package edu.spring.hotel.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.ReservationVO;
import edu.spring.hotel.service.ReservationService;

@Controller
@RequestMapping(value="/member") 
public class ReservationController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/myReservation")
	public void myReservationGET(Model model, HttpSession session) {
		logger.info("myReservationGET() 호출");
		String memberId = (String) session.getAttribute("memberId");
		List<ReservationVO> list = reservationService.read(memberId);
		model.addAttribute("list", list);
	} // end myReservation()
	
	@PostMapping("/createReservation")
	public String createReservationPOST(ReservationVO vo, RedirectAttributes reAttr) {
		logger.info("createReservationPOST() 호출");
		int result = reservationService.create(vo);
		
		if (result == 1) {
			reAttr.addFlashAttribute("result", "createSuccess");
			return "redirect:/member/myReservation";
		} else { 
			return "redirect:/";
		}
	} /// end createReservation()
	
	@PostMapping("/cancleReservation")
	public String cancleReservationPOST(Integer reservationId, Integer roomId, RedirectAttributes reAttr) {
		logger.info("cancleReservationPOST() 호출 : reservationId = " + reservationId);
		
		int result = reservationService.delete(reservationId, roomId);
		
		if (result == 1) {
			logger.info("예약취소 성공");
			reAttr.addFlashAttribute("result", "deleteSuccess");
			return "redirect:/member/myReservation";
		} else {
			logger.info("예약취소 실패");
			return "redirect:/member/myReservation";
		}
		
	} // end cancleReservationPOST()
	
	
} // end ReservationController
