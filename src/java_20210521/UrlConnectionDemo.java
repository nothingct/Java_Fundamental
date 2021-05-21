package java_20210521;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionDemo {
	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.naver.com");
		URLConnection urlCon = url.openConnection();
		urlCon.connect();
		//서버헤더 정보 가져올수 있음. ( url은 결과 url 자원만 가능 ) 
		String cacheControl = urlCon.getHeaderField("cache-control");
		String contentType = urlCon.getHeaderField("content-type");
		String date = urlCon.getHeaderField("date");
		System.out.println("cache-control : "+cacheControl);
		System.out.println("contentType : "+ contentType);
		System.out.println("date : " +date);
		//urlCon 도 url 자원을 얻을수 있음.
		InputStream in = urlCon.getInputStream();
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
