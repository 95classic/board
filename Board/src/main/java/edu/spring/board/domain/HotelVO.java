package edu.spring.board.domain;

public class HotelVO {
	private int hotelId;
	private String hotelName;
	private String hotelContent;
	private String hotelAddress;
	private int reviewCnt;
	private String hotelImg;
	private double hotelStarAvg;
	private int heartCnt;
	
	public HotelVO() {

	}

	public HotelVO(int hotelId, String hotelName, String hotelContent, String hotelAddress, int reviewCnt,
			String hotelImg, double hotelStarAvg, int heartCnt) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelContent = hotelContent;
		this.hotelAddress = hotelAddress;
		this.reviewCnt = reviewCnt;
		this.hotelImg = hotelImg;
		this.hotelStarAvg = hotelStarAvg;
		this.heartCnt = heartCnt;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelContent() {
		return hotelContent;
	}

	public void setHotelContent(String hotelContent) {
		this.hotelContent = hotelContent;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public int getReviewCnt() {
		return reviewCnt;
	}

	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}

	public String getHotelImg() {
		return hotelImg;
	}

	public void setHotelImg(String hotelImg) {
		this.hotelImg = hotelImg;
	}

	public double getHotelStarAvg() {
		return hotelStarAvg;
	}

	public void setHotelStarAvg(double hotelStarAvg) {
		this.hotelStarAvg = hotelStarAvg;
	}

	public int getHeartCnt() {
		return heartCnt;
	}

	public void setHeartCnt(int heartCnt) {
		this.heartCnt = heartCnt;
	}

	@Override
	public String toString() {
		return "HotelVO [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelContent=" + hotelContent
				+ ", hotelAddress=" + hotelAddress + ", reviewCnt=" + reviewCnt + ", hotelImg=" + hotelImg
				+ ", hotelStarAvg=" + hotelStarAvg + ", heartCnt=" + heartCnt + "]";
	}
	
	
	
	
}
