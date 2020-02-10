package prob3;

public class Duck extends Bird {
	public String name;
	
	@Override
	protected void setName(String name) {
		this.name = name;
		System.out.println("오리의 이름은 " + name + " 입니다.");		
	}
	
	@Override
	protected void fly() {
		System.out.println("오리(" + name + ")는 날지 않습니다");
		
	}
	
	@Override
	protected void sing() {
		System.out.println("오리(" + name + ")가 소리내어 웁니다.");
		
	}

}
