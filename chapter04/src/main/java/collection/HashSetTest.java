package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		
		String s1 = new String("또치");
		String s2 = new String("또치");
		String s3 = "또치";
		
		System.out.println(s1 == s2);
		
		s.add("둘리");
		s.add("마이콜");
		s.add(s3);
		
		System.out.println(s.contains(s3)); //동질성 체크, 객체 자체가 아니라 객체의 내용으로 파악
		System.out.println(s.size());
		
		// 순회
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
 
	}

}
