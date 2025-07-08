package com.milford.vehicletracker.plane;

import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

public class PlaneURIHelper {

    public final static String BASEURI = "https://opensky-network.org/api/states/all";

    /**
     * 
     * @param queries - ArrList in format {"lamin=50.03", "...=...", ...}
     * @return
     *    
     */

    public static String ConstructPlaneURIQueries(List<String> queries) {
        UriComponentsBuilder uriComponents 
         = UriComponentsBuilder.newInstance().fromUriString(BASEURI);

         for (String query : queries) {
            uriComponents.query(query);
         }

        return uriComponents.toUriString();
    }
    
}
