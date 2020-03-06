import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> listofGraph = new ArrayList<>(Arrays.asList(Constants.SAMPLE_GRAPH.split("[\\s]*,[\\s]*")));
        List<String> listofGraph2 = new ArrayList<>(Arrays.asList(Constants.SAMPLE_GRAPH.split("\\s*,\\s*")));

        System.out.println(listofGraph);
        System.out.println(listofGraph2);

        String test = "AB5";
        System.out.println(test.substring(0,1));
        System.out.println(test.substring(1,2));
        System.out.println(test.substring(2,3));

        TrainMaps map = new TrainMaps(Constants.SAMPLE_GRAPH);
        for(Map.Entry m:map.getTrainMaps().entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        TrainRoutes trainRoutes = new TrainRoutes();
        List<Town<String>> towns = new ArrayList<>();
        towns.add( new Town<>("A"));
        towns.add( new Town<>("B"));
        towns.add( new Town<>("C"));

        System.out.println(trainRoutes.calculateRouteDistance(towns));

        Town<String> start = new Town<>("C");
        Town<String> end = new Town<>("C");
        System.out.println(trainRoutes.calculateTripsWithMaxStops(start, end, 2));
    }
}
