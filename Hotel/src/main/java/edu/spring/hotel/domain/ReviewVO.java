package edu.spring.hotel.domain;

import java.util.Date;

public class ReviewVO {
	private int reviewId;
	private String memberId;
	private int hotelId;
	private String reviewContent;
	private int reviewStar;
	private Date reviewDateCreated;
	
	public ReviewVO() {

	}

	public ReviewVO(int reviewId, String memberId, int hotelId, String reviewContent, int reviewStar,
			Date reviewDateCreated) {
		this.reviewId = reviewId;
		this.memberId = memberId;
		this.hotelId = hotelId;
		this.reviewContent = reviewContent;
		this.reviewStar = reviewStar;
		this.reviewDateCreated = reviewDateCreated;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public Date getReviewDateCreated() {
		return reviewDateCreated;
	}

	public void setReviewDateCreated(Date reviewDateCreated) {
		this.reviewDateCreated = reviewDateCreated;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewId=" + reviewId + ", memberId=" + memberId + ", hotelId=" + hotelId + ", reviewContent="
				+ reviewContent + ", reviewStar=" + reviewStar + ", reviewDateCreated=" + reviewDateCreated + "]";
	}

}
