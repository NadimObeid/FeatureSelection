package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class Graph {
    int[][] adjacencyList;
    int[] deg;
    int n;

    public Graph (int[][] adjacencyList){
        this.adjacencyList = adjacencyList;
        this.n = adjacencyList.length;
        this.deg = Arrays.stream(adjacencyList).mapToInt(n->n.length).toArray();

    }

    public Set<Integer> getDPacking(int d){
        int[] col = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> dpack = new HashSet<>();
        int x = getMaxDegUncol(col);
        while(x != -1){
            queue.offer(x);
            dpack.add(x);
            col[x] = 1;
            while(!queue.isEmpty()){
                int v = queue.poll();
                if(col[v]<=d){
                    for (int j = 0; j < deg[v]; j++)
                    {
                        int w = adjacencyList[v][j];
                        if (col[w] == 0)
                        {
                            queue.offer(w);
                            col[w] = col[v] + 1;
                        }
                    }
                }
            }
            x = getMaxDegUncol(col);
        }
        return dpack;
    }


    private int getMaxDegUncol(int[] col) {
        int[] deg = Arrays.stream(adjacencyList).mapToInt(row -> Arrays.stream(row)
                .filter(element -> col[element] == 0).toArray().length).toArray();
        return  IntStream.range(0, deg.length)
                .filter(i->col[i]==0)
                .reduce((i, j) -> deg[i] > deg[j] ? i : j)
                .orElse(-1);
    }
}
