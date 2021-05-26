package java_20210524.echo.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
	private String ip;
	private int port;
	public EchoClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}
	public String console(String msg) {
		System.out.println(msg);
		//키보드로 입력받는 정형적인 코드
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
				
	}
	public void run() {
		Socket socket = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		
		try {
			//3. ip와 port로 서버에 접속을 시작한다.
			socket= new Socket(ip,port);
			//Serer와 접속이 되었음.
			System.out.println("서버와의 접속이 성공했습니다");
			//6. Socket 을 이용해서 서버와 통신할 수 있는 입출력 스트림 생성
			InputStream in = socket.getInputStream();
			ir= new InputStreamReader(in);
			br = new BufferedReader(ir);

			OutputStream out = socket.getOutputStream();
			ow = new OutputStreamWriter(out);
			bw = new BufferedWriter(ow);
			while(true) {
				//6-1			
				String message = console("메시지>");
				bw.write(message);
				bw.newLine();
				bw.flush();
				//6-4
				String readLine = br.readLine();
				System.out.println(readLine);
			}
		} catch (IOException e) {
			System.err.println("서버와의 접속에 실패하였습니다.");
		}
		
	}
	public static void main(String[] args) {
		new EchoClient("192.168.0.28", 3000).run();
	}
	
}
