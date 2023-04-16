package utilities;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.Base;

public class ReadXLdata extends Base {
	
	/* DataFormatter format = new DataFormatter(); */
	
	public Object[][] getData(String sheetName) throws IOException {

		fip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");

		try (XSSFWorkbook wb = new XSSFWorkbook(fip)) {
			XSSFSheet xs = wb.getSheet(sheetName);

			int totalRows = xs.getPhysicalNumberOfRows();
			System.out.println("Total number of Rows =" + totalRows);

			int totalColumn = xs.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total number of Column =" + totalColumn);

			Object tData[][] = new Object[totalRows-1][totalColumn];

			for (int i = 1; i < totalRows; i++) {
				for (int j = 0; j < totalColumn; j++) {
					tData[i - 1][j] = xs.getRow(i).getCell(j).getStringCellValue().trim();
					System.out.print(tData[i - 1][j] + " ");
				}
				System.out.println();
			}
			return tData;
		}
	}

}
