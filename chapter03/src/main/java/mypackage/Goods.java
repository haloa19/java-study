package mypackage;

public class Goods {
	static int countOfGoods;
	
	public Goods() {
		Goods.countOfGoods += 1;  // 같은 클래스 안에서 static접근 시 Goods생략 가능 (의미적으로는 붙이는게 맞음)
	}
	
	public String name; // 모든 접근 가능 (제한이 없음)
	protected int price; // 같은 패키지 + 자식 접근 가능
	int countSold; // 같은 패키지
	private int countStock; // 하나의 클래스에서만 가능

}
