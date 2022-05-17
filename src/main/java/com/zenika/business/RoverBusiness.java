package com.zenika.business;


import com.zenika.common.RoverException;

public interface RoverBusiness {

    /**
     * Make the rover receive a single command
     * @param command
     */
    void receiveSingleCommand(char command) throws RoverException;

    /**
     * Make the rover receive multiple commands
     *
     * @param commands
     */
    void receiveCommands(String commands);
}
