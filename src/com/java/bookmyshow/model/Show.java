package com.java.bookmyshow.model;

import java.util.Date;

public class Show {
	private String showId;
	private Date createdOn;
	private Date startTime;
	private Date endTime;
	private Movie movie;

	public String getShowId() {
		return showId;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public Movie getMovie() {
		return movie;
	}
}
