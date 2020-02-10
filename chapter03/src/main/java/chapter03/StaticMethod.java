package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(m);
		System.out.println(StaticMethod.m);  // 원칙이지만 같은 클래스의 클래스변수 접근에서는 클래스 이름 생략 가능
	}
	
	void f3() {
		StaticMethod.s1(); // 원칙이지만 같은 클래스의 클래스변수 접근에서는 클래스 이름 생략 가능
		s1();
	}
	
	static void s1() {
		//오류 : static method에서 인스턴스 변수 접근 불가
		//System.out.println(n);  
	}
	
	static void s2() {
		System.out.println(m);
		System.out.println(StaticMethod.m);  // 원칙이지만 같은 클래스의 클래스변수 접근에서는 클래스 이름 생략 가능
	}
	
	static void s3() {
		//f1(); 
		// static method는 인스턴스 메소드 접근 불가
	} 
	
	static void s4() {
		StaticMethod.s1(); // 같은 클래스 내에서는 클래스명없이 사용 가능
		s1();
	}
	

}
