package org.example;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph graph = GraphBuilder.buildGraphFromFile("/data.txt");
        final Set<Integer> dPacking = graph.getDPacking(2);
        System.out.println(dPacking.toString());
        System.out.println(dPacking.size());
    }
}