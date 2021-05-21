package java_20210521;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CoinMarketCapCrawlingDemo {
	public static void main(String[] args) throws org.json.simple.parser.ParseException {
		
		Document doc = null;
		String url = "https://api.coinmarketcap.com/data-api/v3/cryptocurrency/historical";
		String jsonStr = null;
		try {
			jsonStr = Jsoup.connect(url)
					.data("id","2")
                    .data("convertId","2781")
                    .data("timeStart","1616284800")
                    .data("timeEnd","1621555200")
                    .timeout(4000)
                    .userAgent("Mozilla")
                    .ignoreContentType(true)
                    .execute().body();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONParser parser = new JSONParser();
		try {
//			System.out.println(jsonStr);
			JSONObject jsonObj = (JSONObject) parser.parse( jsonStr );
			JSONObject jsonObj1 = (JSONObject)jsonObj.get("data");
			JSONArray array = (JSONArray)jsonObj1.get("quotes");
			System.out.println("timestamp \t high \t low \t close \t open \t volume \t marketCap");
			for (int i = 0; i < array.size(); i++) {
		        JSONObject obj1 = (JSONObject)array.get(i);
		        JSONObject obj2 = (JSONObject)obj1.get("quote");
		        Double high = (Double)obj2.get("high");
		        Double low = (Double)obj2.get("low");
		        Double close = (Double)obj2.get("close");
		        Double open = (Double)obj2.get("open");
		        Double volume = (Double)obj2.get("volume");
		        Double marketCap = (Double)obj2.get("marketCap");
		        String timestamp = ((String)obj2.get("timestamp")).substring(0,10);
		       
		        
		        System.out.printf("%s\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f\t%.1f %n", 
		        		timestamp,high,low,close,open,volume,marketCap);
		    }
			
			
			  


		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}