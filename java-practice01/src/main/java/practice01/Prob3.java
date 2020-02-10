package practice01;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int number = scanner.nextInt();
		int sum = 0;
		
		if (number % 2 == 0) {
			for (int i = 1; i <= number; i++) {
				sum = (i % 2 == 0) ? sum + i : sum;
			}
		} else {
			for (int i = 1; i <= number; i++) {
				sum = (i % 2 != 0) ? sum + i : sum;
			}
		}

		System.out.print("결과 값 : " + sum);
	}
}
