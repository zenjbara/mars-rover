package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int location;
    private int maxLocation;

    // X and Y both have the same start point
    public static final int startLocation = 1;

    public int incrementLocation() {
        // edges are connected
        location = (location == maxLocation) ? startLocation : location + startLocation;
        return location;
    }

    public int decrementLocation() {
        // edges are connected
        location = (location == startLocation) ? maxLocation : location - startLocation;
        return location;
    }

}
