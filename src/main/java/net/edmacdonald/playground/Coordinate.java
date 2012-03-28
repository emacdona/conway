package net.edmacdonald.playground;

import com.google.common.collect.Collections2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coordinate {
    private int x;
    private int y;
    private Set<Integer> deltas = new HashSet<Integer>(Arrays.asList(-1, 0, 1));

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Set<Coordinate> getNeighbors() {
        Set<Coordinate> neighbors = new HashSet<Coordinate>();
        for(Pair<Integer, Integer> delta : new PermutationBuilder<Integer>(deltas).getPermutation()){
            neighbors.add(new Coordinate(x + delta.first.intValue(), y + delta.second.intValue()));
        }
        neighbors.remove(new Coordinate(x, y));
        return neighbors;
    }

    public boolean correctAmountOfNeighborsToLive(Set<Coordinate> livingCells) {
        Set<Coordinate> neighbors = getNeighbors();
        neighbors.retainAll(livingCells);
        return neighbors.size() == 2 || neighbors.size() == 3;
    }

    public boolean correctAmountOfNeighborsToConcieve(Set<Coordinate> livingCells){
        Set<Coordinate> neighbors = getNeighbors();
        neighbors.retainAll(livingCells);
        return neighbors.size() == 3;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "<" + x + ", " + y + '>';
    }
}
