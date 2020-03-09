

import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TrainRoutesTest {

    TrainRoutes trainRoutes = new TrainRoutes();

    @Test
    public void distanceOfABCShouldBe9(){
        List<Town<String>> towns = new ArrayList<>();
        towns.add( new Town<>("A"));
        towns.add( new Town<>("B"));
        towns.add( new Town<>("C"));
        String result = trainRoutes.calculateRouteDistance(towns);
        assertEquals("9", result);
    }

    @Test
    public void distanceOfABCShouldbeNoSuchRoute(){
        List<Town<String>> towns = new ArrayList<>();
        towns.add( new Town<>("A"));
        towns.add( new Town<>("E"));
        towns.add( new Town<>("D"));
        String result = trainRoutes.calculateRouteDistance(towns);
        assertEquals(Constants.NOT_FOUND, result);
    }

    @Test
    public void noOfTripsStartCEndCWithMaxStopsShouldBe2(){
        String result = trainRoutes.calculateTripsWithMaxStops(new Town<>("C"),new Town<>("C"), 3);
        assertEquals("2", result);
    }

    @Test
    public void noOfTripsStartAEndCWithExactlyStopsShouldBe3(){
        String result = trainRoutes.calculateTripsWithExactlyStops(new Town<>("A"), new Town<>("C"), 4);
        assertEquals("3", result);
    }

    @Test
    public void shortestRouteFromAToCShouldBe9(){
        String result = trainRoutes.calculateShorteseRoute(new Town<>("A"), new Town<>("C"));
        assertEquals("9", result);
    }

    @Test
    public void shortestRouteFromBToBShouldBe9(){
        String result = trainRoutes.calculateShorteseRoute(new Town<>("B"), new Town<>("B"));
        assertEquals("9", result);
    }

    @Test
    public void differentRoutesFromCToCWithMaxDistance30Should7(){
        String result = trainRoutes.calculateDifferentRoutes(new Town<>("C"), new Town<>("C"), 30);
        assertEquals("7", result);
    }
}
