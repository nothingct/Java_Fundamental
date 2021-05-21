package java_20210521;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*poi library(excel) : https://www.apache.org/dyn/closer.lua/poi/release/bin/poi-bin-4.1.0-20190412.zip
들어가서 링크 클릭해서 다운 후 알집 풀고
.jar파일 (java archive 의 약자 ) 6개를 eclipse의 클래스패스에 추가
외부라이브러리 추가 방법. 좌상단 프로젝트 우클릭 - build path - configure build path -japa build path 
-library - classpath - add external~~~(외부라이브러리 추가 ) 
*/
//open Office : excel viewer 용도 
public class ExcelDemo {

	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook(); //Excel 만듦
		HSSFSheet sheet = workbook.createSheet("새 파일"); //Excel의 새 seheet만듬
		//로우를 먼저 생성해야 Cell 을 생성할 수 있다. 
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		cell.setCellValue("테스트데이터(0,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트데이터(0,1)");
		
		cell = row.createCell(2);
		cell.setCellValue("테스트데이터(0,2)");
		
		row = sheet.createRow(1);
		
		cell = row.createCell(0);
		cell.setCellValue("테스트데이터(1,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트데이터(1,1)");
		
		cell = row.createCell(2);
		cell.setCellValue("테스트데이터(1,2)");

		row = sheet.createRow(2);
		
		cell = row.createCell(0);
		cell.setCellValue("테스트데이터(2,0)");
		
		cell = row.createCell(1);
		cell.setCellValue("테스트데이터(2,1)");
		
		cell = row.createCell(2);
		cell.setCellValue("테스트데이터(2,2)");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\users\\user\\Downloads\\test.xls");
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch 
			e.printStackTrace();
		} finally {
				try {
					if(fos!=null) fos.close();
					if(workbook!=null) workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
	
}
