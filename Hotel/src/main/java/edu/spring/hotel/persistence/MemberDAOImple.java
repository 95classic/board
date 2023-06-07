package edu.spring.hotel.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(MemberDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert 등록

	@Override
	public MemberVO select(String memberId) {
		logger.info("select()호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_by_member_id", memberId);
	} // end select 상세검색

	@Override
	public int update(MemberVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update 수정

	@Override
	public int delete(MemberVO vo) {
		logger.info("delete() 호출");
		logger.info("memberId = " + vo.getMemberId());
		logger.info("memberPw = " + vo.getMemberPw());
		return sqlSession.delete(NAMESPACE + ".delete", vo);
	} // end delete 삭제

	@Override
	public int idCheck(MemberVO vo) {
		logger.info("idcheck()호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".idCheck", vo);
	} // end idcheck 아이디 중복체크

	@Override
	public MemberVO login(MemberVO vo) {
		logger.info("login() 호출");
		logger.info("vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	} // 로그인

	@Override
	public String findMemberId(MemberVO vo) {
		logger.info("findMemberId() 호출 vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".find_member_id", vo);
	} // 아이디 찾기

	@Override
	public String findMemberPw(MemberVO vo) {
		logger.info("findMemberPw() 호출 : vo = " + vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".find_member_pw", vo);
	} // 비밀번호 찾기
	
	@Override
	public int phoneCheck(MemberVO vo) {
		logger.info("phonecheck()호출 : vo = " +  vo.toString());
		return sqlSession.selectOne(NAMESPACE + ".phoneCheck", vo);
	} // end phone 휴대폰 번호 중복체크

	@Override
	public Date selectMemberDateCreated(String memberId) {
		logger.info("selectMemberDateCreated() 호출 : memberId = " + memberId);
		return sqlSession.selectOne(NAMESPACE + ".select_member_date_created", memberId);
	}

} // end MemberDAOImple
