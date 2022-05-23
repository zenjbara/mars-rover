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

    public int getLocationToIncrement() {
        // edges are connected
        return (location == maxLocation) ? startLocation : location + 1;
    }

    public int getLocationToDecrement() {
        // edges are connected
        return (location == startLocation) ? maxLocation : location - 1;
    }

}
