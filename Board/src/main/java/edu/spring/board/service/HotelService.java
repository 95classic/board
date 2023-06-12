package edu.spring.board.service;

import java.util.List;

import edu.spring.board.domain.HotelVO;
import edu.spring.board.pageutil.PageCriteria;

// CRUD(Create, Read, Update, Delete)
public interface HotelService {
	HotelVO read(int hotelId); // �� �˻�

	List<HotelVO> read(PageCriteria criteria); // ��ü �˻�
	
	List<HotelVO> readOrderByReviewDesc(PageCriteria criteria); // ���� �������� ��ü �˻�
	
	List<HotelVO> readOrderByStarAvgDesc(PageCriteria criteria); // ��� ���� �������� ��ü �˻�
	
	List<HotelVO> readOrderByHotelNameDesc(PageCriteria criteria); // ������ �������� ��ü�˻�
	
	List<HotelVO> readByHotelName(String keyword, PageCriteria criteria); // ȣ�� �̸����� �˻�
	
	int getTotalCounts(); // ��ü ȣ�� �� �޾ƿ��� 
	
	List<HotelVO> readByHeart(String memberId); // ���� ���� ȣ�� ��� ��ȸ
	
} // end HotelService
