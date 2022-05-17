package com.zenika.common;

public enum Direction {

    NORTH(0),
    WEST(1),
    SOUTH(2),
    EAST(3);

    int value;

    Direction(int v) {
        this.value  = v;
    }


    public Direction getRightDirection() {

        if(this.getValue() == 3){
            return values()[0];
        }

        return values()[this.getValue() + 1];
    }

    public int getValue() {
        return value;
    }

}
