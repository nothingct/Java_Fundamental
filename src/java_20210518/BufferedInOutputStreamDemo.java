package java_20210518;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class BufferedInOutputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			//FileInputStream, FileOutputStream 생성
			fis = new FileInputStream("C:\\dev\\test\\2021\\05\\18\\apache.zip");
			fos = new FileOutputStream("C:\\dev\\test\\2021\\05\\18\\apache_copy.zip");
			
			/******************************
			 * 1 byte 로 읽고 쓰기 
			******************************/
			
			/*
			int readbyte = 0; 
			long start = System.currentTimeMillis();
			while( (readbyte = fis.read()) != -1){
				fos.write(readbyte);
			}
			
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n",end-start);
			//경과시간 : 41초
			*/ 
			
			
			/*******************************
			 * byte 배열로 읽고 쓰기
			 *********************************/
			/*
			byte[] readBytes = new byte[1024*100];
			int readBytescount =0;
			long start = System.currentTimeMillis();
			while( (readBytescount = fis.read(readBytes)) != -1){
				fos.write(readBytes, 0, readBytescount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n",end-start);
			//경과시간 : 8ms
			*/
			
			/*************************************
			 * BufferedXXXStream 으로 읽고 쓰기
			 ***********************************/
			
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int readByte = 0;
			long start = System.currentTimeMillis();

			while( (readByte = bis.read()) != -1) {
				bos.write(readByte);
			}
			bos.flush(); //bufferedouputstream 의 내장 버퍼에 남아있는 값을 비운다.
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %d %n",end-start);
			//경과시간 : 321ms
			
			//결론: Binary 에 대한 IO는 배열형식으로 FileInputStream~FileOutputStream 입출력하는게 가장 빠르다.
			//	   Char 에 대한 Io 에서는 그래도 BufferedIn/OutStream을 사용해서 여전시 StreamChaining 을 한다.
			
			//StringBuffer : 멀티쓰레딩 할 때 안전함, 속도 느림 
			//StringBuilder : 멀티쓰레딩 할 떄 불안전, 속도 빠름
			//결론 : StringBuilder 를 더 많이 쓴다. 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null) fis.close();
				if(fos!=null) fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
