package java_20210512;

public class StringDemo {
	//String 은 Call By Primitive 와 똑같이 작동한다. ( Reference 이지만, Immutable 객체이기 때문에 )
	public static String reverse(String str) {
		String s="";
		int len = str.length();
		for(int i=len-1; i>=0; i--) {
			//System.out.println(str.substring(i,i+1));
			s+=str.substring(i,i+1);
		}
		return s;
	}
	
	public static void main(String[] args) {
		String str = "beautiful";
		String str5 = reverse(str);
		System.out.println(str);
		System.out.println(str5);
		String str1= new String("hello");
		String str2 = new String("hello");
		String str3= "test";
		String str4= "test";
		
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println();
		System.out.println(str3==str4);		
		System.out.println(str3.equals(str4));
	}
}
