package org.usd232.robotics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoutingData {
    private String matchId;
    private String teamId;
    private String allianceColor;
    private String autoLow;
    private String autoHigh;
    private String autoHeld;
    private String teleOpLow;
    private String teleOpHigh;
    private String teleOpColorSensor;
    private String teleOpClimbSpot;
    private String won;

    public String toString() {
        return String.format("MatchID = %s; TeamID = %s; Color = %s; autoLow = %s; autoHigh = %s; autoHeld = %s; teleOpLow = %s; teleOpHigh = %s; colorSensor = %s; climb = %s; won = %s", 
            matchId, teamId, allianceColor, autoLow, autoHigh, autoHeld, teleOpLow, teleOpHigh, teleOpColorSensor, teleOpClimbSpot, won);
    }
}