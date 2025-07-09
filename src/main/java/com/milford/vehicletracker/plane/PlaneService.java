package com.milford.vehicletracker.plane;


import java.util.List;

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


     public List<PlaneDTO> queryPlanes(String planesUri) {
        PlaneResponse response = restClient.get()
            .uri(planesUri)
            .retrieve()
            .body(PlaneResponse.class);

        if (response == null || response.getPlanes() == null) {
            return List.of();
        }

        return PlaneConverter.convertResponsetoDTO(response.getPlanes());
    }

    

}
