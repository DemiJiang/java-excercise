package routedistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteDistance {

    public String calculateDistance(String route) {
        int result = 0;
        for(String edge: findEdges(route)){
            if (graphs.keySet().contains(edge)) result += graphs.get(edge);
            else return "NO SUCH ROUTE";
        }
        return String.valueOf(result);
    }

    private List<String> findEdges(String route){
        List<String> edges = new ArrayList<>();
        String str[] = route.split("-");
        for(int i = 0; i < str.length -1; i++){
            edges.add(str[i] + str[i + 1]);
        }
        return edges;
    }

    private Map<String, Integer> graphs = initGraphs();
    private static Map<String, Integer> initGraphs() {
        Map<String, Integer> graphs = new HashMap<>();
        graphs.put("AB", 5);
        graphs.put("BC", 4);
        graphs.put("CD", 8);
        graphs.put("DC", 8);
        graphs.put("DE", 6);
        graphs.put("AD", 5);
        graphs.put("CE", 2);
        graphs.put("EB", 3);
        graphs.put("AE", 7);
        return graphs;
    }




}
