package exceptioon;

public class UncheckedException {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};

		// unchecked : 런타임때 오류 발견
		for(int i = 0; i <= a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
