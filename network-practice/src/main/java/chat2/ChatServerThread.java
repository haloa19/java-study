package chat2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;


public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickName = null;
	private List<Writer> listWriters;
	HashMap<String, PrintWriter> map;
	PrintWriter pw;

	public ChatServerThread(Socket socket, List<Writer> listWriters, HashMap<String, PrintWriter> map) {
		this.socket = socket;
		this.listWriters = listWriters;
		this.map = map;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();		
		
		ChatServer.log("connected by server[" + remoteHostAddress + ":" + remotePort + "]");
		
		try {
			// 4. IOStream 생성 받아오기 - 스트링을 그대로 사용 + 엔코딩 + 개행, 채팅구현 시 메시지 위주이므로 
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
			
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
					if(data.length() < 5) {
						chatMsg(" ");
					} else {
						chatMsg(proto[1]);
					}
				} else if("/to".equals(proto[0])) {
					if(data.length() == 3) {
						PrintWriter printWriter = map.get(nickName);
						printWriter.println("(전송실패)잘못된 입력입니다.");
					} else {
						chatTo(proto[1], proto[2], pw);
					}
				} else if("/quit".equals(proto[0])) {
					chatQuit();
				} else {
					ChatServer.log("잘못된 입력입니다.");
				}
			}
		} catch(SocketException e) {
			/* 사용자의 채팅창이 닫힌 경우  */
			String outMessage = ">>>>>" + this.nickName + "님의 연결이 끊겼습니다.<<<<<";
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

	/* 사용자가 입장한 경우 */
	private void chatJoin(String nickName, Writer writer) {
		this.nickName = nickName;
		String data = "<<<<<" + nickName + "님이 들어왔습니다.>>>>>";
		boradCast(data);	
		addWriter(writer);
		map.put(nickName, pw);
	}
	
	/* 전체 사용자에게 메시지를 보낸 경우 */
	private void chatMsg(String data) {
		boradCast(nickName + ": " + data);	
	}
	
	/* 귀속말 기능을 사용하여 메시지를 보낸 경우 */
	private void chatTo(String name, String data, Writer writer) {
		PrintWriter printWriter = map.get(name);
		PrintWriter printWriter2 = map.get(nickName);
		if(printWriter != null) {
			printWriter.println("[" + nickName + "님이 보낸 귀속말 메시지] : " + data);
			printWriter2.println("[" + name + "님에게 보낸 귀속말 메시지] : " + data);
		} else {
			printWriter2.println("(전송실패)" + name + "님은 채팅방에 없습니다.");
		}
	}
	
	/* 사용자가 '/quit'명령을 통해 나간 경우 */
	private void chatQuit() {
		boradCast(">>>>>" + nickName + "님이 나갔습니다.<<<<<");
	}
	
	/* 메시지 브로드케스트 처리 */
	private void boradCast(String data) {		
		synchronized(map) {
			for(Writer writer : map.values()) {
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
	
}
