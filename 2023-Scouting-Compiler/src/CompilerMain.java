import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;

public class CompilerMain {

	public static void main(String[] args) {
		Object csvFile;
		List<ScoutingData> beans = new CsvToBeanBuilder(new FileReader("C:\\TestsComplier\\test.csv"))
			       .withType(ScoutingData.class).build().parse();
		
		// TODO Auto-generated method stub
	/*	CSVReader csvReader = new CSVReader (new InputStreamReader(csvFile.getInputStream()));
		String[] record;
		while ((record = csvReader.readNext()) != null) {
		    // do something
		}
*/
		
	
	}

}
