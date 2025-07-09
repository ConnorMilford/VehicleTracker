package com.milford.vehicletracker.plane;

import java.util.ArrayList;
import java.util.List;

public class PlaneConverter {
    
    public static PlaneDTO convertToPlaneDTO(List<Object> planeData) {
        PlaneDTO plane = new PlaneDTO();
        
        if (planeData.size() < 17) {
            throw new IllegalArgumentException();
        }
        
        plane.setCallsign((String) planeData.get(1));
        plane.setOriginCountry((String) planeData.get(2));
        plane.setLatitude((Double) planeData.get(6));
        plane.setLongitude((Double) planeData.get(5));
        plane.setAltitude((Double) planeData.get(7));
        plane.setVelocity((Double) planeData.get(9));
        plane.setHeading((Double) planeData.get(10));
        plane.setOnGround((Boolean) planeData.get(8));
        
        return plane;
    }

    public static List<PlaneDTO> convertResponsetoDTO(List<List<Object>> planes) {
        List<PlaneDTO> planeDTOs = new ArrayList<>();

        for (List<Object> plane : planes){
            planeDTOs.add(PlaneConverter.convertToPlaneDTO(plane));
        }
        return planeDTOs;
    }

}
