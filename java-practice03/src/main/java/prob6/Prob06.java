package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		while( true ) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if(expr.equals("quit")) {
				break;
			}
			
			String[] tokens = expr.split(" ");
			
			if(tokens.length != 3) {
				System.out.println(">> 계산 불가 연산입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			
			if(tokens[1].equals("+")) {
				Add add = new Add();
				add.setValue(lValue, rValue);
				result = add.calculate();
			} else if(tokens[1].equals("-")) {
				Sub sub = new Sub();
				sub.setValue(lValue, rValue);
				result = sub.calculate();
			} else if(tokens[1].equals("*")) {
				Mul mul = new Mul();
				mul.setValue(lValue, rValue);
				result = mul.calculate();
			} else if(tokens[1].equals("/")) {
				Div div = new Div();
				div.setValue(lValue, rValue);
				result = div.calculate();
			}
			
			System.out.println(">> " + result);

		}
		
		scanner.close();
	}

}
