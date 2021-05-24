package java_20210524;

import java.io.IOException;
import java.net.ServerSocket;

public class SErverSocketScan {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		for(int port =1 ; port <65536; port++) {
			try {
				//ServerSocket 클래스는 해당 서버의 port 번호를 사용할 수 있으면 
				//ServerSocket 인스턴스를 생성할 수 있고, 그렇지않으면, 예외가 발생
				//=> 해당 port를 이미 사용하고 있다는 것을 의미
				serverSocket = new ServerSocket(port);
			} catch (IOException e) {
				System.err.println(port+"번호를 사용할 수 없습니다.");
			}
		}
		//확인 결과 : 우리가 3000번 포트를 사용해서 채팅 프로그램을 만들 수 있음을 확인함. 
	}
}
