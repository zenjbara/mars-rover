package com.zenika.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int location;
    private int maxLocation;

    public int incrementLocation() {
        return location++;
    }

    public int decrementLocation() {
        return location--;
    }

}
