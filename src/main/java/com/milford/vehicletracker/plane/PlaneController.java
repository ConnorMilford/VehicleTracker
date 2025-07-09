package com.milford.vehicletracker.plane;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlaneController {
    
    @Autowired
    private PlaneService planeService;

    //Examnple request:
    //http://localhost:8080/planes?queries=extended=1&queries=lomin=-1.0&queries=lamin=50.0&queries=lomax=4.0&queries=lamax=54.0

    //TODO: ENDPOINT IS CURRENTLY BLANK BUT WE ARE GETTING THERE.

    @GetMapping("/planes")
    public ResponseEntity<List<PlaneDTO>> getPlanes(@RequestParam(required=false, value="queries") List<String> queries) {
        System.out.println("PlaneController.getPlanes: " + queries);

        if (queries == null || queries.isEmpty()) {
            ResponseEntity.badRequest().build();
        }
        
        return ResponseEntity.ok(
            //TODO: PROCESS DATA BEFORE RESPONSE
            planeService.queryPlanes(PlaneURIHelper.ConstructPlaneURIQueries(queries))
        );
    }



    
}
