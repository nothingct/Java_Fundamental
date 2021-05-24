package java_20210524.echo.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerThread implements Runnable {
	private Socket socket;

	@Override
	public void run() {
		
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;		
		//4 클라이언트 통신을 할 수 있는 Socket 객체가 생성된다.
		try {
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
		}catch (IOException e){
			System.err.println("클라이언트가 비정상적으로 종료하였습니다.");
		}
	}

	public EchoServerThread(Socket socket) {
		this.socket = socket;
	}

}
