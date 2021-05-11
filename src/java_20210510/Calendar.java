package java_20210510;


public class Calendar {
	private int year;
	private int month;
	private int day;
	
	private int monthArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	//리터럴 상수를 그대로 코드에 쓰는 것은, 해당 지식이 있는 사람은 알 수 있어도, 지식이 없는 외국인도 이해할 수 있도록 변수처리해주는 것이 좋다.
	//참고: 코드블록 드래그 -> 우클릭 -> refactoring -> extract method 로 중복되는 코드를 메소드화 할 수 있다.(private)
	// year 년 month 월 달력을 출력해라.
	public static final int  MUL_OF_4 =4;
	public static final int  MUL_OF_100 =100;
	public static final int  MUL_OF_400 =400;
	public Calendar() {}
	public Calendar(int year) {
		this(year,0,0);
	}
	
	public Calendar(int year, int month) {
		this(year,month,0);
	}
	public Calendar(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	private int getTotalDays(int year, int month, int day) {
		int lastMonth = month - 1;
		int lastYear = year - 1;
		int totalDay = lastYear * 365;
		totalDay+= (lastYear / MUL_OF_4) - (lastYear / MUL_OF_100) + (lastYear / MUL_OF_400);

		boolean isLeaf = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
		//여러 년도를 print(year)로 호출할 경우를 대비하여 
		//monthArray배열 자체를 변경하지 말고, 전체 일수에 2월29일 하루를 더해준다.
		if (isLeaf) totalDay+=1;

		for (int i = 0; i < lastMonth; i++) {
			totalDay += monthArray[i];
		}

		return (totalDay+day)%7;
	}
	public void print() {
		if(year !=0 && month !=0 && day!=0) {
			printDay(year,month,day);
		}else if(year !=0 && month !=0 &&day==0) {
			printMonth(year,month);
		}else if(year!=0&&month ==0 &&day ==0) {
			printYear(year);
		}
	}
	
	private void printDay(int year, int month, int day) {
		int today = getTotalDays(year, month, day);
		String[] dayOfWeek = { "일", "월", "화", "수", "목", "금", "토" };
		System.out.printf("%d년 %d월 %d일은 %s요일 입니다%n", year, month, day, dayOfWeek[today]);
	}

	private void printMonth(int year, int month) {
		int firstDay = getTotalDays(year, month, 1);
		System.out.printf("%d년 %d월 달력%n", year, month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int dayOfWeek = firstDay;
		for (int i = 0; i < dayOfWeek; i++) {
			System.out.print(" " + "\t");
		}
		for (int i = 1; i <= monthArray[month - 1]; i++) {
			System.out.print(i + "\t");
			dayOfWeek++;
			if (dayOfWeek % 7 == 0) {
				dayOfWeek = 0;
				System.out.println();
			}
		}
		System.out.println();
	}

	private void printYear(int year) {
		for (int month = 1; month <= 12; month++) {
			printMonth(year, month);
			System.out.println();
		}
	}
}
//웹 개발 할 때 이 로직을 그대로 jsp ~ html을 활용하여 더 디자인된 형태로 만들 수 있다.
// 달력 프로그램을 제대로 만들면 일정관리 프로그램 도 만들 수 있다. 일정=>DB에 끌어오고 넣고... 