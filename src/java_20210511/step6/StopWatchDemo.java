package java_20210511.step6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
 * Java Reflection? 적용 
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
