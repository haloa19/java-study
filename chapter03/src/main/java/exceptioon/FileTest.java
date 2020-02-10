package exceptioon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileTest {
	
	// checked Exception : 예외처리 전까지 컴파일 자체가 불가, trycatch를 반드시 써야하기 때문에 블락이 생겨 가독성 저하
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("./hello.txt");
			int data = is.read();
			System.out.println(data);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch (IOException e) {
			return;
		} finally {
			// 자원정리
			try {
				if(is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
