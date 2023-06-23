package edu.spring.hotel.persistence;

import java.util.Date;

import edu.spring.hotel.domain.MemberVO;

public interface MemberDAO {
	
	int insert(MemberVO vo); // 회원 등록
	
	MemberVO select(String memberId); // 회원 상세검색
	
	int update(MemberVO vo); // 회원 수정
	
	int delete(MemberVO vo); // 회원 삭제
	
	int idCheck(MemberVO vo); // 아이디 중복체크
	
	MemberVO login(MemberVO vo) throws Exception; // 로그인
	
	String findMemberId(MemberVO vo); // 아이디 찾기
	 
	String findMemberPw(MemberVO vo); // 비밀번호 찾기
	
	int phoneCheck(MemberVO vo); //  휴대폰 번호 중복체크 
	
	Date selectMemberDateCreated(String memberId);
	
}
