package edu.spring.board.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.service.HotelService;

@Controller 
@RequestMapping(value="/hotel") // url 
public class HotelController {
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelController.class);
	

	
//	@GetMapping
//	public String hotelGET(Model model, Integer page, Integer numsPerPage, String sortBy, String keyword,
//			RedirectAttributes reAttr) {
//		logger.info("hotelGET() ȣ��");
//		logger.info("page = " + page + ", umsePerPage = " + numsPerPage);
//		logger.info("���� ��� : " + sortBy);
//		logger.info(keyword);
//		
//		// ����¡ ó�� 
//		PageCriteria criteria = new PageCriteria();
//		if(page != null) {
//			criteria.setPage(page);
//		}
//		if(numsPerPage != null) {
//			criteria.setNumsPerPage(numsPerPage);
//		}
//		// ������ ������ �⺻ ��ü�˻�
//		if (sortBy == null || sortBy.equals("")) {
//			List<HotelVO> list = hotelService.read(criteria);
//			model.addAttribute("list", list);
//		} else if(sortBy.equals("hotelName")) { // ȣ�� �̸��� ����
//			List<HotelVO> list = hotelService.readOrderByHotelNameDesc(criteria);
//			model.addAttribute("list", list);
//		} else if(sortBy.equals("hoteReviewCnt")) { // ȣ�� ����� ����
//			List<HotelVO> list = hotelService.readOrderByReviewDesc(criteria);
//			model.addAttribute("list", list);
//		} else if(sortBy.equals("hotelStarAvg")) { // ȣ�� ������ ����
//			List<HotelVO> list = hotelService.readOrderByStarAvgDesc(criteria);
//			model.addAttribute("lsit", list);
//		}
//		
//		// keyword �˻� Ű���尡 ������
//		if(keyword != null) {
//			List<HotelVO> list = hotelService.readByHotelName(keyword, criteria);
//			model.addAttribute("list", list);
//			
//			// keyword ���� ������(�˻� ����� ������)
//			if(list.isEmpty()) {
//				reAttr.addFlashAttribute("result", "searchFail");
//				return "redirect:/";
//			}
//		}
//		
//	return;	
//	} // end hotelGET
	
	
	
} // end HotelController











