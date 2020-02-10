package prob3;

public class CurrencyConverter {
	private static double rate;

	public static void setRate(double r) {
		rate = r;
	}

	public static double toDollar(int i) {
		
		return i / rate;
	}

	public static double toKRW(int i) {
		
		return i * rate;
	}
	
}
