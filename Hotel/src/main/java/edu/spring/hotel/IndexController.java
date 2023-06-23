package edu.spring.hotel;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.domain.RoomVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.HotelService;
import edu.spring.hotel.service.RoomService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private HotelService hotelService;

	@Autowired
	private RoomService roomService;

	@GetMapping
	public String indexGET(Model model, Integer page, Integer numsPerPage, String sortBy, String keyword,
			RedirectAttributes reAttr) {
		logger.info("indexGET() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		logger.info("정렬 방식 : " + sortBy);
		logger.info(keyword);

		// 페이징 처리
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<HotelVO> list = null;
		PageMaker pageMaker = new PageMaker();
		
		if (keyword != null) {	
			list = hotelService.readByHotelName(keyword, criteria.getStart(), criteria.getEnd());
			pageMaker.setTotalCount(hotelService.getTotalCountsByHotelName(keyword));
			model.addAttribute("list", list);
		} else if (sortBy == null || sortBy.equals("")) {
			list = hotelService.read(criteria);
			pageMaker.setTotalCount(hotelService.getTotalCounts());
		} else if (sortBy.equals("hotelName")) {
			list = hotelService.readOrderByHotelNameAsc(criteria);
			pageMaker.setTotalCount(hotelService.getTotalCounts());
		} else if (sortBy.equals("hotelReviewCnt")) {
			list = hotelService.readOrderByReviewDesc(criteria);
			pageMaker.setTotalCount(hotelService.getTotalCounts());
		} else if (sortBy.equals("hotelReviewAvg")) {
			list = hotelService.readOrderByReviewAvgDesc(criteria);
			pageMaker.setTotalCount(hotelService.getTotalCounts());
		}
		
		pageMaker.setCriteria(criteria);
		pageMaker.setPageData();
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		
		return "index";
	}

	@GetMapping("/detail")
	public void detailGET(Model model, Integer hotelId, Integer page) {
		logger.info("detailGET() 호출 : hotelId = " + hotelId);
		HotelVO hvo = hotelService.read(hotelId);
		List<RoomVO> list = roomService.read(hotelId);
		model.addAttribute("list", list);
		model.addAttribute("hvo", hvo);
		model.addAttribute("page", page);
	} // end detailGET()

	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET() 호출");
		return "redirect:/member/login";
	} // end loginGET()

} // end IndexController
