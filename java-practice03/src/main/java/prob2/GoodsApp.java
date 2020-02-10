package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];  // 객체를 만든것이 아니라 배열을 생성한 것 뿐
		
		for (int i = 0; i < 3; i++) {
			goods[i] = new Goods();  		 // 2번째 인덱스에 객체 생성
			String tmp = scanner.nextLine();
			goods[i].setInfo(tmp);
		}		
		
		for (int i = 0; i < 3; i++) {
			goods[i].getInfo();
		}

		scanner.close();
	}
}
