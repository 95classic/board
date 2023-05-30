package edu.spring.board.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.domain.MemberVO;
import edu.spring.board.pageutil.PageCriteria;

@Repository // @Componet
// - 영송 계층(Persistence Layer)의 DB와 관련 기능을 담당
// - Spring Component bean으로 등로갛ㅁ
// - servlet-context.xml의 component-scan을 통해
// 	 설정된 Component를 찾아와 bean으로 등록
// - <context:component-scan ../>
public class MemberDAOImple implements MemberDAO{
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.board.MemberMapper";
	
	// MyBatis의 sqlSession을 사용하기 위해
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(MemberVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert 등록

	@Override
	public MemberVO select(String memberId) {
		logger.info("select() 호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_member_id", memberId);
	} // end select 상세 검색

	@Override
	public int update(MemberVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update 수정

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete() 호출 : vo = " + vo.toString());
		return sqlSession.delete(NAMESPACE + ".delete", vo);
	} // end delete 삭제

	@Override
	public int idCheck(MemberVO vo) {
		logger.info("idCheck() 호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".idCheck", vo);
	} // end idCheck 아이디 중복 확인

	@Override
	public int phoneCheck(MemberVO vo) {
		logger.info("phoneCheck() 호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".phoneCheck", vo);
	} // end phoneCheck 휴대번호 중복 확인

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login() 호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
		
	} // end login 로그인

	@Override
	public String findMemberId(MemberVO vo) {
		logger.info("findMemerId()호출 vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".find_member_id", vo);
	} // end findMemberId 아이디 찾기

	@Override
	public String findMemberPw(MemberVO vo) {
		logger.info("findMemberPw() 호출 vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".find_member_pw", vo);
	} // end findMemberPw 비밀번호 찾기

	@Override
	public Date selectMemberDateCreated(String memberId) {
		logger.info("selectMemberDateCreated() 호출 : memberId = " + memberId);
		return sqlSession.selectOne(memberId + ".select_member_date_created", memberId);
	}

	
	
}
