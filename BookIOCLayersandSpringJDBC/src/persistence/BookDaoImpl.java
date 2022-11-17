package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import entity.Book;


public class BookDaoImpl implements BookDao{
	

	@Override
	public Collection<Book> getAllBooks() {
		Connection connection = null;
		PreparedStatement preparedStatement;

		Collection<Book> bookList = new ArrayList<Book>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("BOOKID");
				String title = resultSet.getString("TITLE");
				String authName = resultSet.getString("AUTHOR_NAME");
				int numOfCopies = resultSet.getInt("NUMOFCOPIES");
		

				bookList.add(new Book(id, title, authName, numOfCopies));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bookList;
	
	}

	@Override
	public Book searchBook(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement;

		Book book = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS WHERE BOOKID=?");

			preparedStatement.setInt(1, id);
            // result set is pointing above first row
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int eid = resultSet.getInt("BOOKID");
				String title = resultSet.getString("TITLE");
				String authName = resultSet.getString("AUTHOR_NAME");
				int numOfCopies = resultSet.getInt("NUMOFCOPIES");
		

				book = new Book(id, title, authName, numOfCopies);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;

	}

	

	@Override
	public int insertBook(Book book) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("INSERT INTO BOOKS VALUES(?,?,?,?)");

			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getAuthorName());
			preparedStatement.setInt(4, book.getNoOfCopies());


			rows = preparedStatement.executeUpdate();

			return rows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
	

	@Override
	public int deleteRecord(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		int rows=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wileydi001", "root", "Characterised123");

			preparedStatement = connection.prepareStatement("DELETE FROM BOOKS WHERE BOOKID=?");

			preparedStatement.setInt(1, id);

			rows = preparedStatement.executeUpdate();

			return rows;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				4.Close
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rows;
	}
}