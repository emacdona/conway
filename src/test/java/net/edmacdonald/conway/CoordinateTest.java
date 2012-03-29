package net.edmacdonald.conway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CoordinateTest {
    private Log log = LogFactory.getLog(CoordinateTest.class);

    @Test
    public void testNeighbors(){
        Coordinate coordinate = new Coordinate(0,0);
        log.info("Neighbors of " + coordinate + ": ");
        for(Coordinate neighbor : coordinate.getNeighbors()){
            log.info(neighbor);
        }
        Set<Coordinate> neighbors = coordinate.getNeighbors();
        Assert.assertEquals(neighbors.size(), 8);
        Assert.assertTrue(neighbors.contains(new Coordinate(-1, 1)));
        Assert.assertTrue(neighbors.contains(new Coordinate(-1, 0)));
        Assert.assertTrue(neighbors.contains(new Coordinate(-1, -1)));
        Assert.assertTrue(neighbors.contains(new Coordinate(0, 1)));
        Assert.assertTrue(neighbors.contains(new Coordinate(0, -1)));
        Assert.assertTrue(neighbors.contains(new Coordinate(1, 1)));
        Assert.assertTrue(neighbors.contains(new Coordinate(1, 0)));
        Assert.assertTrue(neighbors.contains(new Coordinate(1, -1)));
        Assert.assertFalse(neighbors.contains(new Coordinate(0, 0)));
    }

    @Test
    public void testCellWillLiveWithThreeNeighbors(){
        //Note that each of these has three neighbors
        Set<Coordinate> livingCells = new HashSet(
            Arrays.asList(
                new Coordinate(0,0),
                new Coordinate(1,0),
                new Coordinate(1,1)
        ));

        Assert.assertTrue(new Coordinate(0,0).correctAmountOfNeighborsToLive(livingCells));
        Assert.assertTrue(new Coordinate(1,0).correctAmountOfNeighborsToLive(livingCells));
        Assert.assertTrue(new Coordinate(0,1).correctAmountOfNeighborsToLive(livingCells));

        Assert.assertFalse(new Coordinate(-1,-1).correctAmountOfNeighborsToLive(livingCells));
    }

    @Test
    public void testCellWillConceiveLiveWithThreeNeighbors(){
        Set<Coordinate> livingCells = new HashSet(
                Arrays.asList(
                        new Coordinate(0,0),
                        new Coordinate(1,0),
                        new Coordinate(1,1)
                ));

        Assert.assertTrue(new Coordinate(0,1).correctAmountOfNeighborsToConcieve(livingCells));
    }
}
