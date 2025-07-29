package com.milford.vehicletracker.location;

import java.util.List;

import org.springframework.web.client.RestClient;

import com.milford.vehicletracker.plane.PlaneURIHelper;

public class GeocodeConverter {

    private final RestClient restClient;

    public GeocodeConverter(RestClient.Builder builder) {
         this.restClient = builder
                        .baseUrl(PlaneURIHelper.GEOCODE_API_BASEURI)
                        .build();
    }

    //TODO: WORKING BUT SENDS TOO MANY REQUESTS
    public String reverseGeocode(String lat, String longi) {
        System.out.println("Calling: " + PlaneURIHelper.GEOCODE_API_BASEURI + "/lat=" + lat + "&lon=" + longi);
        String response = restClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("lat", lat)
                .queryParam("lon", longi)
                .build())
            .retrieve()
            .body(String.class);

        return response;
     }
    
}
