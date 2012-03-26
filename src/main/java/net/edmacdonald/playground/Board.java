package net.edmacdonald.playground;

import java.util.Set;

public class Board {
    private Set<Coordinate> livingCells;

    public Board(Set<Coordinate> livingCells) {
        this.livingCells = livingCells;
    }
}
