package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.domain.MemberVO;
import edu.spring.board.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface MemberService {
	int create(MemberVO vo); // 등록록
	MemberVO read(String memberId); // 상세 검색
	int update(MemberVO vo); // 수정
	int delete(MemberVO vo); // 삭제
	MemberVO login(MemberVO vo) throws Exception; // 로그인
	int idCheck(MemberVO vo); // 아이디 중복 확인
	int phoneCheck(MemberVO vo); // 휴대번호 중복 확인
	String findMemberId(MemberVO vo); // 아이디 찾기
	String findMemberPw(MemberVO vo); // 비밀번호 찾기 
} // end BoardService
