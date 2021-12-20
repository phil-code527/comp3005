import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.Arrays;

public class User {
	Book book;
	String id;
	String name;
	String address;
	String banking_card;
	String shipping_address;
	
	static String url = "jdbc:mysql://localhost:3306/bookstore";
	static String userName = "philberhane";
	static String password = "Catemari#22";
	
	
	public User(String id, String name, String address, String banking_card, String shipping_address) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.banking_card = banking_card;
		this.shipping_address = shipping_address;
	}
	
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getBanking_card() {
		return this.banking_card;
	}
	public String getShipping_address() {
		return this.shipping_address;
	}
	
	/*insert new user to bookstore database */
	public static void addUser(User user) {		
		String query = "insert into user value ('"+user.getId()+ "',"+"'"+user.getName()+"',"+"'"+user.getAddress()+"',"+"'"+user.getBanking_card()+"',"+"'"+user.getShipping_address()+"');";
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		}catch (SQLException e){
			System.out.println(e);
		}
	}
	
	/*register user in the bookstore database*/
	public static void registerUser(String givenOwner_id, String givenUser_id) {
		String query = "insert into register value ('"+givenOwner_id+"',"+"'"+givenUser_id+"');";
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		}catch (SQLException e){
			System.out.println(e);
		}
	}
	
	/* browse books in database by different genres*/
	public static Book browseBooks(String genre) {
		Book book = new Book();
		String query = "select * from book where genre='"+ genre + "'";
		String title = new String();
		String author = new String();
		String price = new String();
		String pages;
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);			
			while(result.next()) {
				book.ISBN = result.getString("ISBN");
				book.title = result.getString("title");
				title = result.getString("title");
				book.author = result.getString("author");
				author = result.getString("author");
				book.genre = result.getString("genre");
				price = result.getString("price");
				book.price = Double.parseDouble(price);
				pages = result.getString("pages");
				book.pages = Integer.valueOf(pages);
			}
			System.out.println("Title: "+title + " Author: "+author+" price: "+price);
			
		}catch (SQLException e){
			System.out.println(e);
		}
		return book;
	}
	
	/* A user orders a selected book from bookstore database*/
	public static void order(int orderId, User user, Book book) {
		/*check if user is registered in database first*/
		String query1 = "select user_id from register where user_id='"+user.getId()+"';";
		String exist = new String();
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query1);
			while(result.next()) {
				exist = result.getString("user_id");
			}
		}catch (SQLException e){
			System.out.println(e);
		}
		/*order can be made only if user is already registered */
		if(exist.compareTo(user.getId()) == 0) {
			String query2 = "insert into orders value ("+orderId+","+"'"+user.getId()+"',"+"'"+book.getISBN()+ "',"+"'"+book.getTitle()+"',"+"'"+user.getShipping_address()+"',"+"'"+user.getBanking_card()+"')";
			String query3 = "update owner set totalSales=totalSales + "+ book.getPrice()+";";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			}catch (ClassNotFoundException e) {
				System.out.println(e);
			}
			/*inserts book into orders database*/
			try {
				Connection conn = DriverManager.getConnection(url, userName, password);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(query2);
				stmt.executeUpdate(query3);
			}catch (SQLException e){
				System.out.println(e);
			}
		}else {
			System.out.println("user need to be registered first");
		}
		
	}
	

	
	
	
}
