package com.zenika.domain;

import com.zenika.common.Direction;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rover {

    private int x;
    private int y;

    private Direction direction;

}
