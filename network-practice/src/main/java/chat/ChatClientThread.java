package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatClientThread extends Thread {
	private Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// 4. IOStream 생성 받아오기 - 스트링을 그대로 사용 + 엔코딩 + 개행, 채팅구현 시 메시지 위주이므로 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
						
			while(true) {			
				// 5. 데이터 읽기
				String data = br.readLine();
				
				if(data == null) {
					ChatClient.log("closed by server");
					break;
				}
				ChatClient.log(data);

			}
		} catch(SocketException e) {
			ChatClient.log ("sudden closed by client");
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
