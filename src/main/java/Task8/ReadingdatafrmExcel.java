package Task8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingdatafrmExcel {
	 public static void main(String[] args) {
	        try (FileInputStream fileInputStream = new FileInputStream("D:\\cred.xlsx");
	             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                        case NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            break;
	                        default:
	                            break;
	                    }
	                }
	                System.out.println("File successfully Read");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
