package java_20210520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;

public class TistoryScanningDemo {
	public static void main(String[] args) {
		try {
			// Src : url 이므로 url 에 맞는 연결방법
			URL url = new URL("https://twowix.me/84");
			InputStream in = url.openStream();
			InputStreamReader ir = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(ir);

			PrintStream monitor = System.out;
			FileWriter fw = new FileWriter("C:\\users\\user\\tistory.html");
			BufferedWriter bw = new BufferedWriter(fw);

			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				monitor.println(readLine);
				bw.write(readLine);
				bw.newLine();
			}
			bw.flush();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
