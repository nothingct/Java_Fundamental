package java_20210518;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//read() write() 만 쓰는 프로그램 ==> 안 씀. 
public class FileInOutDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		// IO 는 코딩 패턴이 중요.
		try {
			// FileNotFoundException 예외처리 해줘야 함.
			fis = new FileInputStream(
					"C:\\Users\\user\\Desktop\\SQLD\\SQLD 자료 -20210518T011113Z-001\\SQLD 자료\\개념정리책\\SQL_전문가_가이드(VER._SQLD_자격증) (1).pdf");
			fos = new FileOutputStream("C:\\dev\\test\\2021\\05\\18\\SQL_전문가_가이드(VER._SQLD_자격증) (1).pdf");
			/*
			 * int readByte=0; long start = System.currentTimeMillis(); //read() 는 1바이트 읽어서
			 * 읽은 바이트를 반환한다. while( (readByte=fis.read()) != -1) { //IOException 예외처리 해줘야 함.
			 * fos.write(readByte); //write(byte) 입력받은 1byte를 쓴다. } long end =
			 * System.currentTimeMillis(); System.out.printf("경과시간 : %d초 %n ",
			 * (end-start)/1000); //초 단위 경과시간
			 */
			// 이 코드가 실질적인 코드
			int readByteCount = 0;
			//local : 배열의 크기에 따라 최적화 가능 : 배열의 크기를 늘린다고 빨라지진 않는다. . 
			byte[] readBytes = new byte[1024 * 100]; // 100KB 배열
			long start = System.currentTimeMillis();

			while ((readByteCount = fis.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}
			long end = System.currentTimeMillis();
			System.out.printf("경과시간 : %dms %n ", end - start); // 초 단위 경과시간
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
