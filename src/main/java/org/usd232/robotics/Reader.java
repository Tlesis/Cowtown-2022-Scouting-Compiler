package org.usd232.robotics;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;


@SuppressWarnings({"rawtypes", "unchecked"})
public class Reader {

    private File file;
    private List<ScoutingData> list;

    public Reader() {
        this.file = null;
        this.list = null;
    }

    public Reader(String filePath) throws Exception {
        setList(filePath);
    }

    /** allows the refrenced CSV file to change */
    public void setList(String filePath) throws Exception {
        this.file = new File(filePath);
        CSVReader csvReader = new CSVReader(new FileReader(file));

        CsvToBean csv = new CsvToBean();
        csv.setCsvReader(csvReader);
        csv.setMappingStrategy(setColumMapping());

        this.list = csv.parse();
    }

    public List getList() {
        return list;
    }

    public void print() {
        for (ScoutingData data : list) {
            System.out.println(data.toString());
        }
    }

    private static ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(ScoutingData.class);
        String[] columns = new String[] { "matchId", "teamId", "allianceColor", "autoLow", "autoHigh", "autoHeld", "teleOpLow", "teleOpHigh", "teleOpColorSensor", "teleOpClimbSpot", "won" };
        strategy.setColumnMapping(columns);
        return strategy;
    }
}
