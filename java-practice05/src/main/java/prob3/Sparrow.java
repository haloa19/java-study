package prob3;

public class Sparrow extends Bird {
	public String name;

	@Override
	protected void setName(String name) {
		this.name = name;
		System.out.println("참새의 이름은 " + name + " 입니다.");
		
	}

	@Override
	protected void fly() {
		System.out.println("참새(" + name + ")가 날아다닙니다.");
		
	}

	@Override
	protected void sing() {
		System.out.println("참새(" + name + ")가 소리내어 웁니다.");
		
	}

}
