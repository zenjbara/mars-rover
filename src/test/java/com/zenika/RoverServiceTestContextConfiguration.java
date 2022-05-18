package com.zenika;

import com.zenika.common.Direction;
import com.zenika.domain.Rover;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class RoverServiceTestContextConfiguration {

    @Value("${rover.coordinate.x}")
    private int x;

    @Value("${rover.coordinate.y}")
    private int y;

    /**
     * Customized Rover bean
     */
    @Primary
    @Bean
    public Rover getRover() {
        return new Rover(x, y, Direction.NORTH);
    }
}
