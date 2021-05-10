package java_20210507;

/*
 * 유틸 클래스 : 개발자들이 프로젝트를 수행할 때 
 * 클래스 안에 유용한 메소드들만 모아놓은 클래스를 들고 다님.
 * 유틸 클래스 에는 여러 유용한 메소드들이 모여있음. 
 */
public class MethodDemo {
	private int monthArray[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public int getFirstDay(int year,int month) {
		int lastMonth = month-1;
		int lastYear = year-1;
		int totalDay = lastYear*365+lastYear/4-lastYear/100+lastYear/400;
		checkLeafYear(year);
		for (int i = 0; i <lastMonth; i++) {
			totalDay+=monthArray[i];
		}
		return (totalDay+1)%7;
	}
	public void print(int year, int month, int day) {
		String[] days= {"일","월","화","수","목","금","토"};
		int today  =(getFirstDay(year, month)+(day-1))%7;
		System.out.printf("%d년 %d월 %d일은 %s요일 입니다%n", year,month,day,days[today]);
	}
	public void print(int year, int month) {
		int firstDay = getFirstDay(year, month);
		System.out.printf("%d년 %d월 달력%n", year,month);
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		for (int i = 1,date=firstDay; i <= monthArray[month-1]; i++) {
			if(i==1) {
				for (int j = 0; j < firstDay; j++) {
					System.out.print(" "+"\t");
				}
			}
			System.out.print(i+"\t");
			date++;
			if(date%7==0) {
				date=0;
				System.out.println();
			}
		}
		System.out.println();
	}
	public void print(int year) {
		for (int i = 1; i <=12; i++) {
			print(year,i);
			System.out.println();
		}
	}
	//배열 정렬 메소드 :매개 변수 / 리턴값을 몰라도 XXX로 놓고 일단 로직만 가져와==> 로직을 보고 매개변수 /리턴값 끼워맞춤
	public void arrayAscending(int[] array) {
		//정렬 3 : bubble 정렬 
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length-(i+1); j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j]=array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	
	//first.second=> 매개변수(parameters)
	public long plus(long first, long second) {
		return first+second;
	}
	//윤년 체크 메소드
	//자바에서는 메소드 의 반환값이 true/false 이면 메소드이름을 is~~로 한다.(관례)
	public void checkLeafYear(int year) {
		boolean isLeaf =year%4==0&&year%100!=0 || year%400==0;
		if(isLeaf) {
			monthArray[1]=29;
		}else {
			monthArray[1]=28;
		}
	}
	
	public static void main(String[] args) {
		MethodDemo m = new MethodDemo();
		long sum= m.plus(10, 20);
		//단축기 등록 _ windows-preferences-templates - java - editor - new - 단축키등록( insert variable도 O)
		//nn: 한줄 띄우기용 단축키 추가했음 sysformat: printf 추가했음
		System.out.printf("%d %n", sum);// 10,20 =>인자 (arguments)
		
		int[] test = {10,20,1,30,4,89,110,25};
		m.arrayAscending(test);
		for (int i = 0; i < test.length; i++) {
			System.out.printf("%d \t", test[i]);
		}
		System.out.println();
		m.print(2021,5,7);
		m.print(2021,5);
		m.print(2021);
	}
}
