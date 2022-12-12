package com.java.bookmyshow.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.bookmyshow.model.Booking;
import com.java.bookmyshow.model.Show;

public class BookingRepo {
	private Map<String, List<String>> showToBookingId;
	private Map<String, Booking> bookingIdToBooking;
	private Map<String, Show> showIdToShow;

	public BookingRepo() {
		this.showToBookingId = new HashMap<>();
		this.bookingIdToBooking = new HashMap<>();
		this.showIdToShow = new HashMap<>();
	}

	public void addShows(Show show, Booking booking) {
		if (!showToBookingId.containsKey(show.getShowId())) {
			showToBookingId.put(show.getShowId(), new ArrayList<>());
		}
		showToBookingId.get(show.getShowId()).add(booking.getBookingId());
		bookingIdToBooking.put(booking.getBookingId(), booking);
		showIdToShow.put(show.getShowId(), show);
	}

	public Map<String, List<String>> getShowToBookingId() {
		return showToBookingId;
	}

	public Map<String, Booking> getBookingIdToBooking() {
		return bookingIdToBooking;
	}

	public Map<String, Show> getShowIdToShow() {
		return showIdToShow;
	}
}
