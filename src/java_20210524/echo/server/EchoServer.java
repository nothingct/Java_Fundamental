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

public class EchoServer {
	private int port;

	public EchoServer(int port) {
		this.port = port;
	}
	public void run() {
		ServerSocket serverSocket= null;
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
				//4 클라이언트 통신을 할 수 있는 Socket 객체가 생성된다.
				InetAddress i = socket.getInetAddress();
				InputStream in = socket.getInputStream();
				ir= new InputStreamReader(in);
				br = new BufferedReader(ir);
				
				OutputStream out = socket.getOutputStream();
				ow = new OutputStreamWriter(out);
				bw= new BufferedWriter(ow);
				System.out.printf("클라이언트가 접속 했습니다. [%s]%n",i.getHostAddress());
				//5. Socket 을 이용해서 클라이언트와 통신할 수 있는 입출력 스트림을 생성
				while(true) {
					//6-2
					String readLine = br.readLine();
					System.out.println(readLine);
					//6-3
					bw.write(readLine);
					bw.newLine();
					bw.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//이런 표현에 익숙해졌으면 좋겠어요..변수로 참조해서 재활용 할 일이 없으니 바로 그냥 생성자로 호출해서 작업처리
		new EchoServer(3000).run();
//		EchoServer echoServer  = new EchoServer(3000);
//		echoServer.run(); /// 재사용할 일이 적어도 2번이상이어야는데 한번밖에 안쓰자나.
		
	}
}
