package com.zenika.business.impl;

import com.zenika.business.RoverBusiness;
import com.zenika.common.RoverException;
import com.zenika.domain.Rover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoverBusinessImpl implements RoverBusiness {

    private Rover rover;

    public RoverBusinessImpl() {
        this.rover = new Rover();
    }

    public void useRover(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void receiveSingleCommand(char command) throws RoverException {
        switch (Character.toUpperCase(command)) {
            case 'F':
                rover.moveForward();
                break;
            case 'B':
                rover.moveBackward();
                break;
            case 'R':
                rover.turnRight();
                break;
            case 'L':
                rover.turnLeft();
                break;
            default:
                throw new RoverException("unknown command :" + command);
        }
    }

    @Override
    public void receiveCommands(String commands) {
        for (char cmd : commands.toCharArray()) {
            try {
                this.receiveSingleCommand(cmd);
            } catch (RoverException e) {
                // Rover ignore unknown commands
                log.warn(e.getMessage());
                continue;
            }
        }
    }

    @Override
    public String getRoverCoordinate() {
        return rover.toString();
    }
}
