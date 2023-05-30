package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.domain.MemberVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.persistence.BoardDAO;
import edu.spring.board.persistence.MemberDAO;

@Service // @Component
// * 서비스 계층(Service/Business Laye)
// - 표현 계층(presentation Layer)과 영속 계층(persistence Layer)사이를
//   연결하여 두 계층이 직접적으로 통신하지 않도록 하는 역할
// - 트랜잭션(tranaction)관리
// - DB와 상관없이 데이터를 처리 가능

public class MemberServiceImple implements MemberService{
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberServiceImple.class);

	@Autowired
	private MemberDAO dao;

	@Override
	public int create(MemberVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	} // end create 등록

	@Override
	public MemberVO read(String memberId) {
		logger.info("read() 호출 : memberId = " + memberId);
		return dao.select(memberId);
	} // end read 상세 검색

	@Override
	public int update(MemberVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return dao.update(vo);
	} // end update

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete() 호출 : vo = " + vo.toString());
		return dao.delete(vo);
	} // end delete 삭제

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		logger.info("login()호출 : vo = " + vo.toString());
		logger.info("memberId = " + vo.getMemberId());
		logger.info("memberPw = " + vo.getMemberPw());
		return dao.login(vo);
	} // end login 로그인

	@Override
	public int idCheck(MemberVO vo) {
		logger.info("idCheck() 호출 : vo = " + vo.toString());
		return dao.idCheck(vo);
	} // end idCHeck 아이디 중복 확인

	@Override
	public int phoneCheck(MemberVO vo) {
		logger.info("phoneCheck() 호출 : vo = " + vo.toString());
		return dao.phoneCheck(vo);
	} // end phoneCheck 휴대번호 중복 확인

	@Override
	public String findMemberId(MemberVO vo) {
		logger.info("findMemberId() 호출 : vo =" + vo.getMemberId());
		return dao.findMemberId(vo);
	} // end findMemberId 아이디 찾기 

	@Override
	public String findMemberPw(MemberVO vo) {
		logger.info("findMemberPw() 호출 : vo =" + vo.getMemberPw());
		return dao.findMemberPw(vo);
	} // end findMmeberPw 비밀번호 찾기
	
	
}
