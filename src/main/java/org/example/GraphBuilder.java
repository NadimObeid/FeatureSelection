package org.example;

import java.util.Scanner;

public class GraphBuilder {
    public static Graph buildGraphFromFile(String fileName){
        String data = FileReader.getDataFromFile(fileName);
        int [][] al = buildAdjacencyListFromData(data);
        return new Graph(al);
    }

    private static int[][] buildAdjacencyListFromData(String data){
        Scanner scanner = new Scanner(data);
        int n = scanner.nextInt();
        int e = scanner.nextInt();

        int[] degree = new int[n];
        int[][] tempEdges = new int[e][2];

        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            tempEdges[i][0] = u;
            tempEdges[i][1] = v;
            degree[u]++;
            degree[v]++;
        }
        scanner.close();

        int[][] adjList = new int[n][];
        for (int i = 0; i < n; i++) {
            adjList[i] = new int[degree[i]];
        }

        int[] position = new int[n];
        for (int i = 0; i < e; i++) {
            int u = tempEdges[i][0];
            int v = tempEdges[i][1];
            adjList[u][position[u]++] = v;
            adjList[v][position[v]++] = u;
        }

        return adjList;
    }
}
