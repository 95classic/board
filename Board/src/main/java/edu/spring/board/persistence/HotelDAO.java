package edu.spring.board.persistence;

import java.util.List;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;

public interface HotelDAO {
	
	HotelVO select(int hotelId); // ȣ�� �� �˻�
	
	List<HotelVO> selectAllByDefault(PageCriteria criteria); // ȣ�� �⺻ ��ü �˻�
	
	List<HotelVO> selectAllByReviewDesc(PageCriteria criteria); // ȣ�� ����� ��ü �˻�
	
	List<HotelVO> selectAllByStarAvgDesc(PageCriteria criteria); // ȣ�� ������ ��ü �˻�

	List<HotelVO> selectAllByHotelNameDesc(PageCriteria criteria); // ȣ�� �����ټ� ��ü �˻�

	List<HotelVO> selectByHotelName(String keyword, PageCriteria criteria); // ȣ�� �̸� Ű����� �˻�
	
	int getTotalCount(); // ��ü ȣ�� �� �ҷ�����
	
	int updateReviewCntAndAvg(int amount, int hotelId); // ȣ�� ���� ���, ������ ���� ��� ����
	
	int updateHeartCnt(int amount, int hotelId); // ��Ʈ ���, ������ ��Ʈ ī��Ʈ ����
	
	List<HotelVO> selectByHeart(String memberId); // ����ڰ� ���� ȣ�ڸ�� ��ü �˻� 

}
