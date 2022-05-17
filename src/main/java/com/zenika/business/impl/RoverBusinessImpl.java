package com.zenika.business.impl;

import com.zenika.business.RoverBusiness;
import com.zenika.common.RoverException;
import com.zenika.domain.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoverBusinessImpl implements RoverBusiness {

    @Autowired
    private Rover rover;

    @Override
    public void receiveSingleCommand(char command) throws RoverException {
        switch (Character.toUpperCase(command)){
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
    public void receiveCommands(String commands) throws RoverException {
        for (char cmd : commands.toCharArray()) {
            this.receiveSingleCommand(cmd);
        }
    }
}
