package exceptioon;

public class MyException extends Exception{

	private static final long serialVersionUID = 1L;

	public MyException() {
		super("My Exception Occurs");
	}
	
	public MyException(String message) {
		super(message);
	}

}
