package com.zenika;

import com.zenika.business.RoverBusiness;
import com.zenika.common.Direction;
import com.zenika.common.RoverException;
import com.zenika.domain.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoverServiceTest {

    private int x = 1;
    private int y = 3;

    @Autowired
    private Rover rover;

    @Autowired
    private RoverBusiness roverBusiness;

    @BeforeEach
    public void beforeRoverTest() {
        rover.setX(this.x);
        rover.setY(this.y);
        rover.setDirection(Direction.NORTH);
    }

    @Test
    public void should_move_forward_when_single_command_is_F() throws RoverException {
        moveForward();
        assertThat(rover.getY()).isEqualTo(y + 1);

        rover.setDirection(Direction.WEST);
        moveForward();
        assertThat(rover.getX()).isEqualTo(x + 1);

        rover.setDirection(Direction.SOUTH);
        moveForward();
        assertThat(rover.getY()).isEqualTo(y);

        rover.setDirection(Direction.EAST);
        moveForward();
        assertThat(rover.getX()).isEqualTo(x);
        assertThat(rover.getY()).isEqualTo(y); // Y should not change
    }

    private void moveForward() throws RoverException {
        roverBusiness.receiveSingleCommand('F');
    }

    @Test
    public void should_move_backward_when_single_command_is_B() throws RoverException {
        moveBackward();
        assertThat(rover.getY()).isEqualTo(y - 1);

        rover.setDirection(Direction.WEST);
        moveBackward();
        assertThat(rover.getX()).isEqualTo(x - 1);

        rover.setDirection(Direction.SOUTH);
        moveBackward();
        assertThat(rover.getY()).isEqualTo(y);
        assertThat(rover.getX()).isEqualTo(x - 1); // X should not change

        rover.setDirection(Direction.EAST);
        moveBackward();
        assertThat(rover.getX()).isEqualTo(x);

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
        assertThat(rover.getX()).isEqualTo(x - 1);
        assertThat(rover.getY()).isEqualTo(y + 1);
    }

    @Test
    public void should_be_able_to_escape_unknown_command() {
        char unknownCmd = 'Z';
        roverBusiness.receiveCommands(unknownCmd + "RB");
        assertThat(rover.getDirection()).isEqualTo(Direction.WEST);
        assertThat(rover.getX()).isEqualTo(x - 1);
        assertThat(rover.getY()).isEqualTo(y);
    }

}
