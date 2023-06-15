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
// * ǥ�� ����(Presentation Layer)
// - view(������)�� service�� �����ϴ� ����
// - request�� ���� response�� �����ϴ� ����
@RequestMapping(value="/member") // url 
public class WantedController {
	private static final Logger logger = 
			LoggerFactory.getLogger(WantedController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/myWanted")
	public void myWantedGET(Model model, HttpSession session) {
		logger.info("myWantedGET()ȣ��");
		String memberId = (String) session.getAttribute("memberId");
		List<BoardVO> list = boardService.readByHeart(memberId);
		model.addAttribute("list", list);
		
	} // end myWantedGET()
	
	
	
} // end BoardController











