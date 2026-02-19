package com.controller;

import java.sql.*;
import java.sql.Date;
import com.model.*;
import com.service.*;
import java.util.*;

public class Booking {
	public static void main(String args[]) throws SQLException {
		Scanner sc = new Scanner(System.in);
		BookingService bs = new BookingService();

		while (true) {
			System.out.println("\n--------Hotel Booking System--------");
			System.out.println("1. Add new booking");
			System.out.println("2. View all bookings");
			System.out.println("3. Get booking by ID");
			System.out.println("4. Update check-out date");
			System.out.println("5. Cancel booking");
			System.out.println("6. Count total bookings");
			System.out.println("7. Get bookings in date range");
			System.out.println("8. Get bookings by guest name");
			System.out.println("9. Get available rooms in date range");
			System.out.println("10. Exit");

			System.out.print("\nEnter choice: ");

		    if (sc.hasNextInt()) {
		        int choice = sc.nextInt();
		        sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("\nEnter guest name: ");
				String guestName = sc.nextLine();

				System.out.print("Enter room number: ");
				int roomNo = Integer.parseInt(sc.nextLine());

				System.out.print("Enter check-in date: ");
				Date checkIn = Date.valueOf(sc.nextLine());

				System.out.print("Enter check-out date: ");
				Date checkOut = Date.valueOf(sc.nextLine());

				System.out.print("Total amount: ");
				double amount = sc.nextDouble();

				BookingModel b = new BookingModel(guestName, roomNo, checkIn, checkOut, amount);
				bs.addBooking(b);

				System.out.println("Booking added successfully!");
				break;

			case 2:
				List<BookingModel> bm = bs.getAllBooking();
				for (BookingModel bm2 : bm) {
					System.out.println(bm2);
				}
				break;

			case 3:
				System.out.print("\nEnter Booking ID to retrieve: ");
				int id = Integer.parseInt(sc.nextLine());

				List<BookingModel> bm1 = bs.getAllBookingById(id);
				for (BookingModel bm2 : bm1) {
					System.out.println(bm2);
				}
				break;

			case 4:
				System.out.print("\nEnter booking id to update: ");
				int uid = Integer.parseInt(sc.nextLine());

				System.out.print("Enter new check-out date : ");
				Date nCheckOutDate = Date.valueOf(sc.next());
				sc.nextLine();

				BookingModel updateBooking = new BookingModel();
				updateBooking.setBooking_id(uid);
				updateBooking.setCheck_out_date(nCheckOutDate);
				bs.updateBooking(updateBooking);
				System.out.println("Check-out date updated successfully!");
				break;

			case 5:
				System.out.print("\nEnter booking id to delete: ");
				int did = Integer.parseInt(sc.nextLine());

				bs.delete(did);
				System.out.print("Booking deleted");
				break;

			case 6:
				int total = bs.getTotalBookings();
				System.out.println("Total bookings: " + total);
				break;

			case 7:
				System.out.print("Enter start date: ");
				Date startDate = Date.valueOf(sc.next());

				System.out.print("Enter end date: ");
				Date endDate = Date.valueOf(sc.next());

				List<BookingModel> bookingsInRange = bs.getBookingsInDateRange(startDate, endDate);
				for (BookingModel bdr : bookingsInRange) {
					System.out.println(bdr);
				}
				break;

			case 8:
				System.out.print("Enter guest name to search: ");
				String guest = sc.next();
				List<BookingModel> guestBookings = bs.getBookingsByGuestName(guest);
				for (BookingModel g : guestBookings) {
					System.out.println(g);
				}
				break;

			case 9:
				System.out.print("Enter start date: ");
				Date from = Date.valueOf(sc.next());
				System.out.print("Enter end date: ");
				Date to = Date.valueOf(sc.next());

				List<Integer> availableRooms = bs.getAvailableRooms(from, to);
				System.out.println("Available Rooms: " + availableRooms);
				break;

			case 10:
				System.out.println("\nExiting...");
				System.exit(0);

			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}}
