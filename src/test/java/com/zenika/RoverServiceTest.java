package com.zenika;

import com.zenika.business.RoverBusiness;
import com.zenika.common.Direction;
import com.zenika.common.RoverException;
import com.zenika.domain.Point;
import com.zenika.domain.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoverServiceTest {

    private static final int MAX_X_LOCATION = 5;
    private static final int MAX_Y_LOCATION = 6;
    private static final int X = MAX_X_LOCATION - 1; // not edge
    private static final int Y = MAX_Y_LOCATION - 2;

    private Rover rover = new Rover();

    @Autowired
    private RoverBusiness roverBusiness;

    @BeforeEach
    public void beforeRoverTest() {
        rover.setXPoint(new Point(X, MAX_X_LOCATION));
        rover.setYPoint(new Point(Y, MAX_Y_LOCATION));
        rover.setDirection(Direction.NORTH);

        roverBusiness.useRover(rover);
    }

    @Test
    public void should_move_forward_when_single_command_is_F() throws RoverException {
        moveForward();
        assertThat(getRoverLocationY()).isEqualTo(Y + 1);

        rover.setDirection(Direction.WEST);
        moveForward();
        assertThat(getRoverLocationX()).isEqualTo(X + 1);

        rover.setDirection(Direction.SOUTH);
        moveForward();
        assertThat(getRoverLocationY()).isEqualTo(Y);

        rover.setDirection(Direction.EAST);
        moveForward();
        assertThat(getRoverLocationX()).isEqualTo(X);
        assertThat(getRoverLocationY()).isEqualTo(Y); // Y should not change
    }

    private int getRoverLocationX() {
        return rover.getXPoint().getLocation();
    }

    private int getRoverLocationY() {
        return rover.getYPoint().getLocation();
    }

    private void moveForward() throws RoverException {
        roverBusiness.receiveSingleCommand('F');
    }

    @Test
    public void should_move_backward_when_single_command_is_B() throws RoverException {
        moveBackward();
        assertThat(getRoverLocationY()).isEqualTo(Y - 1);

        rover.setDirection(Direction.WEST);
        moveBackward();
        assertThat(getRoverLocationX()).isEqualTo(X - 1);

        rover.setDirection(Direction.SOUTH);
        moveBackward();
        assertThat(getRoverLocationY()).isEqualTo(Y);
        assertThat(getRoverLocationX()).isEqualTo(X - 1); // X should not change

        rover.setDirection(Direction.EAST);
        moveBackward();
        assertThat(getRoverLocationX()).isEqualTo(X);

    }

    private void moveBackward() throws RoverException {
        roverBusiness.receiveSingleCommand('B');
    }

    @Test
    public void should_turn_right_when_single_command_is_R() throws RoverException {
        Direction expectedDirection = Direction.WEST;
        roverBusiness.receiveSingleCommand('R');

        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }

    @Test
    public void should_turn_left_when_single_command_is_L() throws RoverException {
        Direction expectedDirection =  Direction.EAST;
        roverBusiness.receiveSingleCommand('L');

        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }

    @Test
    public void should_throw_exception_when_command_id_unknown() {
        Assertions.assertThrows(RoverException.class, () -> {
            roverBusiness.receiveSingleCommand('X');
        }, "RoverException was expected");
    }

    @Test
    public void should_be_able_to_receive_multiple_commands() {
        roverBusiness.receiveCommands("FRB");

        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
        assertThat(getRoverLocationX()).isEqualTo(X - 1);
        assertThat(getRoverLocationY()).isEqualTo(Y + 1);
    }

    @Test
    public void should_be_able_to_escape_unknown_command() {
        char unknownCommand = 'Z';
        roverBusiness.receiveCommands(unknownCommand + "RB");

        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
        assertThat(getRoverLocationX()).isEqualTo(X - 1);
        assertThat(getRoverLocationY()).isEqualTo(Y);
    }

    /**
     * The x edge should be connected to the other x edge
     */
    @Test
    public void should_connect_horizontal_edges() throws RoverException {
        this.rover.setDirection(Direction.EAST);

        this.rover.getXPoint().setLocation(Point.startLocation);
        moveForward();
        assertThat(getRoverLocationX()).isEqualTo(MAX_X_LOCATION);

        moveBackward();
        assertThat(getRoverLocationX()).isEqualTo(Point.startLocation);
    }

    /**
     * Vertical edges should be connected in inverted coordinates
     */
    @Test
    public void should_connect_vertical_edges() throws RoverException {
        this.rover.getYPoint().setLocation(Point.startLocation);
        moveBackward();
        assertThat(getRoverLocationY()).isEqualTo(MAX_Y_LOCATION);

        moveForward();
        assertThat(getRoverLocationY()).isEqualTo(Point.startLocation);
    }
}
