package java_20210521;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CoinMarketCrawlingDemo {
	public static void main(String[] args) {
		Document doc = null;
		String url = "https://coinmarketcap.com/currencies/bitcoin/historical-data/";
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements elements = doc.getElementsByClass("sc-16r8icm-0 elzRBB container");
		System.out.println(elements);
	}
}
