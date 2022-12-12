package com.java.bookmyshow.service;

import java.util.List;

import com.java.bookmyshow.model.Show;
import com.java.bookmyshow.model.ShowSeat;

public interface BookingService {
	public boolean assignSeats(String userId, Show showName,List<ShowSeat> seats);
}
