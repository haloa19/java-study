package chat.client.win2;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 7000; 
	Socket socket;
	static String name;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			
			// 1. socket 생성
			socket = new Socket();
			
			// 2. connect to server		
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); // 상대편 주소
			log("connected");
			
			// 3. iostream 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); 		
			
			// 4. join 프로토콜 요청 및 처리
			while(true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();
				if(name.contains(" ")) {
					System.out.println("공백 사용 불가");
				} else {
					break;
				}
			}

			
			if (name.length() <= 0) {
				return;
			} else {
				// socket과 name 서버로 전송
				String tmp = "join:" + name;
				pw.println(tmp);
				
			}
			// 5. join 프로토콜이 성공 응답을 받으면 new ChatWindow(name, socket).show(); 실행 	
			new ChatWindow(name, socket).show();
			
			while( true ) {
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(scanner != null) {
					scanner.close();
				}
				
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}	

	}
	
	public static void log(String log) {
		System.out.println("[client]" + log);
	}

}
