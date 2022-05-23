package com.zenika.domain;

import lombok.Data;

@Data
public class Obstacle {
    private int x;
    private int y;


    public Obstacle(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
