package java_20210520;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//기본적인 문자 파일 복사 프로그램 . 
public class FileReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr =  null;
		FileWriter fw = null;
		
		try {
			fr= new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
			fw= new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemoCopy.java");
			
			/*
			int readChar;
			//read() : 한 개의 문자를 읽는다. 
			while( (readChar = fr.read()) != -1) {
				//write() : 한 개의 문자를 쓴다. 
				fw.write(readChar);
				System.out.print((char)readChar);
			}
			*/
			//문자 읽고 쓰는 것도, 이 코드 구조가 제일 빠르다 ( Binary 읽기/쓰기 와 동일)
			int readCharCount = 0;
			char[] readChars =new char[1025*8];
			while( (readCharCount = fr.read(readChars)) != -1) {
				fw.write(readChars, 0, readCharCount);
				System.out.println(readChars);

			}
			
		} catch (FileNotFoundException e) { //<-- IOException 이 부모 클래스이므로, 에러에 대한 처리를 따로 해주는게 아나라면 이에 대한 catch 문 안써도 된다.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(fr!=null) fr.close();
					if(fw!=null) fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
