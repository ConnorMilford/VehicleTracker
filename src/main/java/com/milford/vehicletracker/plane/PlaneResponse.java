package com.milford.vehicletracker.plane;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.milford.vehicletracker.Response;


public class PlaneResponse extends Response {

    private long time;

    private List<List<Object>> states;

    private LocalDateTime timePosition;
    private LocalDateTime lastContact; 


    public PlaneResponse() {
        // Default constructor for deserialization
    }

    public static Map<String, Integer> stateIndexMap = Map.ofEntries(

        Map.entry("icao24", 0),
        Map.entry("callsign", 1),
        Map.entry("origin_country", 2),
        Map.entry("time_position", 3),
        Map.entry("last_contact", 4),
        Map.entry("longitude", 5),
        Map.entry("latitude", 6),
        Map.entry("baro_altitude", 7),
        Map.entry("on_ground", 8),
        Map.entry("velocity", 9),
        Map.entry("heading", 10),
        Map.entry("vertical_rate", 11),
        Map.entry("sensors", 12),
        Map.entry("geo_altitude", 13),
        Map.entry("squawk", 14),
        Map.entry("spi", 15),
        Map.entry("position_source", 16) 
        
    );
    

    public long getTime() {
        return time;
    }

    public List<List<Object>> getStates() {
        return states;
    }

    @Override
    public String toString() {
        if (states == null || states.isEmpty()) {
            return "No aircraft states available.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Aircraft States (Extended):\n");

        for (List<Object> state : states) {
            if (state.size() < 17) {
                continue; // Skip incomplete states
            }

            // Extract and convert Times
            Object timePosObj = state.get(stateIndexMap.get("time_position"));
            String timePositionStr = "null";
            if (timePosObj instanceof Number) {
                long epochSec = ((Number) timePosObj).longValue();
                timePositionStr = LocalDateTime.ofEpochSecond(epochSec, 0, java.time.ZoneOffset.UTC).toString();
            }

            Object lastContactObj = state.get(stateIndexMap.get("last_contact"));
            String lastContactStr = "null";
            if (lastContactObj instanceof Number) {
                long epochSec = ((Number) lastContactObj).longValue();
                lastContactStr = LocalDateTime.ofEpochSecond(epochSec, 0, java.time.ZoneOffset.UTC).toString();
            }

            // Build the state string
            sb.append("  ICAO24: ").append(state.get(0))
              .append("\n Callsign: ").append(state.get(1))
              .append("\n Origin Country: ").append(state.get(2))
              .append("\n Time Position: ").append(timePositionStr)
              .append("\n Last Contact: ").append(lastContactStr)
              .append("\n Longitude: ").append(state.get(5))
              .append("\n Latitude: ").append(state.get(6))
              .append("\n Baro Altitude: ").append(state.get(7))
              .append("\n On Ground: ").append(state.get(8))
              .append("\n Velocity: ").append(state.get(9))
              .append("\n Heading: ").append(state.get(10))
              .append("\n Vertical Rate: ").append(state.get(11))
              .append("\n Sensors: ").append(state.get(12))
              .append("\n Geo Altitude: ").append(state.get(13))
              .append("\n Squawk: ").append(state.get(14))
              .append("\n SPI: ").append(state.get(15))
              .append("\n Position Source: ").append(state.get(16))
              .append("\n\n");
        }

        return sb.toString();
    }



    
}
