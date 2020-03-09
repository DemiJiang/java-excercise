import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainRoutes {

    private static TrainMaps trainMaps = new TrainMaps(Constants.SAMPLE_GRAPH);

    //Q1-Q5 Route Distance
    public String calculateRouteDistance(List<Town<String>> towns) {
        int distance = 0;
        int currentIndex = 0;
        for (Town<String> town : towns) {
            currentIndex = towns.indexOf(town);
            if (currentIndex < towns.size() - 1) {
                Town<String> nextTown = towns.get(currentIndex + 1);
                List<Destination> destinations = trainMaps.getTrainMaps().get(town);
                Destination destination = destinations.stream()
                        .filter(x -> x.geTown().equals(nextTown))
                        .findFirst().orElse(null);
                if (null == destination) {
                    return Constants.NOT_FOUND;
                } else {
                    distance = distance + destination.getDistance();
                }
            }
        }
        return String.valueOf(distance);
    }

    //Q6 the number of trips with maximum stops
    public String calculateTripsWithMaxStops(Town<String> start, Town<String> end, int maxStops) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Destination> stack = new Stack<>();
        countTripsWithMaxStops(start, end, maxStops, stack, counter);
        return String.valueOf(counter);
    }

    public void countTripsWithMaxStops(Town<String> start, Town<String> end, int maxStops, Stack<Destination> stack, AtomicInteger counter) {
        if (stack.size() < maxStops) {
            List<Destination> destinations = trainMaps.getTrainMaps().get(start);
            for (Destination destination : destinations) {
                Town<String> currentTown = destination.geTown();
                if (currentTown.equals(end)) {
                    counter.incrementAndGet();
                }
                stack.push(destination);
                countTripsWithMaxStops(currentTown, end, maxStops, stack, counter);
                stack.pop();
            }
        }
    }

    //07 the number of trips with exactly stops
    public String calculateTripsWithExactlyStops(Town<String> start, Town<String> end, int stops) {
        AtomicInteger counter = new AtomicInteger();
        Stack<Destination> stack = new Stack<>();
        countTripsWithExactlyStops(start, end, stops, stack, counter);
        return String.valueOf(counter);

    }

    private void countTripsWithExactlyStops(Town<String> start, Town<String> end, int stops, Stack<Destination> stack, AtomicInteger counter) {
        if (stack.size() < stops) {
            List<Destination> destinations = trainMaps.getTrainMaps().get(start);
            for (Destination destination : destinations) {
                Town<String> currentTown = destination.geTown();
                if (destination.geTown().equals(end) && (stack.size() == stops - 1)) {
                    counter.incrementAndGet();
                }
                stack.push(destination);
                countTripsWithExactlyStops(currentTown, end, stops, stack, counter);
                stack.pop();
            }
        }

    }

    //Q8- Q9 the length of shortest route
    public String calculateShorteseRoute(Town<String> start, Town<String> end) {
        ThreadLocal<Integer> minDistance = new ThreadLocal<>();
        minDistance.set(Integer.MAX_VALUE);
        Stack<Town<String>> stack = new Stack<>();
        int sumDistance = 0;
        countShortestRoute(start, end, stack, minDistance, sumDistance);
        return minDistance.get().toString();
    }

    public void countShortestRoute(Town<String> start, Town<String> end, Stack<Town<String>> stack, ThreadLocal<Integer> minDistance, int sumDistance) {
        List<Destination> destinations = trainMaps.getTrainMaps().get(start);
        for (Destination destination : destinations) {
            Town<String> currentTown = destination.geTown();
            if (currentTown.equals(end)) {
                if (sumDistance + destination.getDistance() < minDistance.get()) {
                    minDistance.set(sumDistance + destination.getDistance());
                    continue;
                }
            }

            if (!stack.contains(currentTown)) {
                stack.push(currentTown);
                sumDistance += destination.getDistance();
                countShortestRoute(currentTown, end, stack, minDistance, sumDistance);
                sumDistance -= destination.getDistance();
                stack.pop();
            }
        }
    }

    //calculate different routes
    public String calculateDifferentRoutes(Town<String> start, Town<String> end, int maxDistance){
        AtomicInteger counter = new AtomicInteger();
        int sumDistance = 0;
        countDifferentRoutes(start, end, maxDistance, counter, sumDistance);
        return String.valueOf(counter);
    }

    public void countDifferentRoutes(Town<String> start, Town<String> end, int maxDistance, AtomicInteger counter, int sumDistance){
        List<Destination> destinations = trainMaps.getTrainMaps().get(start);
        for(Destination destination : destinations){
            Town<String> currentTown = destination.geTown();

            if(sumDistance + destination.getDistance() >= maxDistance){
                continue;
            }
            if(currentTown.equals(end)){
                counter.incrementAndGet();
            }

            sumDistance += destination.getDistance();
            countDifferentRoutes(currentTown, end, maxDistance, counter, sumDistance);
            sumDistance -= destination.getDistance();

        }
    }
}

