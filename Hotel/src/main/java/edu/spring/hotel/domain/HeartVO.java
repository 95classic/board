package edu.spring.hotel.domain;

public class HeartVO {
	private int heartId;
	private int hotelId;
	private String memberId;
	
	public HeartVO() {
		
	}

	public HeartVO(int heartId, int hotelId, String memberId) {
		this.heartId = heartId;
		this.hotelId = hotelId;
		this.memberId = memberId;
	}

	public int getHeartId() {
		return heartId;
	}

	public void setHeartId(int heartId) {
		this.heartId = heartId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "HeartVO [heartId=" + heartId + ", hotelId=" + hotelId + ", memberId=" + memberId + "]";
	}
	
} // end HeartVO
