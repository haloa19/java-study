package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String str = scanner.nextLine();
		
		for (int i = 1; i <= str.length(); i++) {
			String tmp = str.substring(0, i);
			System.out.println(tmp);
		}
		
		scanner.close();
	}

}
