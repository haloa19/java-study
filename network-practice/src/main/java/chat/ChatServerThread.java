package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import echo.EchoServer;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName=null;
	private List<Writer> listWriters;

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();  // remoteAddress 뽑아내기, 클라이언트 주소
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();	
		ChatServer.log("connected by server[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			// 4. IOStream 생성 받아오기 - 스트링을 그대로 사용 + 엔코딩 + 개행, 채팅구현 시 메시지 위주이므로 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);  // 버퍼가 차지 않았는데 바로 전송하도록 하기위해 true or flush()
			
			while(true) {			
				// 5. 데이터 읽기
				String data = br.readLine();
				
				if(data == null) {
					ChatServer.log("closed by client");
					break;
				}
				ChatServer.log(data);
				
				
				String[] proto = data.split(":");
				
				if("join".equals(proto[0])) {
					chatJoin(proto[1], pw);
				} else if("msg".equals(proto[0])) {
					chatMsg(proto[1], pw);
				} else if("quit".equals(proto[0])) {
					chatQuit(pw);
				} else {
					ChatServer.log("잘못된 입력입니다.");
				}

			}
		} catch(SocketException e) {
			String outMessage = this.nickName + "님이 나갔습니다.";
			boradCast(outMessage);
			ChatServer.log ("sudden closed by client");
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

	private void chatJoin(String nickName, Writer writer) {
		this.nickName = nickName;
		String data = nickName + "님이 들어왔습니다.";
		System.out.println(data);
		boradCast(data);	
		addWriter(writer);
	}
	
	private void boradCast(String data) {
		synchronized(listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void addWriter(Writer Writer) {
		synchronized(listWriters) {
			listWriters.add(Writer);
		}
		
	}

	private void chatMsg(String data, Writer writer) {
		boradCast(nickName + ": " + data);	

	}
	
	private void chatQuit(Writer writer) {
		String data = this.nickName + "님이 퇴장했습니다";
		boradCast(data);

		return;
	}
	
}
