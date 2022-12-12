package com.java.bookmyshow.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.java.bookmyshow.dao.BookingRepo;
import com.java.bookmyshow.model.Booking;
import com.java.bookmyshow.model.Show;
import com.java.bookmyshow.model.ShowSeat;

public class BookingServiceImpl implements BookingService {
	BookingRepo bookingRepo;

	BookingServiceImpl(BookingRepo bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	@Override
	public boolean assignSeats(String userId, Show showName, List<ShowSeat> seats) {
		// TODO Auto-generated method stub
		if (isSeatsAlreadyBooked(showName, seats)) {
			throw new IllegalStateException();
		}
		final String bookingId = UUID.randomUUID().toString();
		Booking booking = new Booking(bookingId,seats,seats.size(),showName);
		bookingRepo.addShows(showName, booking);
		return true;
	}

	public boolean isSeatsAlreadyBooked(Show showName, List<ShowSeat> seats) {
		List<ShowSeat> seatsBooked = getAllSeatBooked(showName);
		for (ShowSeat seat : seats) {
			if (seatsBooked.contains(seat)) {
				return true;
			}
		}
		return false;
	}

	private List<ShowSeat> getAllSeatBooked(Show showName) {
		// TODO Auto-generated method stub
		return getAllBooking(showName).stream().filter(booking->booking.isConfirmed())
				.map(booking->booking.getShowSeats()).flatMap(Collection::stream)
                .collect(Collectors.toList());
	}

	private List<Booking> getAllBooking(Show showName) {
		// TODO Auto-generated method stub
		List<Booking> res = new ArrayList<>();
		List<String> bookingIds = bookingRepo.getShowToBookingId().get(showName.getShowId());
		for(String bookingId : bookingIds) {
			res.add(bookingRepo.getBookingIdToBooking().get(bookingId));
		}
		return res;
	}

}
