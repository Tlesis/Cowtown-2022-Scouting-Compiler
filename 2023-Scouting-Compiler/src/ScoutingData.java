import com.opencsv.bean.CsvBindByName;

public class ScoutingData {
	 @CsvBindByName
     private String MatchId;
	 
	 @CsvBindByName
	 private String TeamId;

	 @CsvBindByName
	 private String AllianceColor;
	 
	 @CsvBindByName
	 private String AutoCargoLower;
	 
	 @CsvBindByName
	 private String AutoCargoOuter;
	 
	 @CsvBindByName
	 private String AutoCargoHeld;
	 
	 @CsvBindByName
	 private String AutoMoves;
	 
	 @CsvBindByName
	 private String TeleOpCargoLower;
	 
	 @CsvBindByName
	 private String TeleOpCargoOuter;

	 @CsvBindByName
	 private String TeleOpCanSeeColor;

	 @CsvBindByName
	 private String GrabBarPosition;
	 
	 @CsvBindByName
	 private String Won;

}
