package com.milford.vehicletracker.plane;

import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

public class PlaneURIHelper {

    public final static String PLANE_API_BASEURI = "https://opensky-network.org/api/states/all";

    public final static String GEOCODE_API_BASEURI = "https://nominatim.openstreetmap.org/reverse?"; // lat=<value>&lon=<value>&<params>

    /**
     * 
     * @param queries - ArrList in format {"lamin=50.03", "...=...", ...}
     * @return
     *    
     */

    public static String ConstructPlaneURIQueries(List<String> queries) {
        UriComponentsBuilder uriComponents 
         = UriComponentsBuilder.newInstance().fromUriString(PLANE_API_BASEURI);

         for (String query : queries) {
            uriComponents.query(query);
         }

         System.out.println("PlaneURIHelper.ConstructPlaneURIQueries: " + uriComponents.toUriString());
        return uriComponents.toUriString();
    }
    
}
