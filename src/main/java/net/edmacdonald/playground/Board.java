package net.edmacdonald.playground;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Board {
    private Set<Coordinate> livingCells;
    private Set<Coordinate> nonLivingNeighbors;

    public Board(Set<Coordinate> livingCells) {
        this.livingCells = livingCells;
        resetNonLivingNeighbors();
    }

    public void resetNonLivingNeighbors(){
        nonLivingNeighbors = new HashSet<Coordinate>();
        for(Coordinate livingCell : livingCells){
            nonLivingNeighbors.addAll(livingCell.getNeighbors());
        }
        final Set<Coordinate> livingCellsCopy = new HashSet<Coordinate>(livingCells);
        nonLivingNeighbors = new HashSet<Coordinate>(
                Collections2.filter(nonLivingNeighbors, new Predicate<Coordinate>() {
                    @Override
                    public boolean apply( Coordinate input) {
                        return !livingCellsCopy.contains(input);
                    }
                }));
    }

    public void tick(){
        Set<Coordinate> nextGenerationLivingCells = new HashSet<Coordinate>();
        resetNonLivingNeighbors();

        for(Coordinate coordinate : livingCells){
            if(coordinate.correctAmountOfNeighborsToLive(livingCells)){
                nextGenerationLivingCells.add(coordinate);
            }
        }

        for(Coordinate coordinate : nonLivingNeighbors){
            if(coordinate.correctAmountOfNeighborsToConcieve(livingCells)){
                nextGenerationLivingCells.add(coordinate);
            }
        }

        livingCells = nextGenerationLivingCells;
    }

    public Set<Coordinate> getLivingCells() {
        return livingCells;
    }
}
