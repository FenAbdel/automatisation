package convertor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class convertor {
	private static XSSFWorkbook workbook;

	public static void main(String[] args) throws IOException, InterruptedException {
		//arrays and hashmaps
		ArrayList<String> names = new ArrayList<String>();
		HashMap<String, String> mapLog = new HashMap<String, String>(); // log of row data
		Gson gson = new Gson();
		//loading the excel file 
		String Excelpath = ".\\files\\worldcupdata.xlsx"; // your xlsx path
		workbook = new XSSFWorkbook(Excelpath);
		XSSFSheet sheet = workbook.getSheet("sheet1"); //define your sheet
		
		//initiation
		int rowCount = sheet.getPhysicalNumberOfRows();
		int namenum = 1 ;
        FileWriter fileWriter = new FileWriter("./jsonFiles/worldcup.json");

		DataFormatter formatter = new DataFormatter();
		String name = formatter.formatCellValue(sheet.getRow(0).getCell(0));
		
		// sort names in a list
		while(!name.isEmpty()) {
			names.add(name);
			name = formatter.formatCellValue(sheet.getRow(0).getCell(namenum));
			namenum++;
		}
		
		for(int i =1 ; i<rowCount ; i++) {
			//get data from cells and put in in the map (fill the maplog
			for (int j = 0; j<names.size();j++) {
				String data = formatter.formatCellValue(sheet.getRow(i).getCell(j));
				mapLog.put(names.get(j), data);
			}

			JsonObject json = gson.toJsonTree(mapLog).getAsJsonObject();
            System.out.println(json);
            fileWriter.write(json.toString()+"\n");
            fileWriter.flush();
		}
        fileWriter.close();
	}

}
