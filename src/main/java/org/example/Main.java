package org.example;

import java.io.*;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java DPacking <input_file> <d_value>");
            return;
        }

        // Read arguments
        String inputFile = args[0];
        int dValue = Integer.parseInt(args[1]);

        // Build graph from file
        Graph graph = GraphBuilder.buildGraphFromFile(inputFile);

        // Compute d-packing
        final Set<Integer> dPacking = graph.getDPacking(dValue);

        // Print to console (optional)
        System.out.println(dPacking);
        System.out.println(dPacking.size());

        // Write results to file (for Python script)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"))) {
            for (int node : dPacking) {
                writer.write(node + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing results: " + e.getMessage());
        }
    }
}
