package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();
		Thread thread2 = new AlphabetThread(); // 같은일을 객체로 만들어서 start하는 장점
		
		thread1.start();
		thread2.start();

	}

}
