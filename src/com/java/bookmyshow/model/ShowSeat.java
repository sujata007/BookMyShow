package com.java.bookmyshow.model;

public class ShowSeat extends CinemaHallSeat {
	private int showSeatId;
	private double price;
	private boolean isReserved;

	public int getShowSeatId() {
		return showSeatId;
	}

	public double getPrice() {
		return price;
	}

	public boolean isReserved() {
		return isReserved;
	}

}
