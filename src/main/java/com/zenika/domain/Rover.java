package com.zenika.domain;

import com.zenika.common.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Rover {

    public Rover() {
    }

    private Point xPoint;
    private Point yPoint;

    private Direction direction;

    /**
     * Move the rover one step forward depends on its direction
     */
    public void moveForward() {
        switch (direction) {
            case NORTH:
                yPoint.incrementLocation();
                break;
            case SOUTH:
                yPoint.decrementLocation();
                break;
            case WEST:
                xPoint.incrementLocation();
                break;
            case EAST:
                xPoint.decrementLocation();
                break;
        }
    }

    public void moveBackward() {
        switch (direction){
            case NORTH:
                yPoint.decrementLocation();
                break;
            case SOUTH:
                yPoint.incrementLocation();
                break;
            case WEST:
                xPoint.decrementLocation();
                break;
            case EAST:
                xPoint.incrementLocation();
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
