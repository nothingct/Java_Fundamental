package java_20210513;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//내일까지 기본문법은 끝. ~0514
//쓰레드 IO 네트워크 는 다음주부터. 
public class Calendar2 {
	private Calendar cal;
	//java.util.Calendar 패키지를 활용하여 코드 리팩토링.
	public Calendar2(){
		cal= Calendar.getInstance();
	}
	public void print(int year, int month, int day) {
		cal.set(year, month-1,day);
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy년 MM월 dd일 E요일입니다.");	
		System.out.println(sdf.format(cal.getTime()));
	}
	
	public void print(int year, int month) {
		cal.set(year, month-1,1);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		
		System.out.printf("%d년 %d월 달력입니다%n",year,month);
		System.out.printf("=====================================================%n");
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		for(int i=1; i<dayOfWeek; i++) {
			System.out.printf(" \t");
		}
		for (int i = 1; i <= lastDay; i++) {
			System.out.print(i + "\t");
			dayOfWeek++;
			if (dayOfWeek == 8) {
				dayOfWeek = 1;
				System.out.println();
			}
		}
		System.out.println();
		System.out.printf("=====================================================%n");
	}

	public void print(int year) {
		for (int month = 1; month <= 12; month++) {
			print(year, month);
			System.out.println();
		}
	}
}
//웹 개발 할 때 이 로직을 그대로 jsp ~ html을 활용하여 더 디자인된 형태로 만들 수 있다.
// 달력 프로그램을 제대로 만들면 일정관리 프로그램 도 만들 수 있다. 일정=>DB에 끌어오고 넣고... 