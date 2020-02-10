package chapter03;

import mypackage.Goods;

public class GoodsApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Goods(); // 객체만 생성하고 저장값이 없어서 사라짐
		Goods goods = new Goods();
		/*
		//public 접근 제한 없음
		goods.name = "nikon";
		
		// default 같은 패지에서만 가능
		goods.countSold = 100;
		
		// private 같은 
		goods.countStock = 50;
		goods.price = 1000000;
		
		System.out.println(goods.name + ":" + goods.price + ":" + goods.countSold + ":" + goods.countStock);

		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		System.out.println(Goods.countOfGoods); */
	}

}
