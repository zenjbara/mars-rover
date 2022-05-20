package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int location;
    private int maxLocation;

    private final int firstlocation = 1;

    public int incrementLocation() {
        // edges are connected
        location = (location == maxLocation) ? firstlocation : location + firstlocation;
        return location;
    }

    public int decrementLocation() {
        // edges are connected
        location = (location == firstlocation) ? maxLocation : location - firstlocation;
        return location;
    }

}
