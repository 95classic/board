package edu.spring.board.controller;

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

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.pageutil.PageMaker;
import edu.spring.board.service.BoardService;

@Controller // @Component
// * 표현 계층(Presentation Layer)
// - view(페이지)와 service를 연결하는 역할
// - request에 대한 response를 전달하는 역할
@RequestMapping(value="/board") // url 
public class BoardController {
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("list()호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		// paging 처리 
		// null 상태가 아닐때만 데이터 남겨준다는 내용
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		List<BoardVO> list = boardService.read(criteria);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(boardService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	}// end list()
	
	@GetMapping("/register")
	public String registerGET(HttpSession session) { 
		logger.info("registerGET()");
		String memberId = (String) session.getAttribute("memberId");
		
		if(memberId != null) {
			return "/board/register";
		} else {
			session.setAttribute("targerURI", "/board/register");
			return "redirect:/login";
		}
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr) {
		// RedirectAttributes
		// - 새로운 경로에 속성값을 전송하는 객체
		
		logger.info("registerPOST() 호출");
		logger.info(vo.toString());
		int result = boardService.create(vo);
		logger.info(result + "행 삽입");
		if(result == 1) {
			// 키 - 값 전송
			reAttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/register";
		}
	}// end registerPOST()
	
	@GetMapping("/detail")
	public void detail(Model model, Integer boardId, Integer page) {
		logger.info("detail() 호출 : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end detail()
	
	@GetMapping("/update")
	public void updateGET(Model model, Integer boardId, Integer page) {
		logger.info("updateGET() 호출 : boardId = " + boardId);
		BoardVO vo = boardService.read(boardId);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()
	
	@PostMapping("/update")
	public String updatePOST(BoardVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("updatePOST() 호출 : vo " + vo.toString());
		int result = boardService.update(vo);
		if(result == 1) {
			reAttr.addFlashAttribute("result", "updateSuccess");
			return "redirect:/board/list?page=" + page;
		} else {
			return "redirect:/board/update?boardId=" + vo.getBoardId();
		}
	} // end updatePOST()
	
	@PostMapping("/delete")
	public String delete(Integer boardId, RedirectAttributes reAttr) {
		logger.info("detete()호출 : boardId = " + boardId);
		int result = boardService.delete(boardId);
		if(result == 1) {
			reAttr.addFlashAttribute("result", "deleteSuccess");
			return "redirect:/board/list";
		} else {
			return "redirect:/board/list";
		}
	} // end delete();
	
} // end BoardController











