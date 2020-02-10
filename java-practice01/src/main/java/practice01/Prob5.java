package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for( int i = 1; i <=100; i++ ) {
			
			String s = String.valueOf(i);
			int sum = 0;
			
			for (int j = 0; j < s.length(); j++) {
				sum = (s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') ? sum + 1 : sum;
			}
			
			if (sum > 0) {
				System.out.print(i);
				for (int j = 0; j < sum; j++) {
					System.out.print("짝");
				}
				System.out.println();
			}			
			
		}
	}
}
