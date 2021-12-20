import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Owner {

	String id;
	String name;
	String store_address;
	int totalSales = 0;
	
	static String url = "jdbc:mysql://localhost:3306/bookstore";
	static String userName = "philberhane";
	static String password = "Catemari#22";
	
	public Owner(String id, String name, String address, int totalSales) {
		this.id = id;
		this.name = name;
		this.store_address = address;
		this.totalSales = totalSales;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.store_address;
	}
	public int getTotalSales() {
		return this.totalSales;
	}
	
	
	public static void addOwner(Owner owner) {
		String query = "insert into owner value ('"+owner.getId()+ "',"+"'"+owner.getName()+"',"+"'"+owner.getAddress()+ "',"+"'"+owner.getTotalSales()+"')";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		try {
			Connection conn = DriverManager.getConnection(url, userName, password);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		}catch (SQLException e){
			System.out.println(e);
		}
	}
	 
}
