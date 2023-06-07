package edu.spring.hotel.domain;

import java.util.Date;

public class MemberActivity {
	private Date memberDateCreated;
	private int boardCnt;
	private int replyCnt;
	private int reviewCnt;
	private int heartCnt;
	
	public MemberActivity() {
		
	}

	public MemberActivity(Date memberDateCreated, int boardCnt, int replyCnt, int reviewCnt, int heartCnt) {
		this.memberDateCreated = memberDateCreated;
		this.boardCnt = boardCnt;
		this.replyCnt = replyCnt;
		this.reviewCnt = reviewCnt;
		this.heartCnt = heartCnt;
	}

	public Date getMemberDateCreated() {
		return memberDateCreated;
	}

	public void setMemberDateCreated(Date memberDateCreated) {
		this.memberDateCreated = memberDateCreated;
	}

	public int getBoardCnt() {
		return boardCnt;
	}

	public void setBoardCnt(int boardCnt) {
		this.boardCnt = boardCnt;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public int getHeartCnt() {
		return heartCnt;
	}

	public void setHeartCnt(int heartCnt) {
		this.heartCnt = heartCnt;
	}

	@Override
	public String toString() {
		return "MemberActivity [memberDateCreated=" + memberDateCreated + ", boardCnt=" + boardCnt + ", replyCnt="
				+ replyCnt + ", reviewCnt=" + reviewCnt + ", heartCnt=" + heartCnt + "]";
	}

	
}
