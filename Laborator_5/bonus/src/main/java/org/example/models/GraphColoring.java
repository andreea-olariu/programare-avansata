package org.example.models;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.jgrapht.alg.color.BrownBacktrackColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphColoring {

    public static Graph buildGraph(Catalog catalog) {
        Graph graph = GraphBuilder.numVertices(catalog.getDocuments().size()).buildGraph();

        int V = catalog.getDocuments().size();
        for(int i = 0; i < V - 1; i++) {
            for(int j = i + 1; j < V; j++) {
                if(i != j) {
                    for(String tag : catalog.getDocuments().get(i).getTags().keySet()) {
                        if(catalog.getDocuments().get(j).getTags().containsKey(tag)) {
                            if(!graph.containsEdge(i, j))
                                graph.addEdge(i, j);
                            break;
                        }
                    }
                }
            }
        }

        return graph;
    }

    public static org.jgrapht.Graph<Integer, DefaultEdge> buildGraphJGraphT(Catalog catalog) {
        org.jgrapht.Graph<Integer, DefaultEdge> graph = new DefaultUndirectedGraph<>(DefaultEdge.class);
        int V = catalog.getDocuments().size();

        for(int i = 0; i < V; i++) {
            graph.addVertex(i);
        }

        for(int i = 0; i < V - 1; i++) {
            for(int j = i + 1; j < V; j++) {
                if(i != j) {
                    for(String tag : catalog.getDocuments().get(i).getTags().keySet()) {
                        if(catalog.getDocuments().get(j).getTags().containsKey(tag)) {
                            if(!graph.containsEdge(i, j))
                                graph.addEdge(i, j);
                            break;
                        }
                    }
                }
            }
        }

        return graph;
    }

    public static void greedyColoring(Catalog catalog) {
        Map<Integer, Integer> coloring = new HashMap<>();
        Graph graph = buildGraph(catalog);

        int V = catalog.getDocuments().size();
        boolean[] available = new boolean[V];

        Arrays.fill(available, true);
        coloring.put(catalog.getDocuments().get(0).getId(), 0);

        for(int index = 1; index < V; index++) {
            for(var neighbor : graph.neighbors(catalog.getDocuments().get(index).getId())) {
                if(coloring.get(neighbor) != null)
                    available[coloring.get(neighbor)] = false;
            }

            for(int color = 0; color < available.length; color++) {
                if(available[color]) {
                    coloring.put(catalog.getDocuments().get(index).getId(), color);
                    break;
                }
            }

            Arrays.fill(available, true);
        }

        for(Integer id : coloring.keySet()) {
            System.out.println("The document with id " + id + " is colored with " + coloring.get(id));
        }
    }

    public static void graphColoringJGraphT(Catalog catalog) {
        org.jgrapht.Graph<Integer, DefaultEdge> graph = buildGraphJGraphT(catalog);

        BrownBacktrackColoring coloringClass = new BrownBacktrackColoring(graph);
        var colors = coloringClass.getColoring().getColors();
        for(var key : colors.keySet()) {
            System.out.println("The document with id " + key + " is colored with " + colors.get(key));
        }
    }
}
