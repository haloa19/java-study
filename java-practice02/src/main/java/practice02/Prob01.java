package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");
		int money = scanner.nextInt();
		int[] answer = new int[MONEYS.length];
		
		for (int i = 0; i < MONEYS.length; i++) {
			answer[i] = money / MONEYS[i];
			money %= MONEYS[i];
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(MONEYS[i] + "원 : " + answer[i] + "개");
			System.out.println();
		}
		
		scanner.close();
	}

}
