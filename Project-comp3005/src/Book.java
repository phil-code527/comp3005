
public class Book {
	String ISBN;
	String title;
	String author;
	double price;
	int pages;
	String genre;
	
	public Book() {
		
	}
	
	public Book(String ISBN, String title, String author, double price, int pages) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
		this.price = price;
		this.pages = pages;
		this.genre = genre;
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAuthor() {
		return this.author;
	}
	public double getPrice() {
		return this.price;
	}
	public int getPages() {
		return this.pages;
	}
	public String getGenre() {
		return this.genre;
	}
	
	
}
