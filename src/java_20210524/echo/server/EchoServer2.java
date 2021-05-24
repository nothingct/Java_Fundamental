package java_20210524.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer2 {
	private int port;

	public EchoServer2(int port) {
		this.port = port;
	}
	public void run() {
		
		ServerSocket serverSocket= null;
		EchoServerThread est= null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		//1. ServerSocket 인스턴스 생성.
		try {
			serverSocket= new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[SERVER ]");
		while(true) {
			System.out.println("클라이언트 접속을 대기하고 있습니다 ....");
			try {
				//2. 클라이언트 접속을 기다린다.
				//accept() : 클라이언트 접속을 기다리다 클라이언트가 접속하면 
				Socket socket= serverSocket.accept();
				//Java 에서는 다중 클라이언트를 위한 서버를 구현하기 위해서는 Thread를 쓸수밖에없다.
				est = new EchoServerThread(socket);
				Thread t= new Thread(est);
				t.start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//이런 표현에 익숙해졌으면 좋겠어요..변수로 참조해서 재활용 할 일이 없으니 바로 그냥 생성자로 호출해서 작업처리
		new EchoServer2(3000).run();
//		EchoServer echoServer  = new EchoServer(3000);
//		echoServer.run(); /// 재사용할 일이 적어도 2번이상이어야는데 한번밖에 안쓰자나.
		
	}
}
