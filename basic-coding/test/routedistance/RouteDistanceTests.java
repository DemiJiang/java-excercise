package routedistance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RouteDistanceTests {

    @Test
    public void routeABCshouldreturn9(){
        RouteDistance routeDistance = new RouteDistance();
        String result = routeDistance.calculateDistance("A-B-C");
        assertEquals("9", result);
    }

    @Test
    public void routeADshouldreturn5(){
        RouteDistance routeDistance = new RouteDistance();
        String result = routeDistance.calculateDistance("A-D");
        assertEquals("5", result);
    }

    @Test
    public void routeADCshouldreturn13(){
        RouteDistance routeDistance = new RouteDistance();
        String result = routeDistance.calculateDistance("A-D-C");
        assertEquals("13", result);
    }

    @Test
    public void routeAEBCDshouldreturn22(){
        RouteDistance routeDistance = new RouteDistance();
        String result = routeDistance.calculateDistance("A-E-B-C-D");
        assertEquals("22", result);
    }

    @Test
    public void routeAEBCDshouldreturnNoSuchRoute(){
        RouteDistance routeDistance = new RouteDistance();
        String result = routeDistance.calculateDistance("A-E-D");
        assertEquals("NO SUCH ROUTE", result);
    }
}
