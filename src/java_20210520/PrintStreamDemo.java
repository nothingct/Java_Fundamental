package java_20210520;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
//IO 는 try/catch 가 많아서 코드가 많지 실제로 어렵지는 않다. 실제로 중요한 코드는 그냥 통으로 암기 .
public class PrintStreamDemo {
	public static void main(String[] args) {
		//객체 선언
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		PrintStream ps = null; // Des : 파일
		PrintStream monitor = null; // Des : 모니터
		//객체 할당
		// PrintStream 용법 1: 표준출력장치에 연결하기
		monitor = System.out; // 모니터로 연결된 printStream. ==> 이제 System.out. 이렇게 할 필요 없이 monitor.으로 :가독성 코딩 쉬워짐.
		monitor.println("Hello");
		// PrintStream 용법 2 : File 에 연결하기
		try {
			fis = new FileInputStream("C:\\dev\\test\\2021\\05\\18\\apache.zip");
			/// stream chaining :fis-> bis
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("C:\\dev\\test\\2021\\05\\18\\apache_copy.zip");
			bos = new BufferedOutputStream(fos);
			// PrintStream
			// 1. PrintStream 의 메서드는 IOException 발생하지 않는다.
			// 2. auto flush 기능을 가지고 있음.=> true
			// bos 받고, auto flust를 true 로 설정 ,stream chaning : fos->bos->ps
			ps = new PrintStream(bos, true);

			int readByte = 0;

			while ((readByte = bis.read()) != -1) {
				//ps.print(readByte); 해도 되지만 이는 1byte( 자료형에 맞게 ) 출력하기 때문에 버퍼 기능을 안써서 매우 느리다==> 쓰지 X
				ps.write(readByte);
				//monitor 에 출력하고 싶으면 이렇게.
//				monitor.println(readByte);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//객체 닫기: 항상 finally 에 , 예외 처리 하고 
		} finally {
			try {
				if (fis != null) fis.close();
				if (bis != null) bis.close();
				if (fos != null) fos.close();
				//bos 먼저 닫고 ps 닫으면 에러 발생=> ps 를 먼저 닫고 안에 있는거를 닫아야 에러 발생 X
				if (ps != null) ps.close();
				if (bos != null) bos.close();
				if (monitor != null) monitor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
