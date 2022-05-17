package com.zenika.business.impl;

import com.zenika.business.RoverBusiness;
import com.zenika.domain.Rover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoverBusinessImpl implements RoverBusiness {

    @Autowired
    private Rover rover;

    @Override
    public void receiveSingleCommand(char command) throws Exception {
        switch (Character.toUpperCase(command)){
            case 'F':
                rover.moveForward();
                break;
            case 'B':
                rover.moveBackward();
                break;
            default:
                throw new Exception("unknown command :" + command);
        }
    }
}
