package day09;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

/**
 * tedu.cn
 * @author zhengxj
 *
 */
public class ReadExcelJXL{
	
	  /* 
	   * 获得Excel数据，封装为@DataProvider需要的类型Object[][]
	   * filePath:文件路径
	   * fileName:文件名称
	   * sheetName:表单名称
	   */
		//静态方法获取数据
		//必须是静态方法，二维数组
		//第一个参数获取路径，第二个参数获取文件名称，第三个参数获取sheet标签
		public static Object[][] getTestData(String filePath, String fileName,String sheetName) throws IOException {
			try {
				//路径连接文件名称，获取地址，转义符\\
				String path = filePath + "\\" + fileName;
				//inputStream：字节输入流
				//创建一个FileInputStream打开一个到实际文件的连接，通过路径名获取文件
				//创建一个实例获取文件名称，赋值给字节流
				InputStream inputStream = new FileInputStream(path);
				//getWorkbook需要在本地读取的文件
				//读取获取的字节流文件，赋值给对象类型为Workbook
				Workbook book = Workbook.getWorkbook(inputStream);
				//读取到的文件获取sheet标签
				//getSheet需要读取的sheet标签
				Sheet sheet = book.getSheet(sheetName);
				//从sheet标签页，读取行数
				//getRows获取行数，转换成整型
				int rowCount = sheet.getRows();
				//控制台输出行数
				System.out.println("行数="+rowCount);
				//读取列数
				//获取列数，默认从0开始
				//sheet.getRow(0).length;获取第一行数组列数
				int columnCount = sheet.getRow(0).length;
				//控制台输出列数
				System.out.println("列数="+columnCount);
				//创建一个字符串二维数组获取行减1
				//rowCount-1 行数减1，
				//columnCount获取列数
				//二维数组获取的是content[3][2]
				//String content[][] = new String[rowCount-1][columnCount];	
				String content[][] = new String[rowCount][columnCount];	
				//从0开始读取3次，0,1,2,前面获取4行减1行，就时3行
				//rowCount行数
				for(int i=0;i<rowCount-1;i++){
					//读取单元格列内容
					Cell[] celli = sheet.getRow(i+1);
					//获取列数，获取j=0,j=1
					for (int j = 0; j < columnCount; j++) {
						//celli.length 获取单元格数 或  celli[j].getType()获取单元格返回类的类型要等于返回值类型的类型
						//celli[j].getType() == CellType.EMPTY,从excel里取出的值
						//celli.length列数为2
						//j=1不大于2，所有不成立或celli[j].getType()等于Label， CellType.EMPTY等于Empty，不成立
						if(j>=celli.length  || celli[j].getType() == CellType.EMPTY){
							//获取i行和j列的单元格内容赋值为空给二维数组
							content[i][j] = "";
						//else成立
						}else{
							//获取i行和j列的单元格内容赋值给二维数组
							content[i][j] = celli[j].getContents();
							System.out.println("这是1="+content[i][j]);
						}
					}
				}
				//不是void，都有返回值
				//静态方法要有返回值，返回结果
				return content;
			} catch (Exception e) {
				e.printStackTrace();
				//抛出异常就返回一个空异常
				return null;
			}
		}	
}
