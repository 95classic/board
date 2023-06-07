package edu.spring.hotel.domain;

import java.util.Date;

public class ReservationVO {
	private int reservationId;
	private int hotelId;
	private int roomId;
	private String memberId;
	private String reservationHotelName;
	private String reservationRoomName;
	private int totalPrice;
	private Date reservationCheckIn;
	private Date reservationCheckOut;
	
	public ReservationVO() {

	}

	public ReservationVO(int reservationId, int hotelId, int roomId, String memberId, String reservationHotelName,
			String reservationRoomName, int totalPrice, Date reservationCheckIn, Date reservationCheckOut) {
		this.reservationId = reservationId;
		this.hotelId = hotelId;
		this.roomId = roomId;
		this.memberId = memberId;
		this.reservationHotelName = reservationHotelName;
		this.reservationRoomName = reservationRoomName;
		this.totalPrice = totalPrice;
		this.reservationCheckIn = reservationCheckIn;
		this.reservationCheckOut = reservationCheckOut;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReservationHotelName() {
		return reservationHotelName;
	}

	public void setReservationHotelName(String reservationHotelName) {
		this.reservationHotelName = reservationHotelName;
	}

	public String getReservationRoomName() {
		return reservationRoomName;
	}

	public void setReservationRoomName(String reservationRoomName) {
		this.reservationRoomName = reservationRoomName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getReservationCheckIn() {
		return reservationCheckIn;
	}

	public void setReservationCheckIn(Date reservationCheckIn) {
		this.reservationCheckIn = reservationCheckIn;
	}

	public Date getReservationCheckOut() {
		return reservationCheckOut;
	}

	public void setReservationCheckOut(Date reservationCheckOut) {
		this.reservationCheckOut = reservationCheckOut;
	}

	@Override
	public String toString() {
		return "ReservationVO [reservationId=" + reservationId + ", hotelId=" + hotelId + ", roomId=" + roomId
				+ ", memberId=" + memberId + ", reservationHotelName=" + reservationHotelName + ", reservationRoomName="
				+ reservationRoomName + ", totalPrice=" + totalPrice + ", reservationCheckIn=" + reservationCheckIn
				+ ", reservationCheckOut=" + reservationCheckOut + "]";
	}

} // end ReservationVO
