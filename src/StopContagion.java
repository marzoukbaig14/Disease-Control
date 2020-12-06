import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StopContagion {


    public static void main(String[] args) throws IOException {


        HashMap<Integer, ArrayList<vertex>> graph = new HashMap<Integer, ArrayList<vertex>>();
        HashMap<Integer, ArrayList<vertex>> gresGraph = readData("inputFile.txt", graph);

        System.out.println("size: " + gresGraph.size());

        for(Map.Entry<Integer, ArrayList<vertex>> entry: gresGraph.entrySet()) {

            ArrayList<vertex> v = entry.getValue();
            System.out.println(entry.getKey() + " key");

            for (vertex i: v) {

                System.out.print(i.vNum + ", ");
            }
            System.out.println();

        }




    }

    public static HashMap<Integer, ArrayList<vertex>> readData(String fileName, HashMap<Integer, ArrayList<vertex>> graph) throws IOException {

        FileReader in = new FileReader(fileName);
        BufferedReader br = new BufferedReader(in);
        String[] values;
        String vertex2;
        String line;

        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;

        while ((line = br.readLine()) != null) {

            values = line.split("\\s+");

            int vertex = Integer.parseInt(values[0]);
            vertex adjVertex = new vertex(Integer.parseInt(values[1]));

            if (graph.containsKey(vertex)) {

                ArrayList<vertex> adjVerticies = graph.get(vertex);
                adjVerticies.add(adjVertex);
                graph.put(vertex, adjVerticies);

            }
            else {

                ArrayList<vertex> newAdjVerticies = new ArrayList<vertex>();
                newAdjVerticies.add(adjVertex);
                graph.put(vertex, newAdjVerticies);

            }



        }

        in.close();

        return graph;

    }
}
