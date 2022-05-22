package com.zenika.controller;

import com.zenika.business.impl.RoverBusinessImpl;
import com.zenika.common.dto.LocationCommandsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rover/coordinate")
public class roverController {

    @Autowired
    private RoverBusinessImpl roverBusiness;

    /**
     * @param locationCommands
     * @return send instructions to the rover
     */
    @PostMapping()
    public ResponseEntity<String> moveRover(@RequestBody LocationCommandsDTO locationCommands) {
        roverBusiness.receiveCommands(locationCommands.getCommands());

        String roverCoordinate = roverBusiness.getRoverCoordinate();
        return new ResponseEntity<>(roverCoordinate, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<String> getRoverCoordinate() {
        String roverCoordinate = roverBusiness.getRoverCoordinate();
        return new ResponseEntity<>(roverCoordinate, HttpStatus.OK);
    }

}
