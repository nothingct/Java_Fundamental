package java_20210513;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		String[] dayOfWeek = { "","일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
		//HOUR : 1~12 표시 HOUR_OF_DATE: 0~23 표시
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		//month 는 0 ~ 11 까지 로 되어있어서 display용으로는 +1 해줘야함.
		System.out.printf("%d년 %d월 %d일 ",year,month+1,day);
		System.out.printf("%d:%d:%d %n", hour,minute,second);
		//일요일 1 ~ 토요일 7 ==> dayOfweek배열 의 index 가 해당 요일을 나타내도록 코딩.
		System.out.printf("%d년 %d년 %d 일은 %s입니다 %n",year,month+1,day,dayOfWeek[cal.get(Calendar.DAY_OF_WEEK)]);
		
		//ctl+shift+o
		//이러한 코드는 util class로 따로 만들어놓으면 유용하게 쓰일 것이다.
		//오늘 날짜 말고 다른 날짜도 알고 싶을경우 ->set(year,month(0~11),day)
		cal.set(2008,1,13);
		
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy년 MM월 dd일 HH시mm분ss초 (E)요일");
		//Calendar => Date 객체로 변환해주는 함수 : getTime() <- 이것만 잘 기억하자.
		//Date 는 클래스 자체로는 진짜 쓸모가 없음. 그냥 전달해야 하는 구조니까 ..
		String display = sdf.format(cal.getTime());
		System.out.println(display);
		// System.out.println(sdf.format(cal.getTime())); 와 동일하다.
		
		//해당 월의 마지막 날짜 구해주는 함수:getActualMaximum(Calendar.DATE);
		int lastDay  = cal.getActualMaximum(Calendar.DATE);
		System.out.println(lastDay); //2020년 2월은 윤년이니까 2월 마지막 날은 29일
	}
}
