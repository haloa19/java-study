package chapter03;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		int[] a1 = {10, 20, 30, 40, 50};
		
		//ArrayUtils au = new ArrayUtils();
        //double[] d1 = new ArrayUtils().intToDouble(a1);
        
		double[] d1 = ArrayUtils.intToDouble(a1); // 객체의 데이터가 있는지 여부, 사용하는지에 따라 static
		
        for(int i = 0; i < d1.length; i++) {
        	System.out.print(d1[i] + " ");
        }

	}

}
