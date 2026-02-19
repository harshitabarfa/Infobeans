package com.dao;

import com.model.BookingModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDao {
	String url = "jdbc:mysql://localhost:3306/batch14";
	String user = "root";
	String pass = "123456";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public void addBooking(BookingModel b) throws SQLException {
		String sql = "insert into bookings (guest_name, room_number, check_in_date, check_out_date, total_amount) values (?,?,?,?,?)";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, b.getGuest_name());
		ps.setInt(2, b.getRoom_number());
		ps.setDate(3, b.getCheck_in_date());
		ps.setDate(4, b.getCheck_out_date());
		ps.setDouble(5, b.getTotalAmount());
		ps.executeUpdate();

		ResultSet keys = ps.getGeneratedKeys();
		if (keys.next()) {
			int generatedId = keys.getInt(1);
			b.setBooking_id(generatedId);
		}
	}

	public List<BookingModel> getAllBooking() throws SQLException {
		List<BookingModel> bm = new ArrayList<>();
		String sql = "select * from bookings";

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("booking_id");
			String guestName = rs.getString("guest_name");
			int roomNo = rs.getInt("room_number");
			Date checkIn = rs.getDate("check_in_date");
			Date checkOut = rs.getDate("check_out_date");
			double amount = rs.getDouble("total_amount");

			BookingModel bm1 = new BookingModel(id, guestName, roomNo, checkIn, checkOut, amount);
			bm.add(bm1);
		}
		return bm;
	}

	public List<BookingModel> getAllBookingById(int id) throws SQLException {
		List<BookingModel> bm = new ArrayList<>();
		String sql = "select * from bookings where booking_id = ?";

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			BookingModel bm1 = new BookingModel();
			int booking_id = rs.getInt("booking_id");
			String guestName = rs.getString("guest_name");
			int roomNo = rs.getInt("room_number");
			Date checkIn = rs.getDate("check_in_date");
			Date checkOut = rs.getDate("check_out_date");
			double amount = rs.getDouble("total_amount");

			BookingModel bm2 = new BookingModel(booking_id, guestName, roomNo, checkIn, checkOut, amount);
			bm.add(bm2);
		}
		return bm;
	}

	public void updateBooking(BookingModel bm) throws SQLException {
		String sql = "update bookings set check_out_date = ? where booking_id = ?";
		Connection con = getConnection();

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, bm.getCheck_out_date());
		ps.setInt(2, bm.getBooking_id());
		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		String sql = "delete from bookings where booking_id = ?";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public int getTotalBookings() throws SQLException {
		Connection con = getConnection();
		String sql = "SELECT COUNT(*) FROM bookings";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public List<BookingModel> getBookingsInDateRange(Date start, Date end) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from bookings where check_in_date >= ? and check_out_date <= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, start);
		ps.setDate(2, end);
		ResultSet rs = ps.executeQuery();

		List<BookingModel> list = new ArrayList<>();
		while (rs.next()) {
			BookingModel bm1 = new BookingModel();
			int booking_id = rs.getInt("booking_id");
			String guestName = rs.getString("guest_name");
			int roomNo = rs.getInt("room_number");
			Date checkIn = rs.getDate("check_in_date");
			Date checkOut = rs.getDate("check_out_date");
			double amount = rs.getDouble("total_amount");

			BookingModel bm2 = new BookingModel(booking_id, guestName, roomNo, checkIn, checkOut, amount);
			list.add(bm2);
		}
		return list;
	}

	public List<BookingModel> getBookingsByGuestName(String name) throws SQLException {
		Connection con = getConnection();
		String sql = "select * from bookings where guest_name like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + name + "%");
		ResultSet rs = ps.executeQuery();

		List<BookingModel> list = new ArrayList<>();
		while (rs.next()) {
			BookingModel bm1 = new BookingModel();
			int booking_id = rs.getInt("booking_id");
			String guestName = rs.getString("guest_name");
			int roomNo = rs.getInt("room_number");
			Date checkIn = rs.getDate("check_in_date");
			Date checkOut = rs.getDate("check_out_date");
			double amount = rs.getDouble("total_amount");

			BookingModel bm2 = new BookingModel(booking_id, guestName, roomNo, checkIn, checkOut, amount);
			list.add(bm2);
		}
		return list;
	}

	public List<Integer> getAvailableRooms(Date from, Date to) throws SQLException {
		Connection con = getConnection();
		String sql = "select room_number from bookings where room_number not in "
				+ "(select room_number from bookings where " + "(check_in_date <= ? and check_out_date >= ?))";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setDate(1, to);
		ps.setDate(2, from);
		ResultSet rs = ps.executeQuery();

		List<Integer> availableRooms = new ArrayList<>();
		while (rs.next()) {
			availableRooms.add(rs.getInt("room_number"));
		}
		return availableRooms;
	}
}
