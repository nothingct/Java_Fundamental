package java_20210511.step6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * nano와 milli 를 합치고 싶어 
 * ==>manager 와 abstact 클래스를 이용해서 구조화 해야한다.+ 확장가능
 * 그 구조화를 할 수 있는 이유는 : 구조가 맞기 때문에 구조화가 가능한거야.
 * 그리고 고객이 이제 MicroWatich 같이 새로운 요구사항을 하더라도 , 틀이 이미 잡혔기에 
 * 클래스만 만들고 끼워맞추면 되. 
 * 처음부터 추상화 하는게 X 하다보니 추상화가 필요O FOR 구조화
 */
public class StopWatchDemo {
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		File file = new File("C:\\Users\\user\\eclipse-workspace\\Java_Fundamental\\src\\java_20210511\\step6\\class.properties");
		FileReader reader=  new FileReader(file);
		Properties properties = new Properties();
		properties.load(reader);
		String clazz = properties.getProperty("class.name");
		Class c=Class.forName(clazz);
		StopWatch s= (StopWatch)c.newInstance();
		StopWatchManager manager = StopWatchManager.getInstance();
		// manager.run(new StopNanoWatch());
		manager.run(s);
	}
}
