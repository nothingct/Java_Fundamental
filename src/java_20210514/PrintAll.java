package java_20210514;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PrintAll {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\user\\eclipse-workspace\\Java_Fundamental\\src");
		FileWriter fw = null;
		FileReader fr = null;
		BufferedReader br= null;
		BufferedWriter bw= null;
		String[] dirs = f.list();
		fw = new FileWriter("C:\\Users\\user\\allprint.txt");
		bw = new BufferedWriter(fw);
		for(String dir : dirs) {
			File f1 = new File(f,dir);
			//System.out.println(f1.getPath());
			String[] dirs1 = f1.list();
			for(String dir1 : dirs1) {
				File f2 = new File(f1,dir1);
				System.out.println(f2.getPath());
				if(f2.isFile()) {
					fr = new FileReader(f2);
					br = new BufferedReader(fr);
					
					String readLine = null;
					while((readLine = br.readLine()) != null) {
						bw.write(readLine);
						bw.newLine();
					}
					bw.flush();
				}else {
					File f3 = new File(f2.getPath());
					
					String[] dirs2 = f3.list();
					for(String dir2 : dirs2) {
						File f4 = new File(f3,dir2);
						System.out.println(f4.getPath());
						fr = new FileReader(f4);
						br = new BufferedReader(fr);
						
						String readLine = null;
						while((readLine = br.readLine()) != null) {
							bw.write(readLine);
							bw.newLine();
						}
						bw.flush();
					}
					
				}
			}
		}
	}

}