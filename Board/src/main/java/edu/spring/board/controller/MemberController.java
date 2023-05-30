package edu.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.board.domain.MemberVO;
import edu.spring.board.service.MemberService;

@Controller // @Component
// * 표현 계층(Presentation Layer)
// - view(페이지)와 service를 연결하는 역할
// - request에 대한 response를 전달하는 역할
@RequestMapping(value="/member") // url 
public class MemberController {
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET() 호출");
	} // end registerGET()
	
	@PostMapping("/register")
	public String registerPOST(MemberVO vo, RedirectAttributes reAttr) { 
		logger.info("registerPOST() 호출");
		logger.info(vo.toString());
		int result = memberService.create(vo);
		logger.info(result + "행 삽입");
		if (result ==1) {
			reAttr.addFlashAttribute("result" , "registerSuccess");
			return "redirect:/";
		} else {
			return "redirect:/member/register";
		}
	} // end registerPOST()
	
	@GetMapping("/idCheck")
	public void idCheckGET() {
		
	} // end idCheckGET() 아이디 중복 확인
	
	@ResponseBody
	@PostMapping("/idCheck")
	public int idCheckPOST(MemberVO vo) {
		logger.info("idcheckPOST() 호출");
		logger.info(vo.toString());
		
		int result = memberService.idCheck(vo);
		return result;
	} // end idCheckPOST() 아이디 중복 확인
	
	@GetMapping("/phoneCheck")
	public void phoneCheck() {
		
	} // end phoneGET() 휴대번호 중복 확인
	
	@ResponseBody
	@PostMapping("phoneCheck")
	public int phoneCheckPOST(MemberVO vo) {
		logger.info("phoneCheckPOST() 호출");
		logger.info(vo.toString());
		
		int result = memberService.phoneCheck(vo);
		return result;
	} // end phoneCheckPOST() 휴대번호 중복 확인
	
	// 로그인 메소드
	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET()호출 ");
		return "member/login";
	} // loginGET() 로그인
	
	@PostMapping("/login")
	public String loginPOST(MemberVO vo, RedirectAttributes reAttr,  HttpSession session) throws Exception{
		logger.info("loginPOST() 호출");
		
		vo = memberService.login(vo);
		
		String targetURI = (String) session.getAttribute("targetURI");
		logger.info(targetURI);
		
		if(vo != null) {
			session.setAttribute("memberId", vo.getMemberId());
			reAttr.addFlashAttribute("result", "loginSuccess");
			if(targetURI != null) {
				session.removeAttribute("targetURI");
				return "redirect:" + targetURI;
			} else {
				return "redirect:/";
			}
		} else {
			reAttr.addFlashAttribute("result","loginFail");
			return "redirect:/member/login";
		}
	} // end loginPOST()
	
	@GetMapping("/logout")
	public String logutGET(HttpSession session, RedirectAttributes reAttr) {
		logger.info("logoutGET()호출 ");
		session.removeAttribute("memberId");
		reAttr.addFlashAttribute("result", "logoutSuccess");
		return "redirect:/";
	} // end logoutGET()
	
	@GetMapping("/update")
	public void updateGET(HttpSession session, Model model) {
		logger.info("updateGET() 호출 ");
		String memberId = (String) session.getAttribute("memberId");
		logger.info(memberId);
		MemberVO vo = memberService.read(memberId);
		model.addAttribute("vo",vo);
	} // and updateGET()
	
	@PostMapping("/update")
	public String updatePOST(MemberVO vo, RedirectAttributes reAttr) {
		logger.info("updatePOST() 호출");
		int result = memberService.update(vo);
		if (result == 1) {
			logger.info(result + "행 수정");
			reAttr.addFlashAttribute("result" , "updateSuccess");
			return "redirect:/member/mypage";
		} else {
			return "redirect:/member/update";
		}
	} // end updatePOST()
	
	
	@GetMapping("/delete")
	public void deleteGET() {
		logger.info("deleteGET() 호출 ");
	} // end deleteGET()
	
	@PostMapping("delete")
	public String deletePOST(MemberVO vo, RedirectAttributes reAttr, HttpSession session) {
		logger.info("deletePOST()호출");
		int result = memberService.delete(vo);
		if (result ==1 ) {
			logger.info(result + "행 삭제");
			reAttr.addFlashAttribute("result", "deleteSuccess");
			session.removeAttribute("memberId");
			return "redirect:/";
		} else {
			reAttr.addFlashAttribute("result", "deleteFail");
			return "redirect:/member/delete";
		}
	} // end deletePOST()
	
	@GetMapping("/find-memberid")
	public void findMemberId() {
		logger.info("findMemberId() 호출");
	} // end findMemberId()
	
	@GetMapping("/find-memberpw")
	public void findMemberpw() {
		logger.info("findMemberpw() 호출");
	} // end findMemberPw()
	
	@GetMapping("/mypage")
	public void myPageGET() {
		logger.info("myPageGET() 호출");
	} // end myPage
	
} // end MemberController