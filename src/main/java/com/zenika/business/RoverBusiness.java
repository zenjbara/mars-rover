package com.zenika.business;


import com.zenika.common.RoverException;
import com.zenika.domain.Rover;

public interface RoverBusiness {

    /**
     * use the @param rover rather than the default
     */
    public void useRover(Rover rover);

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

    /**
     * @return rover location and direction
     */
    public String getRoverCoordinate();
}
