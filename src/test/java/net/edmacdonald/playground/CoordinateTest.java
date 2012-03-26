package net.edmacdonald.playground;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CoordinateTest {
    private Log log = LogFactory.getLog(CoordinateTest.class);

    @Test
    public void testNeighbors(){
        Coordinate coordinate = new Coordinate(0,0);
        for(Coordinate neighbor : coordinate.getNeighborsAndSelf()){
            log.info(neighbor);
        }
        Assert.assertEquals(coordinate.getNeighborsAndSelf().size(), 9);
    }
}
