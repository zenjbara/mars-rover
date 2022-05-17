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
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(RoverServiceTestContextConfiguration.class)
public class RoverServiceTest {

    @Autowired
    private Rover rover;

    @Autowired
    private RoverBusiness roverBusiness;

    private int x;

    private int y;

    @BeforeEach
    public void beforeRoverTest(){
        x = rover.getX();
        y = rover.getY();
        rover.setDirection(Direction.NORTH); // always to the north
    }

    @Test
    public void should_move_forward_when_single_command_is_F() throws Exception {
        int expectedY =  y + 1;
        roverBusiness.receiveSingleCommand('F');
        assertThat(rover.getY()).isEqualTo(expectedY);
    }

    @Test
    public void should_move_backward_when_single_command_is_B() throws Exception {
        int expectedY =  y - 1;
        roverBusiness.receiveSingleCommand('B');
        assertThat(rover.getY()).isEqualTo(expectedY);
    }

    @Test
    public void should_turn_right_when_single_command_is_R() throws Exception {
        Direction expectedDirection =  Direction.WEST;
        roverBusiness.receiveSingleCommand('R');
        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }

    @Test
    public void should_turn_left_when_single_command_is_L() throws Exception {
        Direction expectedDirection =  Direction.EAST;
        roverBusiness.receiveSingleCommand('L');
        assertThat(rover.getDirection()).isEqualTo(expectedDirection);
    }

    @Test
    public void should_throw_exception_when_command_id_unknown() {

        Assertions.assertThrows(RoverException.class, () -> {
            roverBusiness.receiveSingleCommand('X');
        } , "RoverException was expected");
    }

}
