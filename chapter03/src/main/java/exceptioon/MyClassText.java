package exceptioon;

import java.io.IOException;

public class MyClassText {

	public static void main(String[] args) {
		MyClass myClass = new MyClass();
		try {
			myClass.danger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
