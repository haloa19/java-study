package chapter03;

public class Goods2 {
	private String name;
	private int price;
	private int countSold;
	private int countStock;
	
	// 생성자를 직접 생성하면 기본생성자가 생성되지 않음
	public Goods2(String name, int price, int countSold, int countStock) {
		this.name = name;
		this.price = price;
		this.countSold = countSold;
		this.countStock = countStock;
	}
	
	public Goods2() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price < 0) {
			price = 0;
		}
		this.price = price; // 지역변수가 순위높아서 this생략 시 int a = 10; a = a;의미를 갖음
		                    // this.price 자기자신, price는 지역변수
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void showInfo() {
		System.out.println(this.name + ":" + price + ":" + countStock + ":" + countSold);
	}
	public int calcDiscountPrice(double discountRate) {
		
		return (int)(price - price * discountRate);
	}
	

}
