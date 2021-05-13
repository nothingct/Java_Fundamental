package java_20210513;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
		//HashSet 클래스는 데이터(객체)의 중복을 허용하지 않고 순서가 없음.
		//Treeset 은 add 시 오름차순으로 꺼낼 수 있도록 한다.
		//내림차순 을 원하면 -를 앞에 넣고 꺼낼때 다시 -1을 곱한다.
		//TreeSet 클래스는 데이터(객체)의 중복을 허용하지 않고, natural orderling(숫자-오름차순, 문자-문자의 기본오름차순)
		TreeSet set = new TreeSet();
		set.add(-3);
		set.add(-2);
		set.add(-1);
		set.add(-3);
		set.add(-2);
		set.add(-5);
		set.add(-6);
		set.add(-7);
		set.add(-8);
		set.add(-11);
		set.add(-14);
		set.add(-52);
		set.add(-23);
		
		TreeSet set2 = new TreeSet();
		set2.add("banana");
		set2.add("best");
		set2.add("yorusika");
		set2.add("apple");
		set2.add("asia");
		set2.add("chicken");
		set2.add("computer");
		set2.add("zombiePC");
		set2.add("world");
		//문자열일 때는 정렬방식이 1~~~~~~~~~~~쭉 , 2~~~~~~쭉,....이런식
		//HashSet 클래스는 자체적으로 출력할 방법이 없음.
		//HashSet를 Iterator로 변환해서 출력해야 함.
		Iterator i =set.iterator();
		while(i.hasNext()) {// hasNext() : Iterator에 객체가 존재하는지 판단하는 메서드 
			//넣은 객체로 캐스팅해서 가져와야 한다.
			int temp = -(int)i.next();//next() : 객체를 가져온다.
			//출력할떄 순서가 없는것을 확인가능.
			System.out.println(temp);
		}
		i =set2.iterator();
		while(i.hasNext()) {// hasNext() : Iterator에 객체가 존재하는지 판단하는 메서드 
			//넣은 객체로 캐스팅해서 가져와야 한다.
			String temp2 = (String)i.next();//next() : 객체를 가져온다.
			//출력할떄 순서가 없는것을 확인가능.
			System.out.println(temp2);
		}
		//로또 만들기 -TreeSet으로 간단하게 구현.
		TreeSet lottoSet = new TreeSet();
		while(true) {
			int random = (int)(Math.random()*45)+1;
			lottoSet.add(random);
			if(lottoSet.size()== 6) break;
		}
		i= lottoSet.iterator();
		while(i.hasNext()) {
			int lotto = (int)i.next();
			System.out.print(lotto+ "\t");
		}
		System.out.println();
		//StringBuffer 확인해보기 
		HashSet sbSet = new HashSet();
		sbSet.add(new StringBuffer("hello"));
		sbSet.add(new StringBuffer("hello"));
		sbSet.add(new StringBuffer("hello"));
		sbSet.add(new StringBuffer("hello"));
		sbSet.add(new StringBuffer("hello"));
		System.out.println("sbSet Size : "+ sbSet.size());
	
		i = sbSet.iterator();
		while(i.hasNext()) {
			StringBuffer temp = (StringBuffer)i.next();
			System.out.println(temp);
		}
	}
}