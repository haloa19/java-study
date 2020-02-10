package chapter03;

public class Student extends Person {
	public Student() {
		super(); // 자식생성자에서 부모 기본 생성자를 명시적 호출하지 않으면 부모의 기본 생성자를 자동 호출
		System.out.println("Student() called");
	}

}
