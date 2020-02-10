package practice02;

import java.util.Scanner;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		System.out.println("5개의 숫자를 입력하세요.");
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = scanner.nextInt();
		}
		
		for (int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}
		
		System.out.print("평균은 " + sum / intArray.length + " 입니다.");
			
	}

}
