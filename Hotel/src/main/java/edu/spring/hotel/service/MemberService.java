package edu.spring.hotel.service;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.pageutil.PageCriteria;

// CRUD(create, Read, Update, Delete)
public interface MemberService {
	int create(MemberVO vo);
	MemberVO read(String memberId);
	int update(MemberVO vo);
	int delete(MemberVO vo);
	MemberVO login(MemberVO vo) throws Exception;
	int idCheck(MemberVO vo); // 아이디 중복체크
	String findMemberId(MemberVO vo); // 아이디 찾기
	String findMemberPw(MemberVO vo); // 비밀번호 찾기
	int phoneCheck(MemberVO vo); // 휴대번호 중복체크
	
} // end MemberService 
