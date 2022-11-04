package org.usd232.robotics;

import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Write {

    public static void fileWriter(String path, List list, boolean header) {
        try {
            StringWriter writer = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(writer);

            List<String[]> data = toStringArray(list, header);

            csvWriter.writeAll(data);

            csvWriter.close();

            boolean exists = Files.exists(Paths.get(path));

            Files.write(Paths.get(path), writer.toString().getBytes(), (exists) ? StandardOpenOption.APPEND
                                                                                : StandardOpenOption.CREATE);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private static List<String[]> toStringArray(List<ScoutingData> list, boolean header) {
		List<String[]> records = new ArrayList<String[]>();

		// adding header record
        if (header)
		    records.add(new String[] { "MatchId", "TeamId", "AllianceColor", "AutoCargoLower", "AutoCargoOuter", "AutoMoves", "TeleOpCargoLower", "TeleOpCargoOuter", "TeleOpCanSeeColor", "GrabBarPosition", "Won"});

		for (int i = 1; i < list.size(); i++) {
            ScoutingData data = list.get(i);
            if (data.getMatchId() != "MatchId") {
                records.add(new String[] { data.getMatchId(), data.getTeamId(), data.getAllianceColor(),
                                        data.getAutoLow(), data.getAutoHigh(), data.getAutoHeld(), 
                                        data.getTeleOpLow(), data.getTeleOpHigh(), data.getTeleOpColorSensor(),
                                        data.getTeleOpClimbSpot(), data.getWon() });
            }
		}
		return records;
	}
}
