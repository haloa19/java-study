package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import chat.client.win.ChatWindow;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 7000;  // 포트는 중복될 수 없음
	Socket socket;
	static String name;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		
		try {
			// 1. Scanner 생성(표준입력, 키보드 연결)
			scanner = new Scanner(System.in);
			
			// 2. Socket 생성
			socket = new Socket();			
			
			// 3. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT)); // 상대편 주소
			System.out.println("connected");
			
			// 4. IOStream 생성(받아오기)
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); 
			
			System.out.println("대화명을 입력하세요.");
			System.out.print("닉네임 > ");
			name = scanner.nextLine();
			
			if (name.length() <= 0) {
				return;
			} else {
				// socket과 name 서버로 전송
				String tmp = "join:" + name;
				pw.println(tmp);
			}
			new ChatClientThread(socket).start();
	
			
			while(true) {
				
				// 5. 데이터
				System.out.print(">> ");
				String line = scanner.nextLine();
				
				if("quit".equals(line)) {
					pw.println("quit:" + line);
					socket.close();
					break;
				}
				
				// 6. 데이터 쓰기
				pw.println("msg:" + line);

			}
		} catch(IOException e) {
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
		System.out.println("[client#" + Thread.currentThread().getId() + "]" + log);
	}

}
