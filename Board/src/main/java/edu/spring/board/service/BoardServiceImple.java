package edu.spring.board.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.board.domain.BoardVO;
import edu.spring.board.pageutil.PageCriteria;
import edu.spring.board.persistence.BoardDAO;

@Service // @Component
// * ���� ����(Service/Business Laye)
// - ǥ�� ����(presentation Layer)�� ���� ����(persistence Layer)���̸�
//   �����Ͽ� �� ������ ���������� ������� �ʵ��� �ϴ� ����
// - Ʈ�����(tranaction)����
// - DB�� ������� �����͸� ó�� ����

public class BoardServiceImple implements BoardService{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardServiceImple.class);

	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		logger.info("create()ȣ�� : vo = " + vo.toString());
		return dao.insert(vo);
	} // end create

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("read() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria);
	} // end readPaging ����¡ó��

	@Override
	public BoardVO read(int boardId) {
		logger.info("read() ȣ�� : boardId = " + boardId);
		return dao.select(boardId);
	} // end read �� �˻�

	@Override
	public int update(BoardVO vo) {
		logger.info("update()ȣ�� : vo = " + vo.toString());
		return dao.update(vo);
	} // end update ����

	@Override
	public int delete(int boardId) {
		logger.info("delete()ȣ�� : boardId = " + boardId);
		return dao.delete(boardId);
	} // end delete ����

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() ȣ��");
		return dao.getTotalCounts();
	} // end getTotalCounts �� �Խñ� ��

	@Override
	public List<BoardVO> readByTitleOrContent(String keyword, int start, int end) {
		logger.info("readByTitleOrContent()ȣ��");
		PageCriteria criteria = new PageCriteria(start, end);
		return dao.selectByTitleOrContent(keyword, criteria.getStart(), criteria.getEnd());
	} // end readByTitleOrContent ���� �������� �˻�

	@Override
	public List<BoardVO> readByMemberId(String keyword, int start, int end) {
		logger.info("readByMemberId()ȣ��");
		PageCriteria criteria = new PageCriteria(start, end);
		return dao.selectByMemberId(keyword, criteria.getStart(), criteria.getEnd());
	} // end readByMemberId �ۼ��ڷ� �˻�

	@Override
	public List<BoardVO> readByHeart(String memberId) {
		logger.info("readByHeart()ȣ�� memberId = " + memberId);
		return dao.selectByHeart(memberId);
	} // end readByHeart ���ƿ� ��� 

}
