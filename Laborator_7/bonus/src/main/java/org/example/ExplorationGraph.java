package org.example;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;
import org.graph4j.traverse.DFSIterator;
import org.graph4j.traverse.SearchNode;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExplorationGraph {
    private Graph graph;
    private int nrOfNodes;
    private boolean[] visitedNodes;

    private List<Integer> visitedMSTNodes = new CopyOnWriteArrayList<>();

    ExplorationGraph(int n) {
        graph = GraphBuilder.numVertices(n).buildGraph();
        visitedNodes = new boolean[n];
        nrOfNodes = n;
        for (int i = 0; i < n; i++) {
            visitedNodes[i] = false;
        }

        Random random = new Random();
        int nrEdges = random.nextInt(n - 1, n * (n + 1) / 2);
        for (int i = 0; i < nrEdges; i++) {
            int node1 = random.nextInt(0, n);
            int node2 = random.nextInt(0, n);
            while (node2 == node1) {
                node2 = random.nextInt(0, n);
            }

            while (graph.containsEdge(node1, node2)) {
                node1 = random.nextInt(0, n);
                node2 = random.nextInt(0, n);
            }

            graph.addEdge(node1, node2);
        }

        /* code for MST -> make the graph weighted and pick a random node */
        setWeights();
        int startNode = random.nextInt(0, nrOfNodes);
        visitedMSTNodes.add(startNode);
    }

    public void setWeights() {
        Random random = new Random();
        for (int i = 0; i < nrOfNodes - 1; i++) {
            for (int j = i + 1; j < nrOfNodes; j++) {
                if (graph.containsEdge(i, j)) {
                    graph.setEdgeWeight(i, j, random.nextInt(100));
                }
            }
        }

    }

    public boolean MST() {
        /* reached the limit, set pause to robot */
        if (visitedMSTNodes.size() == nrOfNodes) {
            return false;
        }
        /* not all nodes are visited */
        while (visitedMSTNodes.size() != nrOfNodes) {
            for (Integer i : visitedMSTNodes) {
                /* find the minimum accessible edge and visit its nodes */
                double minWeight = 101;

                int otherNode = -1;
                for (int j = 0; j < nrOfNodes; j++) {
                    if (i != j && !visitedMSTNodes.contains(j) && graph.containsEdge(i, j) && (graph.edge(i, j).weight() < minWeight)) {
                        minWeight = graph.edge(i, j).weight();
                        otherNode = j;
                    }
                }
                /* lock the list */
                synchronized (visitedMSTNodes) {
                    if (otherNode != -1 && !visitedMSTNodes.contains(otherNode)) {
                        System.out.println(Thread.currentThread().getName() + " visited edge " + i + "-" + otherNode);
                        visitedMSTNodes.add(otherNode);
                    }
                }
            }
        }
        return true;
    }

    public synchronized boolean visit(Robot robot) {
        int toVisit = -1;

        /* find the first unvisited node */
        for (int node : graph.vertices()) {
            if (!visitedNodes[node]) {
                toVisit = node;
                break;
            }
        }
        /* if there is nothing to visit, pause the robot */
        if (toVisit == -1) {
            return false;
        }

        /* if it is not visited yet, visit the node */
        if (!visitedNodes[toVisit]) {
            visitedNodes[toVisit] = true;
            System.out.println(Thread.currentThread().getName() + ": " + robot + " visited node " + toVisit);
        }
        return true;
    }

    public List<Integer> getVisitedMSTNodes() {
        return visitedMSTNodes;
    }
}
