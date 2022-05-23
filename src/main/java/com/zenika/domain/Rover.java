package com.zenika.domain;

import com.zenika.common.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Rover {

    public Rover() {
        // initiate rover with default values (Mars size doesnt change to much)
        this.xPoint = new Point(Point.startLocation, 5);
        this.yPoint = new Point(Point.startLocation, 5);
        this.direction = Direction.NORTH;
    }

    private Point xPoint;
    private Point yPoint;
    private Direction direction;
    private List<Obstacle> obstacles;

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

    @Override
    public String toString() {
        return "(" + xPoint.getLocation() + "," + yPoint.getLocation() + ") --- " +
                "xPoint=" + xPoint +
                ", yPoint=" + yPoint +
                ", direction=" + direction;
    }
}
