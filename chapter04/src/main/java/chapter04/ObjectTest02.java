package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		Point p1 = new Point(10, 20);
		Point p2 = new Point(10, 20);
		Point p3 = p2;
		
		// 1. == : 두 객체의 동일성 비교
		System.out.println(p1 == p2);
		System.out.println(p2 == p3);
		
		// 2. equals : 두 객체의 동질성 비교
		// 			 : Object의 기본 구현은 동일성 비교와 같음 -> 해시코드와 equlas 오버라이드를 통해 동질성 비교 가능
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));
		
		// 비교 순서 : hashCode -> equals

	}

}
