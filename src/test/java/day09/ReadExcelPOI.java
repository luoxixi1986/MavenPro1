package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * tedu.cn
 * @author zhengxj
 *
 */
public class ReadExcelPOI {

	  /*
	   * 获得Excel数据，封装为@DataProvider需要的类型Object[][]
	   * filePath:文件路径
	   * fileName:文件名称
	   * sheetName:表单名称
	   */
	    //第一个参数获取路径，第二个参数获取文件名称，第三个参数获取sheet标签
		public static Object[][] getTestData(String filePath, String fileName,String sheetName) throws IOException {
			//路径连接文件名称，获取地址，转义符\\
			File file = new File(filePath + "\\" + fileName);
			FileInputStream inputStream = new FileInputStream(file);
			Workbook Workbook = null;
			String fileExtensionName = fileName.substring(fileName.indexOf("."));

			if (fileExtensionName.equals(".xlsx")) {
				Workbook = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				Workbook = new HSSFWorkbook(inputStream);
			}

			Sheet Sheet = Workbook.getSheet(sheetName);
			int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
			int colCount = Sheet.getRow(0).getLastCellNum();
			System.out.println("测试"+colCount);
			List<Object[]> records = new ArrayList<Object[]>();
			System.out.println("行数："+(rowCount+1));
			System.out.println("列数："+colCount);
			for (int i = 1; i < rowCount + 1; i++) {
				Row row = Sheet.getRow(i);
				String fields[] = new String[colCount];
				for (int j = 0; j < colCount; j++) {
					System.out.println("i="+i);
					System.out.println("j="+j);
					Cell cell=row.getCell(j);
					if (j>=row.getLastCellNum() || cell==null){
						fields[j] = "";
					}else{
						cell.setCellType(Cell.CELL_TYPE_STRING);
						fields[j] = cell.getStringCellValue();
					}
				}
				records.add(fields);
			}

			Object[][] results = new Object[records.size()][];
			for (int i = 0; i < records.size(); i++) {
				results[i] = records.get(i);
				System.out.println(results[i]);
			}
			return results;
		}
}
