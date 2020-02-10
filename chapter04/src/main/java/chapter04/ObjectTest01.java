package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point p = new Point(10, 20);
		
		// Class klass = p.getClass(); // reflection		
		System.out.println(p.getClass()); 
		System.out.println(p.hashCode()); // reference value X, address X, address 기반의 해싱값(int) : 객체의 유일한 값
		// 같은 결과
		System.out.println(p);
		System.out.println(p.toString()); // getClass() + "@" + hashCode()

	}

}
