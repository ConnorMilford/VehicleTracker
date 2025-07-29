package com.milford.vehicletracker.plane;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestClient;
import com.milford.vehicletracker.location.GeocodeConverter;



/** Helper class for converting plane data */


public class PlaneConverter {
    
    private static int toInt(Object obj) {
        if (obj == null) return 0;
        if (obj instanceof Integer integer) return integer;
        if (obj instanceof Double aDouble) return aDouble.intValue();
        if (obj instanceof Number number) return number.intValue();
        return 0;
    }

    private static double toDouble(Object obj) {
        if (obj == null) return 0.0;
        if (obj instanceof Double aDouble) return aDouble;
        if (obj instanceof Number number) return number.doubleValue();
        return 0.0;
    }

    /**
     * Converts a List of Objects representing plane data into a PlaneDTO
     * @param planeData response body from OpenSkyNetwork API
     * @return PlaneDTO object populated with the data from the list
     */
    public static PlaneDTO convertToPlaneDTO(List<Object> planeData) {
        PlaneDTO plane = new PlaneDTO();

        if (planeData == null || planeData.isEmpty()) {
            return plane; 
        }

        plane.setIcao24((String) planeData.get(PlaneResponse.stateIndexMap.get("icao24")));
        plane.setCallsign((String) planeData.get(PlaneResponse.stateIndexMap.get("callsign")));
        plane.setOriginCountry((String) planeData.get(PlaneResponse.stateIndexMap.get("origin_country")));

        plane.setTime_position(convertToLocalDateTime(toInt(planeData.get(PlaneResponse.stateIndexMap.get("time_position")))));
        plane.setLast_contact(convertToLocalDateTime(toInt(planeData.get(PlaneResponse.stateIndexMap.get("last_contact")))));

        //TODO: Reverse geocode 
        double longitude = toDouble(planeData.get(PlaneResponse.stateIndexMap.get("longitude")));
        double latitude = toDouble(planeData.get(PlaneResponse.stateIndexMap.get("latitude")));
        

        GeocodeConverter geocodeConverter = new GeocodeConverter(RestClient.builder());
        String location = geocodeConverter.reverseGeocode(String.valueOf(latitude), String.valueOf(longitude));
        plane.setLocation(location);
        


        plane.setBaro_altitude(toDouble(planeData.get(PlaneResponse.stateIndexMap.get("baro_altitude"))));
        plane.setOn_ground(Boolean.TRUE.equals(planeData.get(PlaneResponse.stateIndexMap.get("on_ground"))));
        plane.setVelocity(toDouble(planeData.get(PlaneResponse.stateIndexMap.get("velocity"))));
        plane.setTrue_track(toDouble(planeData.get(PlaneResponse.stateIndexMap.get("heading"))));
        plane.setVertical_rate(toDouble(planeData.get(PlaneResponse.stateIndexMap.get("vertical_rate"))));
        
        // sensors are int array
        Object sensorsObj = planeData.get(PlaneResponse.stateIndexMap.get("sensors"));
        plane.setSensors(sensorsObj instanceof int[] ? (int[]) sensorsObj : null);
        plane.setGeo_altitude(toDouble(planeData.get(PlaneResponse.stateIndexMap.get("geo_altitude"))));
        plane.setSquawk((String) planeData.get(PlaneResponse.stateIndexMap.get("squawk")));
        plane.setSpi(Boolean.TRUE.equals(planeData.get(PlaneResponse.stateIndexMap.get("spi"))));
        plane.setPosition_source(toInt(planeData.get(PlaneResponse.stateIndexMap.get("position_source"))));

        Integer categoryIndex = PlaneResponse.stateIndexMap.get("category");
        if (categoryIndex != null && categoryIndex < planeData.size()) {
            plane.setCategory(toInt(planeData.get(categoryIndex)));
        }

        return plane;
    }


    public static List<PlaneDTO> convertResponsetoDTOs(List<List<Object>> planes) {
        List<PlaneDTO> planeDTOs = new ArrayList<>();

        for (List<Object> plane : planes){
            planeDTOs.add(PlaneConverter.convertToPlaneDTO(plane));
        }
        System.out.println(planeDTOs.toString());
        return planeDTOs;
    }

    public static LocalDateTime convertToLocalDateTime(long epochSeconds) {
        return LocalDateTime.ofEpochSecond(epochSeconds, 0, ZoneOffset.UTC);
    }

}
