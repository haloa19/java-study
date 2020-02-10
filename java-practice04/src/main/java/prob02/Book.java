package prob02;

public class Book {
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;
	
	public Book( int bookNo, String title, String author ) {
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}
	
	public int getBookNo() {
		return bookNo;
	}
	
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getStateCode() {
		return stateCode;
	}
	
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	
	public static void rent(Book[] books, int no) {
		books[no - 1].setStateCode(0);
		System.out.println(books[no - 1].title + "이(가) 대여 됐습니다.");
	}
	

	public static void displayBookInfo(Book[] books) {
		for(int i = 0; i < books.length; i++) {
			if(books[i].getStateCode() == 0) {
				System.out.println("책 제목:" + books[i].title + ", 작가:" + books[i].author + ", 대여유무:대여중");
			} else {
				System.out.println("책 제목:" + books[i].title + ", 작가:" + books[i].author + ", 대여유무:재고있음");
			}
		}
		
	}
	
}