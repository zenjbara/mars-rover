package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int location;
    private int maxLocation;

    private final int firstLocation = 1;

    public int incrementLocation() {
        // edges are connected
        location = (location == maxLocation) ? firstLocation : location + firstLocation;
        return location;
    }

    public int decrementLocation() {
        // edges are connected
        location = (location == firstLocation) ? maxLocation : location - firstLocation;
        return location;
    }

}
