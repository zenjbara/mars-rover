package com.zenika.domain;

import com.zenika.common.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rover {

    private int x;
    private int y;

    private Direction direction;

    /**
     * Move the rover one step forward depends on its direction
     */
    public void moveForward() {
        switch (direction){
            case NORTH:
                this.y++;
                break;
            case SOUTH:
                this.y--;
                break;
            case WEST:
                this.x++;
                break;
            case EAST:
                this.x--;
                break;
        }
    }

    public void moveBackward() {
        switch (direction){
            case NORTH:
                this.y--;
                break;
            case SOUTH:
                this.y++;
                break;
            case WEST:
                this.x--;
                break;
            case EAST:
                this.x++;
                break;
        }
    }

    public void turnRight() {
            this.direction = this.direction.getRightDirection();
    }

    public void turnLeft() {
        this.direction = this.direction.getLeftDirection();
    }
}
