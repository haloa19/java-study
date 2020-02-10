package prob5;

public class MyStack extends MyStackException {
	private int top = 0;
	private String[] buffer = new String[3];
	private String[] buffer2;
	public int size;
	
	public MyStack(int size) {
		this.size = size;
	}

	public void push(String string) {
		//buffer = new String[size];
		if(top < size) {
			buffer[top] = string;
			//System.out.println(buffer[top]);
			top++;
		} else {
			buffer2 = buffer;
			buffer = new String[top+1];
			
			//System.out.println(top + " " + size);

			for (int i = 0; i < top; i++) {
				buffer[i] = buffer2[i];
			}
			buffer[top] = string;
			top++;
			//System.out.println(buffer[top]);
		}	
		
	}

	public boolean isEmpty() {
		if (buffer.length > 0 && top > 0) {
			return false;
		} else {
			return true;
		}
		
	}

	public String pop() throws MyStackException {
		//System.out.println(top);
		top--;
		if (top < 0) {
			throw new MyStackException();
		} else {
			return buffer[top];
		}
		
		
	}
	
}