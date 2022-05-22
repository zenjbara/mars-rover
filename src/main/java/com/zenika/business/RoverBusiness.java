package com.zenika.business;


import com.zenika.common.RoverException;
import com.zenika.domain.Rover;

public interface RoverBusiness {

    public void initRover(Rover rover);

    /**
     * Make the rover receive a single command
     *
     * @param command
     */
    public void receiveSingleCommand(char command) throws RoverException;

    /**
     * Make the rover receive multiple commands
     *
     * @param commands
     */
    public void receiveCommands(String commands);
}
