import java.util.*;

public class TrainMaps {
    private Map<Town<String>, List<Route>> trainMaps = new HashMap<>();

    public TrainMaps(String input){
        buildTrainMaps(input);
    }

    public void buildTrainMaps(String input){
        List<String> graphList = new ArrayList<>(Arrays.asList(input.split("\\s*,\\s*")));
        for (String string : graphList) {
            Town<String> town = new Town<>(string.substring(0,1));
            Town<String> routeTown = new Town<>(string.substring(1,2));
            Route route = new Route(routeTown, Integer.parseInt(string.substring(2)));
            trainMaps.putIfAbsent(town, new ArrayList<>());
            trainMaps.get(town).add(route);
        }
    }

    public Map<Town<String>, List<Route>> getTrainMaps() {
        return trainMaps;
    }
}
