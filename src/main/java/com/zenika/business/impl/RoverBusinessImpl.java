package com.zenika.business.impl;

import com.zenika.business.RoverBusiness;
import com.zenika.domain.Rover;
import org.springframework.stereotype.Service;

@Service
public class RoverBusinessImpl implements RoverBusiness {


    @Override
    public void receiveSingleCommand(Rover rover, char command) throws Exception {
        switch (Character.toUpperCase(command)){
            case 'F':
                rover.moveForward();
                break;
            default:
                throw new Exception("unknown command :" + command);
        }
    }
}
