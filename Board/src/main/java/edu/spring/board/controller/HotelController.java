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
import edu.spring.board.pageutil.PageMaker;
import edu.spring.board.service.HotelService;

@Controller 
@RequestMapping(value="/hotel") // url 
public class HotelController {
	private static final Logger logger = 
			LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	HotelService hotelService;
	
	@GetMapping("/list")
	public String hotelGET(Model model, Integer page, Integer numsPerPage, String sortBy, String keyword,
			RedirectAttributes reAttr) {
		logger.info("hotelGET() 호출");
		logger.info("page = " + page + ", umsePerPage = " + numsPerPage);
		logger.info("정렬 방식 : " + sortBy);
		logger.info(keyword);
		
		// 페이징 처리 
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		// 정렬이 없으면 기본 전체검색
		if (sortBy == null || sortBy.equals("")) {
			List<HotelVO> list = hotelService.read(criteria);
			model.addAttribute("list", list);
		} else if(sortBy.equals("hotelName")) { // 호텔 이름순 정렬
			List<HotelVO> list = hotelService.readOrderByHotelNameDesc(criteria);
			model.addAttribute("list", list);
		} else if(sortBy.equals("hoteReviewCnt")) { // 호텔 리뷰순 정렬
			List<HotelVO> list = hotelService.readOrderByReviewDesc(criteria);
			model.addAttribute("list", list);
		} else if(sortBy.equals("hotelStarAvg")) { // 호텔 평점순 정렬
			List<HotelVO> list = hotelService.readOrderByStarAvgDesc(criteria);
			model.addAttribute("lsit", list);
		}
		
		// keyword 검색 키워드가 있으면
		if(keyword != null) {
			List<HotelVO> list = hotelService.readByHotelName(keyword, criteria);
			model.addAttribute("list", list);
			
			// keyword 값이 없으면(검색 결과가 없으면)
			if(list.isEmpty()) {
				reAttr.addFlashAttribute("result", "searchFail");
				return "redirect:/hotel/list";
			}
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(hotelService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("sortBy", sortBy); // 정별별 순서 때 페이징 처리가 제 기능을 하려면 쿼리스트링 유지해줘야됨
		model.addAttribute("pageMaker", pageMaker);
		
	return "hotel/list";	
	} // end hotelGET
	
	@GetMapping("/detail")
	public void detailGET(Model model, Integer hotelId, Integer page) {
		logger.info("detailGET() 호출 : hotelId = " + hotelId);
		HotelVO hvo = hotelService.read(hotelId);
		model.addAttribute("hvo", hvo);
		model.addAttribute("page",page);
	} // end detialGET
	
	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET() 호출");
		return "redirect:/member/login";
	} // end loginGET
	
	
	
} // end HotelController











