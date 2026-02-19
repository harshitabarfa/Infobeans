package com.model;

import java.sql.Date;

public class BookingModel {

	private int booking_id;
	private String guest_name;
	private int room_number;
	private Date check_in_date;
	private Date check_out_date;
	private double total_amount;

	public BookingModel() {
		super();
	}

	public BookingModel(int booking_id, String guest_name, int room_number, Date check_in_date, Date check_out_date,
			double total_amount) {
		super();
		this.booking_id = booking_id;
		this.guest_name = guest_name;
		this.room_number = room_number;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.total_amount = total_amount;
	}
	
	public BookingModel(String guest_name, int room_number, Date check_in_date, Date check_out_date, double total_amount) {
		this.guest_name = guest_name;
		this.room_number = room_number;
		this.check_in_date = check_in_date;
		this.check_out_date = check_out_date;
		this.total_amount = total_amount;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public int getRoom_number() {
		return room_number;
	}

	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}

	public Date getCheck_in_date() {
		return check_in_date;
	}

	public void setCheck_in_date(Date check_in_date) {
		this.check_in_date = check_in_date;
	}

	public Date getCheck_out_date() {
		return check_out_date;
	}

	public void setCheck_out_date(Date check_out_date) {
		this.check_out_date = check_out_date;
	}

	public double getTotalAmount() {
		return total_amount;
	}

	public void setTotalAmount(double total_amount) {
		this.total_amount = total_amount;
	}

	public String toString() {
		return "booking_id= " + booking_id + ", guest_name= " + guest_name + ", room_number= " + room_number
				+ ", check_in_date= " + check_in_date + ", check_out_date= " + check_out_date + ", total_amount= "
				+ total_amount;
	}
}
