package com.zenika.business;

import com.zenika.domain.Rover;


public interface RoverBusiness {

    /**
     * Make the rover receive a single command
     * @param rover
     * @param command
     */
    void receiveSingleCommand(Rover rover, char command);
}
