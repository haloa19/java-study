package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

// 일단 1번 실행 나중에 여러번 실행
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Random r = new Random();
		int k = r.nextInt(100) + 1;
		int cnt = 1;
		int start = 1;
		int end = 100;
		
		System.out.println("수를 결정하였습니다. 맞춰보세요");
		
		do {
			System.out.println(start + "-" + end);
			System.out.print(cnt + ">>");
			int tmp = scanner.nextInt();
			
			if (tmp > k) {
				System.out.println("더 낮게");
				end = tmp;
				cnt++;
			} else if (tmp < k) {
				System.out.println("더 높게");
				start = tmp;
				cnt++;
			} else {
				System.out.println("맞았습니다.");
				System.out.print("계속하시겠습니까(y/n)>>");
				String answer = scanner.next();
				if (answer.equals("y")) {
					r = new Random();
					k = r.nextInt(100) + 1;
					cnt = 1;
					start = 1;
					end = 100;
				} else {
					break;
				}
				
			}
			
		} while (true);
		
	}
}
