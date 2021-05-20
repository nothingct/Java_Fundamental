package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class InputStreamReaderDemo {
	//코드간결하려고 그냥 예외를  던짐.
	public static void main(String[] args) throws IOException {
		/*
		//source 가 키보드인 경우. (표준 입력 장치 = 키보드)
		InputStream in = System.in; 
		byte[] b = new byte[100];
		//키보드의 입력값을 기다림.=>Enter를 치기 전까지는 대기
		int readByteCount =0;
		System.out.print("입력하세요>");
		while( (readByteCount = in.read(b)) != -1) {
			String msg = new String(b,0,readByteCount);
			//개행문자 가 엔터를 치는순간 msg에 같이 들어가므로 이를 제거해주기위해 trim()이 필요하다. 
			if(msg.trim().equals("quit") && msg!=null) break;
			System.out.print(msg);			
			System.out.print("입력하세요>");
		}
		*/
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		FileWriter fw = new FileWriter("C:\\users\\user\\message.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw,true);
		
		String readLine = null;
		System.out.print("입력하세요>(종료는 quit)");
		while( (readLine=br.readLine())!=null) {
			if(readLine != null && readLine.equals("quit")) break;
			System.out.println(readLine);
			pw.println(readLine);
			System.out.print("입력하세요>(종료는 quit)");
		}
	}
}
