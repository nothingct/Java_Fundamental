package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//bw 의 flush 랑 newline 하는 것 조차도 귀찮으니까, 
//pw를 쓰는 사람들도 있다. pw.println()을 쓰면 write() + newLine() 안해도 되고, flush() 도 안해도됨.
//현업에서는 br ~ bw 많이 쓰고, 편하려는 사람은 pw 쓰기도함. 
public class PrintWriterDemo {
	public static void main(String[] args) {
		FileReader fr= null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fr= new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
			fw= new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemoCopy2.java");
			br = new BufferedReader(fr);
			bw= new BufferedWriter(fw);
			//PrintWriter 의 auto flush -> true : flush 안써줘도됨.
			pw = new PrintWriter(bw,true);

			String readLine = null;
			while( (readLine=br.readLine())!=null) {
				pw.println(readLine); 
				System.out.println(readLine);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				try {
					if(br!=null) br.close();
					if(fr!=null) fr.close();
					if(pw!=null) pw.close();
					if(bw!=null) bw.close();
					if(fw!=null) fw.close();
					//파일이름 바꾸기
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
