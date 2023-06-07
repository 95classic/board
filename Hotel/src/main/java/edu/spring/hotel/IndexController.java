package edu.spring.hotel;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		logger.info("indexGET() ȣ��");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		logger.info("���� ��� : " + sortBy);
		logger.info(keyword);
		// ����¡ ó��
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		if (sortBy == null || sortBy.equals("")) {
			List<HotelVO> list = hotelService.read(criteria);
			model.addAttribute("list", list);
		} else if (sortBy.equals("hotelName")) {
			List<HotelVO> list = hotelService.readOrderByHotelNameAsc(criteria);
			model.addAttribute("list", list);
		} else if (sortBy.equals("hotelReviewCnt")) {
			List<HotelVO> list = hotelService.readOrderByReviewDesc(criteria);
			model.addAttribute("list", list);
		} else if (sortBy.equals("hotelReviewAvg")) {
			List<HotelVO> list = hotelService.readOrderByReviewAvgDesc(criteria);
			model.addAttribute("list", list);
		}

		// keyword �˻� Ű���尡 ������
		if (keyword != null) {
			List<HotelVO> list = hotelService.readByHotelName(keyword, criteria);
			model.addAttribute("list", list);

			// keyword ���� ������(�˻������ ������)
			if (list.isEmpty()) {
				reAttr.addFlashAttribute("result", "searchFail");
				return "redirect:/";
			}

		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(hotelService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("sortBy", sortBy); // ���ĺ� ������ ����¡ ó���� �� ����� �Ϸ��� ������Ʈ���� �������־�� ��
		model.addAttribute("pageMaker", pageMaker);
		return "index";
	} // end indexGET()

	@GetMapping("/detail")
	public void detailGET(Model model, Integer hotelId, Integer page) {
		logger.info("detailGET() ȣ�� : hotelId = " + hotelId);
		HotelVO hvo = hotelService.read(hotelId);
		List<RoomVO> list = roomService.read(hotelId);
		model.addAttribute("list", list);
		model.addAttribute("hvo", hvo);
		model.addAttribute("page", page);
	} // end detailGET()

	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET() ȣ��");
		return "redirect:/member/login";
	} // end loginGET()

} // end IndexController
