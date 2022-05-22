package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {

    // X and Y both have the same start point
    public static final int startLocation = 1;

    private int location;
    private int maxLocation;

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
