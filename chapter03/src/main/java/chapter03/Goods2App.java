package chapter03;

public class Goods2App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goods2 goods = new Goods2();
		
		goods.setName("nikon");
		goods.setPrice(-100); // 값 보호
		goods.setCountSold(50);
		goods.setCountStock(100);
		
		goods.showInfo();
		
		int price = goods.calcDiscountPrice(0.5);
		System.out.println(price);
		//System.out.println(goods.getName() + ":" + goods.getPrice() + ":" + goods.getCountSold() + ":" + goods.getCountStock());
		
		Goods2 goods2 = new Goods2("TV", 10000, 20, 50);
		goods2.showInfo();

	}

}
