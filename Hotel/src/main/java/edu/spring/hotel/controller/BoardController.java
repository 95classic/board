package edu.spring.hotel.controller;

import java.net.http.HttpRequest;
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

import edu.spring.hotel.domain.BoardVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.BoardService;

@Controller
@RequestMapping(value = "/board") // /hotel/board
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService boardService;

	@GetMapping("/list") // board 파일의 list.jsp
	public void list(Model model, String keyword, String searchType, Integer page, Integer numsPerPage) {
		logger.info("list() 호출");
		

		// 페이징 처리
		PageCriteria criteria = new PageCriteria();
		
		if (page != null) {
			criteria.setPage(page);
		}

		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<BoardVO> list = null;
		PageMaker pageMaker = new PageMaker();
		

		if (keyword == null || searchType == null || keyword.equals("") || searchType.equals("")) {
			list = boardService.read(criteria);
			pageMaker.setTotalCount(boardService.getTotalCounts());
		} else if (searchType != null && searchType.equals("memberId")) {
			logger.info("start : " + criteria.getStart() + ", end : " + criteria.getEnd());
			list = boardService.readByMemberId(keyword, criteria.getStart(), criteria.getEnd());
			pageMaker.setTotalCount(boardService.getTotalCountsByMemberId(keyword));
		} else if (searchType != null && searchType.equals("titleOrContent")) {
			list = boardService.readByTitleOrContent(keyword, criteria.getStart(), criteria.getEnd());
			pageMaker.setTotalCount(boardService.getTotalCountsByTitleOrContent(keyword));
		}

		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		pageMaker.setCriteria(criteria);
		pageMaker.setPageData();
		model.addAttribute("list", list);
		model.addAttribute("searchType", searchType);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageMaker", pageMaker);

	} // end list()

	@GetMapping("/register") // board 파일의 register.jsp
	public String registerGET(HttpSession session) {
		logger.info("registerGET() 호출");
		String memberId = (String) session.getAttribute("memberId");

		if (memberId != null) {
			return "/board/register";
		} else {
			session.setAttribute("targetURI", "/board/register");
			return "redirect:/login";
		}
	} // end registerGET()

	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		logger.info("registerPOST() 호출");
		logger.info(vo.toString());
		int result = boardService.create(vo);
		logger.info(result + "행 삽입");

		if (result == 1) {
			reAttr.addFlashAttribute("result", "registerSuccess");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/register";
		}
	} // end registerPOST()

	@GetMapping("/detail") // board 파일의 detail.jsp
	public void detailGET(Model model, Integer boardId, Integer page) {
		logger.info("detailGET() 호출 : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end detailGET()

	@GetMapping("/update") // board 파일의 update.jsp
	public void updateGET(Model model, Integer boardId, Integer page) {
		logger.info("updateGET() 호출 : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()

	@PostMapping("/update") // board 파일의 update.jsp
	public String updatePOST(BoardVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("updatePOST() 호출 : vo = " + vo.toString());
		int result = boardService.update(vo);
		if (result == 1) {
			reAttr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/board/list?page=" + page;
		} else {
			return "redirect:/board/update?boardId=" + vo.getBoardId();
		}
	} // end updatePOST()

	@PostMapping("/delete") // board 파일의 delete.jsp
	public String deletePOST(Integer boardId, RedirectAttributes reAttr) {
		logger.info("delete() 호출 : boardId = " + boardId);
		int result = boardService.delete(boardId);
		if (result == 1) {
			// 키-값 전송
			reAttr.addFlashAttribute("result", "deleteSuccess");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/list";
		}
	} // end deletePOST()

} // end BoardController
