package com.milford.vehicletracker.plane;

import java.beans.JavaBean;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@JavaBean
@Getter
@Setter

public class PlaneDTO implements Serializable {
    
    private String icao24;
    private String callsign;
    private String originCountry;
    private LocalDateTime time_position;
    private LocalDateTime last_contact;
    private double longitude;
    private double latitude;
    private double baro_altitude;
    private boolean on_ground;
    private double velocity;
    private double true_track;
    private double vertical_rate;
    private int[] sensors;
    private double geo_altitude;
    private String squawk;
    private Boolean spi;
    private int position_source;
    private int category;

    private String realLocation; // Based on lat, long reverseGeocoding.
}
