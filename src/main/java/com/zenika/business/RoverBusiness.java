package com.zenika.business;


import com.zenika.common.RoverException;
import com.zenika.domain.Rover;

public interface RoverBusiness {

    /**
     * Make the rover receive a single command
     * @param command
     */
    void receiveSingleCommand(char command) throws RoverException;

    /**
     * Make the rover receive multiple commands
     * @param frb
     */
    void receiveCommands(String frb);
}
