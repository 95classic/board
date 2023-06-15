package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface BoardService {
	int create(BoardVO vo); //  ���
	List<BoardVO> read(PageCriteria criteria); // ��ü�˻�
	List<BoardVO> readByTitleOrContent(String keyword, int start, int end);// ����,���� �˻�
	List<BoardVO> readByMemberId(String keyword, int start, int end); // �ۼ��� �˻�
	BoardVO read(int boardId);// �󼼰˻�
	int update(BoardVO vo); // ����
	int delete(int boardId); // ����
	int getTotalCounts(); // �� �Խñ� �� 
	List<BoardVO> readByHeart(String memberId); // ���ƿ��� ���

} // end BoardService
