package edu.spring.board.domain;

public class HeartVO {
	private int heartId;
	private int boardId;
	private String memberId;
	
	public HeartVO() {

	}

	public HeartVO(int heartId, int boardId, String memberId) {
		super();
		this.heartId = heartId;
		this.boardId = boardId;
		this.memberId = memberId;
	}

	public int getHeartId() {
		return heartId;
	}

	public void setHeartId(int heartId) {
		this.heartId = heartId;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "HeartVO [heartId=" + heartId + ", boardId=" + boardId + ", memberId=" + memberId + "]";
	}

	
	
	
} // end HeartVO
