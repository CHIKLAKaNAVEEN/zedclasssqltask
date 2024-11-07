
package Task8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOperations {
	
	public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");
        headerRow.createCell(2).setCellValue("Email");

        // Data rows
        Object[][] data = {
            {"John Doe", 30, "john@test.com"},
            {"John Doe", 20, "john@test.com"},
            {"John Doe", 40, "jack@test.com"},
            {"John Doe", 50, "sapnil@test.com"}
        };

        int rowCount = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("D:\\cred.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Succesfully file crated in D folder");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
