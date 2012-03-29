package net.edmacdonald.conway;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class BoardTest {
    Log log = LogFactory.getLog(BoardTest.class);

    @Test
    public void testThreeBoxAngleBecomesSquareAndHoldsForThreeTicks(){
        Board board = new Board(
                new HashSet<Coordinate>(
                        Arrays.asList(
                                new Coordinate(0,0),
                                new Coordinate(1,0),
                                new Coordinate(1,1))));

        log.info("Initial living coordinates: " + board.getLivingCells());

        Assert.assertEquals(3, board.getLivingCells().size(), "Wrong number of living cells to start with.");

        for(int i=0; i<3; i++){
            board.tick();
            Assert.assertEquals(4, board.getLivingCells().size());
            Assert.assertTrue(board.getLivingCells().contains(new Coordinate(0,0)), "<0,0> should be alive.");
            Assert.assertTrue(board.getLivingCells().contains(new Coordinate(0,1)), "<0,1> should be alive.");
            Assert.assertTrue(board.getLivingCells().contains(new Coordinate(1,1)), "<1,1> should be alive.");
            Assert.assertTrue(board.getLivingCells().contains(new Coordinate(1,0)), "<1,0> should be alive.");
        }
    }

    @Test
    public void testBeaconOscillatorForThreeOscillations(){
        List<Set<Coordinate>> beacon = getBeaconOscillations();
        Board board = new Board(beacon.get(0));
        int period = beacon.size();

        for(int i=0; i < period * 3; i++) {
            log.info("Tick # " + i);
            log.info("Expected (size: " + beacon.get(i % period).size()  + "): " + beacon.get(i % period));
            log.info("Actual (size: " + board.getLivingCells().size() + "): " + board.getLivingCells());
            Assert.assertEquals(beacon.get(i % period), board.getLivingCells());
            board.tick();
        }
    }

    private List<Set<Coordinate>> getBeaconOscillations() {
        List<Set<Coordinate>> oscillations = new ArrayList<Set<Coordinate>>();

        Set<Coordinate> oscillationA = new HashSet<Coordinate>(
                Arrays.asList(
                        new Coordinate(0,-1),
                        new Coordinate(0,-2),
                        new Coordinate(1,-1),
                        new Coordinate(1,-2),

                        new Coordinate(-1,0),
                        new Coordinate(-1,1),
                        new Coordinate(-2,0),
                        new Coordinate(-2,1)
                )
        );

        Set<Coordinate> oscillationB = new HashSet<Coordinate>(
                Arrays.asList(
                        new Coordinate(0,-2),
                        new Coordinate(1,-1),
                        new Coordinate(1,-2),

                        new Coordinate(-1,1),
                        new Coordinate(-2,0),
                        new Coordinate(-2,1)
                )
        );

        oscillations.add(oscillationA);
        oscillations.add(oscillationB);

        return oscillations;
    }
}
