package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();  // remoteAddress 뽑아내기, 클라이언트 주소
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();	
		EchoServer.log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			// 4. IOStream 생성 받아오기 - 스트링을 그대로 사용 + 엔코딩 + 개행, 채팅구현 시 메시지 위주이므로 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);  // 버퍼가 차지 않았는데 바로 전송하도록 하기위해 true or flush()
			
			while(true) {			
				// 5. 데이터 읽기
				String data = br.readLine();
				
				if(data ==null) {
					EchoServer.log("closed by client");
					break;
				}
				EchoServer.log("received : " + data);
				
				// 6. 데이터 쓰기
				pw.println(data);

			}
		} catch(SocketException e) {
			EchoServer.log ("sudden closed by client");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
