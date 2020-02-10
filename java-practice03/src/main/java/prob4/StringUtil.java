package prob4;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String answer = "";
		
		for(String tmp : strArr) {
			answer += tmp;
		}
		
		return answer;
	}
}
