package Ancestor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Ancestor2 {
    public static boolean hasCommonAncestor(int[][] edges, int x, int y) {
        if (edges == null || edges.length == 1)
            return false;
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> parent1 = new HashSet<>();
        HashSet<Integer> parent2 = new HashSet<>();
        // find all of the parents of given two nodes
        // loop one of the set to find whether there is an overlap
        findParents(x, parent1, graph);
        findParents(y, parent2, graph);
        for (int parent : parent1) {
            if (parent2.contains(parent))
                return true;
        }
        return false;
    }

    // Add the parents of a given node into a set
    public static void findParents(int cur, HashSet<Integer> parents, Map<Integer, HashSet<Integer>> graph) {
        for (int parent : graph.get(cur)) {
            if (parents.add(parent)) {
                findParents(parent, parents, graph);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 }, { 3, 8 } };
        System.out.println(hasCommonAncestor(edges, 7, 8));
    }
}
