package edu.spring.board.persistence;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;

public interface BoardDAO {
	int insert(BoardVO vo); // ���
	List<BoardVO> selectAllDefault(); // ��ü ��� �⺻
	List<BoardVO> selectAllReplyCnt(); // ��ü �˻� ��ۼ�
	BoardVO select(int boardId); // �� ���
	int update(BoardVO vo); // ����
	int delete(int boardId); //����
	List<BoardVO> selectByTitleOrContent(String keyword, int start, int end); // �����̶� �������� �˻�
	List<BoardVO> selectByMemberId(String keyword, int start, int end); // �ۼ��ڷ� �˻�
	List<BoardVO> select(PageCriteria criteria); // ����¡ ó��
	int getTotalCounts(); //  �� �Խñ� ��
	int updateReplyCnt(int amount, int boardId); // �Խ��� ��� ���� ������Ʈ
	int selectBoardCnt(String memberId); // �Խñ� ��ȸ
	int updateHeartCnt(int amount, int boardId); // ��Ʈ ���� ����
	List<BoardVO> selectByHeart(String memberId); // ����ڰ� ���� �Խ��� ��� ��ü�˻�
}
