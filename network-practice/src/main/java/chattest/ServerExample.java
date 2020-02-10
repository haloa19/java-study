package chattest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
	private static final int PORT = 8000;
	ExecutorService executorService;
	ServerSocket serverSocket;
	
	List<Client> connections = new Vector<Client>();
	
	void startServer() {
		executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		
		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩 (Socket Address(IP Address + Port) binding)
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			
			
		} catch (Exception e) {
			if(!serverSocket.isClosed()) {
				stopServer();
				return;
			}
		}
	}
	
	void stopServer() {
		
	}

}
