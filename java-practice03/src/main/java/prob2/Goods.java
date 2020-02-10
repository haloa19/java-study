package prob2;

public class Goods {
	private String str;
	
	public void setInfo(String str) {
		this.str = str;
	}
	
	public void getInfo() {
		String[] tmp = str.split(" ");
		System.out.println(tmp[0] + "(가격:" + tmp[1] + "원)이 " + tmp[2] + "개 입고 되었습니다.");
	}
	
}
