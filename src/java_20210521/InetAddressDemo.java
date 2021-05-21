package java_20210521;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress : 객체생성->local || 외부 도메인 으로 ==> Host 이름 || Ip 주소 를 얻는 기능.
		//딱 이 정도
		InetAddress i = InetAddress.getLocalHost();	
		System.out.printf("호스트 이름: %s%n",i.getHostName() );
		System.out.printf("IP : %s %n", i.getHostAddress());
		
		InetAddress i2 = InetAddress.getByName("google.com");
		System.out.printf("호스트 이름: %s%n",i2.getHostName() );
		System.out.printf("IP : %s %n", i2.getHostAddress());
		
	}
}
