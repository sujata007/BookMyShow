package com.java.bookmyshow.model;

import java.util.Date;
import java.util.List;

public class Booking {
	private String bookingId;
	private List<ShowSeat> showSeats;
	private int numOfSeats;
	private BookingStatus bookingStatus;
	private Show show;

	public Booking(String bookingId, List<ShowSeat> showSeats, int numOfSeats, Show show) {
		this.bookingId = bookingId;
		this.showSeats = showSeats;
		this.numOfSeats = numOfSeats;
		this.bookingStatus = BookingStatus.REQUESTED;
		this.show = show;
	}

	public String getBookingId() {
		return bookingId;
	}

	public List<ShowSeat> getShowSeats() {
		return showSeats;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public Show getShow() {
		return show;
	}
	public Boolean isConfirmed() {
		return this.getBookingStatus()== BookingStatus.CONFIRMED;
	}
	public void confirmBooking() {
		if(getBookingStatus()!=BookingStatus.REQUESTED) {
			throw new IllegalStateException();
		}
		this.bookingStatus = BookingStatus.CONFIRMED;
	}
}
