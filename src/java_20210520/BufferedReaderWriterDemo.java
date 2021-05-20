package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderWriterDemo {
	public static void main(String[] args) {
		FileReader fr= null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			fr= new FileReader("C:\\dev\\test\\2021\\05\\18\\FileDemo.java");
			fw= new FileWriter("C:\\dev\\test\\2021\\05\\18\\FileDemoCopy2.java");
			br = new BufferedReader(fr);
			bw= new BufferedWriter(fw);
			
			String readLine = null;
			while( (readLine=br.readLine())!=null) {
				bw.write(readLine); //readLine 변수에는 개행(/r/n-WIN , /n-Linux)이 포함되지 X
				bw.newLine();//개행을 OS에 맞추어서 넣어준다. 
				System.out.println(readLine);
			}
			bw.flush();
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
					if(bw!=null) bw.close();
					if(fw!=null) fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
