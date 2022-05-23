package com.zenika.domain;

import com.zenika.common.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Rover {

    public Rover() {
        // initiate rover with default values (Mars size doesnt change to much)
        this.xPoint = new Point(Point.startLocation, 5);
        this.yPoint = new Point(Point.startLocation, 5);
        this.direction = Direction.NORTH;
        this.obstacles = new ArrayList<>();
    }

    private Point xPoint;
    private Point yPoint;
    private Direction direction;
    private List<Obstacle> obstacles;

    /**
     * Move the rover one step forward depends on its direction
     */
    public void moveForward() {
        int xLocation = xPoint.getLocation();
        int yLocation = yPoint.getLocation();
        int nextLocation;

        switch (direction) {
            case NORTH:
                nextLocation = yPoint.getLocationToIncrement();
                if (!hasObstacle(xLocation, nextLocation)) {
                    yPoint.setLocation(nextLocation);
                }
                break;
            case SOUTH:
                nextLocation = yPoint.getLocationToDecrement();
                if (!hasObstacle(nextLocation, yLocation)) {
                    yPoint.setLocation(nextLocation);
                }
                break;
            case WEST:
                nextLocation = xPoint.getLocationToIncrement();
                if (!hasObstacle(nextLocation, yLocation)) {
                    xPoint.setLocation(nextLocation);
                }
                break;
            case EAST:
                nextLocation = xPoint.getLocationToDecrement();
                if (!hasObstacle(xLocation, nextLocation)) {
                    xPoint.setLocation(nextLocation);
                }
                break;
        }
    }

    public void moveBackward() {
        int xLocation = xPoint.getLocation();
        int yLocation = yPoint.getLocation();
        int nextLocation;
        switch (direction) {
            case NORTH:
                nextLocation = yPoint.getLocationToDecrement();
                if (!hasObstacle(xLocation, nextLocation)) {
                    yPoint.setLocation(nextLocation);
                }
                break;
            case SOUTH:
                nextLocation = yPoint.getLocationToIncrement();
                if (!hasObstacle(xLocation, nextLocation)) {
                    yPoint.setLocation(nextLocation);
                }
                break;
            case WEST:
                nextLocation = xPoint.getLocationToDecrement();
                if (!hasObstacle(nextLocation, yLocation)) {
                    xPoint.setLocation(nextLocation);
                }
                break;
            case EAST:
                nextLocation = xPoint.getLocationToIncrement();
                if (!hasObstacle(nextLocation, yLocation)) {
                    xPoint.setLocation(nextLocation);
                }
                break;
        }
    }

    public boolean hasObstacle(int x, int y) {
        boolean hasObstacle = obstacles.stream().anyMatch(
                obstacle -> obstacle.getX() == x &&
                        obstacle.getY() == y
        );

        return hasObstacle;
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
