package org.usd232.robotics;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class CompilerMain {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {
        try {
            File file = new File(System.getProperty("user.home") + "\\Desktop\\test.csv");
            System.out.println(file.toPath());
            CSVReader csvReader = new CSVReader(new FileReader(file));

            CsvToBean csv = new CsvToBean();
            csv.setCsvReader(csvReader);
            csv.setMappingStrategy(setColumMapping());

            List<ScoutingData> list = csv.parse();

            for (ScoutingData data : list) {
                System.out.println(data.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error");
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(ScoutingData.class);
        String[] columns = new String[]{"matchId", "teamId", "allianceColor", "autoLow", "autoHigh", "autoHeld", "teleOpLow", "teleOpHigh", "teleOpColorSensor", "teleOpClimbSpot", "won"};
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
