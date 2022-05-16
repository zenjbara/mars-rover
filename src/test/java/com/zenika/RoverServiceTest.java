package com.zenika;

import com.zenika.business.RoverBusiness;
import com.zenika.common.Direction;
import com.zenika.domain.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class RoverServiceTest {

    private Rover rover;
    private final int x = 1;
    private final int y = 2;

    @Autowired
    private RoverBusiness roverBusiness;

    @BeforeEach
    public void beforeRoverTest(){
        rover = new Rover(x,y, Direction.NORTH);
    }

    @Test
    public void should_move_forward_when_single_command_is_F() {
        int expectedY =  y + 1;
        roverBusiness.receiveSingleCommand(rover, 'F');
        assertThat(rover.getY()).isEqualTo(expectedY);
    }

}
