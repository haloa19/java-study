package chattest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩 (Socket Address(IP Address + Port) binding)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Server starts...[port:" + PORT + "]");
			
			// 3. accept
			while(true) {
				Socket socket = serverSocket.accept(); // blocking, 서버 소켓
				new EchoServerReceiveThread(socket).start();
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
