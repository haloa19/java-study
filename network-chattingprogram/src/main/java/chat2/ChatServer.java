package chat2;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatServer {
	private static final int PORT = 7000;
	private static List<Writer> listWriters = new ArrayList<Writer>();
	static HashMap<String, PrintWriter> map;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩 (Socket Address(IP Address + Port) binding)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Server starts...[port:" + PORT + "]");		
			map = new HashMap<String, PrintWriter>();
			
			// 3. accept - blocking 상태
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters, map).start();
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}				
			} catch (IOException e) {			
				e.printStackTrace();
			}
			
		}

	}
	
	public static void log(String log) {
		System.out.println("[server#" + Thread.currentThread().getId() + "]" + log);
	}

}
