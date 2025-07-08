package com.milford.vehicletracker.plane;

import java.util.List;
import java.util.Map;

import com.milford.vehicletracker.Response;


public class PlaneResponse extends Response {

    private long time;

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
    
    private List<List<Object>> states;

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
            sb.append(" - ICAO24: ").append(state.get(0))
            .append(", Callsign: ").append(state.get(1))
            .append(", Origin Country: ").append(state.get(2))
            .append(", Time Position: ").append(state.get(3))
            .append(", Last Contact: ").append(state.get(4))
            .append(", Longitude: ").append(state.get(5))
            .append(", Latitude: ").append(state.get(6))
            .append(", Baro Altitude: ").append(state.get(7))
            .append(", On Ground: ").append(state.get(8))
            .append(", Velocity: ").append(state.get(9))
            .append(", Heading: ").append(state.get(10))
            .append(", Vertical Rate: ").append(state.get(11))
            .append(", Sensors: ").append(state.get(12))
            .append(", Geo Altitude: ").append(state.get(13))
            .append(", Squawk: ").append(state.get(14))
            .append(", SPI: ").append(state.get(15))
            .append(", Position Source: ").append(state.get(16))
            .append("\n\n");
        }

        return sb.toString();
    }



    
}
