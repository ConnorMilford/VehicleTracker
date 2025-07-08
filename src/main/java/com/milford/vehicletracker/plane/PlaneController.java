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

    
    @GetMapping("/planes")
    public ResponseEntity<PlaneResponse> getPlanes(@RequestParam(required=false, value="queries", defaultValue="") List<String> queries) {
        return planeService.queryPlanes(PlaneURIHelper.ConstructPlaneURIQueries(queries));
    }
}
