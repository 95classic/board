package edu.spring.hotel.domain;

public class RoomVO {
	private int roomId;
	private int hotelId;
	private String roomName;
	private int roomPrice;
	private int roomCnt;
	
	public RoomVO() {

	}

	public RoomVO(int roomId, int hotelId, String roomName, int roomPrice, int roomCnt) {
		this.roomId = roomId;
		this.hotelId = hotelId;
		this.roomName = roomName;
		this.roomPrice = roomPrice;
		this.roomCnt = roomCnt;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}

	public int getRoomCnt() {
		return roomCnt;
	}

	public void setRoomCnt(int roomCnt) {
		this.roomCnt = roomCnt;
	}

	@Override
	public String toString() {
		return "RoomVO [roomId=" + roomId + ", hotelId=" + hotelId + ", roomName=" + roomName + ", roomPrice="
				+ roomPrice + ", roomCnt=" + roomCnt + "]";
	}
	
} // end RoomVO
 