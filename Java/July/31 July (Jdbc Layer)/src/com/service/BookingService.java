package com.service;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.model.BookingModel;
import com.dao.BookingDao;

public class BookingService {
	
	BookingDao dao = new BookingDao();
	public void addBooking(BookingModel b) throws SQLException
	{
		dao.addBooking(b);
	}
	
	public List<BookingModel> getAllBooking() throws SQLException
	{
		return dao.getAllBooking();
	}
	
	public List<BookingModel> getAllBookingById(int id) throws SQLException
	{
		return dao.getAllBookingById(id);
	}
	
	public void updateBooking(BookingModel bm) throws SQLException
	{
		dao.updateBooking(bm);
	}
	
	public void delete(int id) throws SQLException
	{
		dao.delete(id);
	}
	
	public int getTotalBookings() throws SQLException 
	{
		return dao.getTotalBookings();
	}
	
	public List<BookingModel> getBookingsInDateRange(Date start, Date end) throws SQLException 
	{
		return dao.getBookingsInDateRange(start, end);
	}
	
	public List<BookingModel> getBookingsByGuestName(String name) throws SQLException 
	{
		return dao.getBookingsByGuestName(name);
	}
	
	public List<Integer> getAvailableRooms(Date from, Date to) throws SQLException 
	{
		return dao.getAvailableRooms(from, to);
	}
}
















