package java_20210521;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=100&oid=023&aid=0003615347#content");
		String protocol = url.getProtocol();
		String host = url.getHost();
		//포트가 없으면 -1을 반환함. 
		int port = url.getPort();
		String path = url.getPath();
		String query = url.getQuery();
		String ref = url.getRef();
		
		System.out.println("protocol : "+protocol);
		System.out.println("host : "+host);
		System.out.println("port : "+port);
		System.out.println("path : "+path);
		System.out.println("query : "+query);
		System.out.println("ref : "+ref);
		//src=>img 인 경우
		url = new URL("https://imgnews.pstatic.net/image/023/2021/05/21/0003615347_001_20210521103418682.jpg?type=w647");
		InputStream in =url.openStream();
		
		int readByteCount =0; 
		byte[] readByte= new byte[1024*10];
		FileOutputStream fos = new FileOutputStream("C:\\users\\user\\test.jpg");
		while( (readByteCount = in.read(readByte)) != -1) {
			fos.write(readByte, 0, readByteCount);
		}
		fos.close();
		url = new URL("https://www.tistory.com/");
		in = url.openStream();
		InputStreamReader ir = new InputStreamReader(in,"utf-8");
		BufferedReader br = new BufferedReader(ir);
		
		FileWriter fw = new FileWriter("C:\\users\\user\\test.html");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String readLine = null;
		while( (readLine = br.readLine())!=null) {
			bw.write(readLine);
			bw.newLine();
			System.out.println(readLine);
		}
		bw.flush();
	}
}
