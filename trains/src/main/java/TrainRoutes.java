import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainRoutes {

    private static TrainMaps trainMaps = new TrainMaps(Constants.SAMPLE_GRAPH);

    //Q1 - Q5
    public String calculateRouteDistance(List<Town<String>> towns){
        int distance = 0;
        int currentIndex = 0;
        for (Town<String> town: towns){
            currentIndex = towns.indexOf(town);
            if(currentIndex < towns.size()-1){
                Town<String> nextTown = towns.get(currentIndex + 1);
                List<Route> routes = trainMaps.getTrainMaps().get(town);
                Route route = routes.stream()
                        .filter(x -> x.geTown().equals(nextTown))
                        .findFirst().orElse(null);
                if(null == route){
                    return Constants.NOT_FOUND;
                }else{
                    distance = distance + route.getDistance();
                }
            }
        }
      return String.valueOf(distance);
    }

    //Q6
    public String calculateTripsWithMaxStops(Town<String> start, Town<String> end, int maxStops){
        AtomicInteger counter = new AtomicInteger();
        Stack<Route> stack = new Stack<>();
        countTripsWithMaxStops(start, end, maxStops, stack, counter);
        return String.valueOf(counter);
    }

    public void countTripsWithMaxStops(Town<String> start, Town<String> end, int maxStops, Stack<Route> stack, AtomicInteger counter){
        if(stack.size() < maxStops){
            List<Route> routes = trainMaps.getTrainMaps().get(start);
            for(Route route : routes){
                Town<String> currentTown = route.geTown();
                if(currentTown.equals(end)){
                    counter.incrementAndGet();
                }
                stack.push(route);
                countTripsWithMaxStops(currentTown, end, maxStops, stack, counter);
                stack.pop();
            }
        }
    }

    //07
    public String calculateTripsWithExactlyStops(Town<String> start, Town<String> end, int stops){
        AtomicInteger counter = new AtomicInteger();
        Stack<Route> stack = new Stack<>();
        countTripsWithExactlyStops(start, end, stops, stack, counter);
        return String.valueOf(counter);

    }

    private void countTripsWithExactlyStops(Town<String> start, Town<String> end, int stops, Stack<Route> stack, AtomicInteger counter) {
        if(stack.size() < stops){
            List<Route> routes = trainMaps.getTrainMaps().get(start);
            for(Route route : routes){
                Town<String> currentTown = route.geTown();
                if(route.geTown().equals(end) && (stack.size() == stops -1)){
                    counter.incrementAndGet();
                }
                stack.push(route);
                countTripsWithExactlyStops(currentTown, end, stops, stack, counter);
                stack.pop();
            }
        }

    }


    public String calculateShorteseRoute(Town<String> start, Town<String> end){
        int minDistance = 0;
        Stack<Route> stack = new Stack<>();
        return String.valueOf(minDistance);
    }




}
