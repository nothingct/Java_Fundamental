package java_20210521;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ChrawlingDemo {
	public static void main(String[] args) {
		String url = new String("http://www.imbc.com/");
		//HTML 문서를 관리하기 위한 객체
		Document doc = null; 
		
		try {
			//해당 url 의 html 이 모두 Document 객체에 저장
			doc = Jsoup.connect(url).get();
//			System.out.println("성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements elements = doc.select(".notice-list li");
//		System.out.println(elements);
		for (Element element : elements) {
			System.out.println(element.text());
		}
	}
}
