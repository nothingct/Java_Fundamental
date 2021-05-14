package java_20210514;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		//HashMap : key 값은 유일해야 하고, value 는 객체의 중복을 허용함
		HashMap<String,String> map = new HashMap<String,String>();
		
		map.put("a","1111");
		map.put("b","2222");
		map.put("c","3333");
		
		String value1 =map.get("a");
		String value2 =map.get("b");
		String value3 =map.get("c");
		//map 에 엄청 많이 들어가 (100개) 있으면 이걸 키를 일일이 어케 작성하지?
		System.out.printf("%s %s %s %n",value1,value2,value3);
		//Key들은 유일하고, 이 Key들은 중복이 어차피 안되니까, Set에 다넣어도 Key들은 그대로 유지된다.(손실X)
		//데이터가 100개 미만 이고 10개~20개씩 끄집어낸다면 ArrayList 가 가장 적합. 
		//데이터가 엄청 많다면 Map을 가장 먼저 떠올려볼 것. 
		Set keySet = map.keySet();
		Iterator i = keySet.iterator();
		while(i.hasNext()) {
			String key = (String)i.next();
			String value = map.get(key);
			System.out.printf("%s : %s %n",key,value);
		}
	}
}
