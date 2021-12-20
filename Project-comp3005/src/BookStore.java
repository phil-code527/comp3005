import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.Arrays;

public class BookStore {
	
	User user;
	Owner owner;
	Book book;

	static String url = "jdbc:mysql://localhost:3306/bookstore";
	static String userName = "philberhane";
	static String password = "Catemari#22";
	

	
	public static void main(String[] args){
		
		//create bookstore owner
		/*
		Owner owner1 = new Owner("99999","John","sheppared st",0);
		owner1.addOwner(owner1);														//add owner to owner database
		*/
		//create users
		
		User user1 = new User("10001","Dave","Bloor St","9872658167","Bloor St");
		//user1.addUser(user1);															//add user to user database
		//user1.registerUser("99999","10001");											//add user to register database
		User user2 = new User("10002","James","oshawa st","5256251378","oshawa st");
		//user2.addUser(user2);
		//user2.registerUser("99999","10002");
		User user3 = new User("10003","Noha","kennedy st","8676253749","kennedy st");
		//user3.addUser(user3);
		
		
		String comedy = "Comedy";
		String adventure = "Adventure";
		String horror = "Horror";
		/*user browses for a book by genre and then orders it*/
		Book selectedBook = user1.browseBooks(horror);
		user1.order(2003, user1, selectedBook);
	}
}
