package prob01;

public class Printer{
	// 오버로드 문제

	public void println(int a) {
		System.out.println(a);
	}
	public void println(boolean a) {
		System.out.println(a);
	}
	public void println(double a) {
		System.out.println(a);
	}
	public void println(String a) {
		System.out.println(a);
	}
	public void println(int i, int j, int k, int l, int m, String string, StringBuffer stringBuffer) {
		System.out.println(i + " " + j + " " + k + " " + l + " " + m + " " + string + " " + stringBuffer);		
	}
}
