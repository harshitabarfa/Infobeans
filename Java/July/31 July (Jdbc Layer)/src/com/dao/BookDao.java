package com.dao;

import com.model.BookModel;
import java.sql.*;
import java.util.*;

public class BookDao {
	String url = "jdbc:mysql://localhost:3306/batch14";
	String user = "root";
	String pass = "123456";

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}

	public void addBook(BookModel b) throws SQLException {
		String i = "insert into book(book_id, title, author, price, quantity) values (?,?,?,?,?)";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(i);

		int book_id = b.getBook_id();
		String title = b.getTitle();
		String author = b.getAuthor();
		double price = b.getPrice();
		int quantity = b.getQuantity();

		ps.setInt(1, book_id);
		ps.setString(2, "Happy goals");
		ps.setString(3, "Harshita");
		ps.setDouble(4, 350.00);
		ps.setInt(5, 5);
		ps.executeUpdate();
	}

	public List<BookModel> getAllBook() throws SQLException {
		List<BookModel> l = new ArrayList<>();

		Connection con = getConnection();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery("select * from book");
		while (rs.next()) {
			int book_id = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			int quantity = rs.getInt("quantity");

			BookModel bs = new BookModel(book_id, title, author, price, quantity);
			l.add(bs);
		}
		return l;
	}

	public BookModel searchBook(int bookId) throws SQLException {
		String s = "select * from book where book_id = ?";

		Connection con = getConnection();
		Statement st = con.createStatement();
		PreparedStatement ps = con.prepareStatement(s);

		ps.setInt(1, bookId);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int book_id = rs.getInt("book_id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			double price = rs.getDouble("price");
			int quantity = rs.getInt("quantity");

			return new BookModel(book_id, title, author, price, quantity);
		} else {
			return null;
		}
	}

	public void updateBook(BookModel b) throws SQLException {
		String u = "update book set title= ?, author= ?, price= ?, quantity= ? where book_id= ?";
		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(u);

		ps.setString(1, b.getTitle());
		ps.setString(2, b.getAuthor());
		ps.setDouble(3, b.getPrice());
		ps.setInt(4, b.getQuantity());
		ps.setInt(5, b.getBook_id());
		ps.executeUpdate();
	}

	public void deleteBook(int bookId) throws SQLException {
		String d = "delete from book where book_id= ?";

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(d);

		ps.setInt(1, bookId);
		ps.executeUpdate();
	}

	public List<BookModel> searchByAuthor(String author) throws SQLException {
		List<BookModel> list = new ArrayList<>();
		String sa = "select * from book where author = ?";

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sa);

		ps.setString(1, author);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			BookModel b = new BookModel(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
					rs.getDouble("price"), rs.getInt("quantity"));
			list.add(b);
		}
		return list;
	}

	public List<BookModel> getBooksInPriceRange(double minPrice, double maxPrice) throws SQLException {
		List<BookModel> list = new ArrayList<>();

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement("select * from book where price between ? and ?");

		ps.setDouble(1, minPrice);
		ps.setDouble(2, maxPrice);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			BookModel b = new BookModel(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
					rs.getDouble("price"), rs.getInt("quantity"));
			list.add(b);
		}
		return list;
	}

	public boolean increaseQuantity(int id, int add) throws SQLException {
		String sql = "UPDATE book SET quantity = quantity + ? WHERE book_id = ?";
		Connection c = getConnection();
		PreparedStatement p = c.prepareStatement(sql);
		p.setInt(1, add);
		p.setInt(2, id);
		return p.executeUpdate() > 0;
	}

	public List<BookModel> getBooksSortedByPrice() throws SQLException {
		String sql = "SELECT * FROM book ORDER BY price ASC";
		List<BookModel> list = new ArrayList<>();
		try (Connection c = getConnection();
				PreparedStatement p = c.prepareStatement(sql);
				ResultSet rs = p.executeQuery()) {
			while (rs.next()) {
				list.add(new BookModel(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
						rs.getDouble("price"), rs.getInt("quantity")));
			}
		}
		return list;
	}
}
