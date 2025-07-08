package com.milford.vehicletracker.plane;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service

/** Class to query OpenSkyNetwork API **/

public class PlaneService {

    private final RestClient restClient;

    public PlaneService(RestClient.Builder builder) {
        this.restClient = builder
                        .baseUrl(PlaneURIHelper.BASEURI)
                        .build();
    }

     public ResponseEntity<PlaneResponse> queryPlanes(String planesUri) {
        PlaneResponse response = restClient.get()
            .uri(planesUri)
            .retrieve()
            .body(PlaneResponse.class);

        return ResponseEntity.ok(response);
    }

}
