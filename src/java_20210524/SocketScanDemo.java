package java_20210524;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketScanDemo {
	public static void main(String[] args) {
		Socket socket = null;
		//port : 1번 ~1024 번 port까지 돌면서 열려있는 port 확인.
		for(int port=1; port<=1024; port++) {
			//127.0.0.1 : localhost 주소
			try {
				//Socket 객체가 생성되었다는 의미는 host, port 로 
				//통신할 수 있다는 것이고, 이는 해당 host 에 port 번호를 
				//사용하고 있다는 것임.
				socket = new Socket("127.0.0.1",port);
				System.out.println(port+"번호 port를 사용하고 있습니다.");
			} catch (UnknownHostException e) {
				System.err.println("호스트가 존재하지 않는다.");
			} catch (IOException e) {
				System.err.println(port+"번호 port를 사용하지 않고있습니다.");
			}
		}
	}
}
