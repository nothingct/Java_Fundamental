package java_20210518;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	public static String format(File f) {
		// 마지막 수정한 날짜 1970년 1월 1일 00:00:00 초부터 해당 날짜까지의 시간을 밀리세컨드로 반환.
		// 파일의 마지막 수정날짜를 구하는 메소드 화 시키는 것.
		long lastModified = f.lastModified();
		Calendar cal = Calendar.getInstance();
		// 밀리세컨드를 해당 날짜로 변환해줌.
		cal.setTimeInMillis(lastModified);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
		String format = sdf.format(cal.getTime());
		return format;
	}

	public static void main(String[] args) {
		File f1 = new File("C:\\dev\\test\\2021\\05\\18");
		// mkdir() 는 비추 mkdrs() 추천
		if (f1.mkdirs()) {
			System.out.println("디렉토리를 생성했습니다.");
		} else {
			System.out.println("이미 디렉토리가 존재합니다.");
		}
		File f2 = new File("C:\\dev\\test\\2021\\05\\18\\eclipse.zip");
		// 크기 반환
		// 값 변질 시키지 말아야 됨. =>int len = (int)f2.length();
		long len = f2.length();
		// kb로 출력
		System.out.printf("파일의 크기는 %,dkb 입니다.%n", len / 1024);
		// mb로 출력
		System.out.printf("파일의 크기는 %,dmb 입니다.%n", len / 1024 / 1024);
		boolean isFile = f2.isFile(); // isDirectory()
		if (isFile) {
			String path = f2.getPath();
			System.out.println("파일 위치 : " + path);
			System.out.print("파일의 유형은 ");
			if (path.endsWith("zip")) {
				System.out.println("압출파일 입니다.");
			} else if (path.endsWith("txt")) {
				System.out.println("텍스트파일 입니다.");
			} else if (path.endsWith("java")) {
				System.out.println("java 파일 입니다.");
			}
		} else {
			System.out.println("디렉토리입니다.");
		}
		// 마지막 변경 날짜 구하기 (메소드로 구현화 )
		// 많이 쓰는지 안쓰는지 감이 없으니까 프로젝트를 많이 해보셔야되..
		System.out.println(format(f2));
		// eclipse2.zip => eclipse3로 이름을 바꾸기
		File f3 = new File("C:\\dev\\test\\2021\\05\\18\\eclipse2.zip");
		// 생성자("앞 경로", "뒷 경로" )
		File f4 = new File("C:\\dev\\test\\2021\\05\\18", "이클립스3.zip");
		// f3의 이름을 f4로 바꾼다.
		// 이름을 바꿀 일은 많이 있다.
		// 사용자가 올린 파일들을 관리자가 이름을 바꿀 일이 많이 있다.
		f3.renameTo(f4);

		String path = f4.getPath(); // 전체경로
		String parent = f4.getParent(); // 부모경로만 가져올 수 있다.
		String name = f4.getName();// 파일의 이름만 ==> 파일 관리자용 웹 을 만들고 싶을 때.

		// getPath() 랑 getParent() 는 많이 사용한다.

		System.out.printf("%s %s %s %n", path, parent, name);
		f4.delete();// 삭제도 많이 사용.
		// 해당 폴더 의 폴더와 파일 을 가져오기.
		File f5 = new File("C:\\Users\\user\\eclipse-workspace\\Java_Fundamental");
		// f5.list(); //출력 display 용도 => list()
		File[] files = f5.listFiles(); // 파일 을 받아서 활용 하려면.
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.printf("%s,\t %s,\t 파일폴더%n", f.getName(), format(f));
			}
		}
		for (File f : files) {
			if (f.isFile()) {
				String type = f.getName().substring(f.getName().lastIndexOf("."));
				System.out.printf("%s,\t %s,\t %s\t %,dB %n", f.getName(), format(f),type, f.length());
			}
		}
		
	}
}