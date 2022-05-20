package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int location;
    private int maxLocation;

    public int incrementLocation() {
        location = (location == maxLocation) ? 1 : location + 1;
        return location;
    }

    public int decrementLocation() {
        location = (location == 1) ? maxLocation : location - 1;
        return location;
    }

}
