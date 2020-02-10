package chapter04;

public class StringTest04 {

	public static void main(String[] args) {
		String s = "aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc", 3)); // 찾을 string, 시작위치
		System.out.println(s.indexOf("abc", 7));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3, 5));
		
		String s2 = "   ab cd    ";
		String s3 = "dfg,hij,klm,nop";
		String s4 = s2.concat(s3);
		
		System.out.println(s2);
		System.out.println("-----" + s2.trim() + "------");  // 스페이스를 없애는데 문자 중간은 제외, 로그인/회원가입에서 주로 사용
		System.out.println("-----" + s2.replace(" ", "") + "------");
		
		String[] tokens = s3.split(","); // 없으면 오리지널 문자 출력
		for(String str : tokens) {
			System.out.println(str);
		}
		
		//String str = "Hello" + "World" + "Java" + 1000;
		String str = new StringBuffer("Hello").append("World").append("Java").append(1000).toString();
		System.out.println(str);
		
		// 주의: + 문자열 연산
		String str2 = "";
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < 100000; i++) {
			//str2 = str2 + i;
			sb.append(i); // + 연산에 비해 buffer 속도가 빠름
		}
		
		System.out.println(sb.length());
		
		// format
		String name = "둘리";
		int score = 100;
		
		System.out.println(name + "님 점수는 " + score + "점 입니다.");
		String str3 = String.format("%s님 점수는 %d점 입니다.", name, score);
		System.out.println(str3);

	}

}
