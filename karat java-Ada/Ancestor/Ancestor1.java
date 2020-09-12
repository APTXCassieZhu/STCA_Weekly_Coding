package Ancestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//输入是 int[][] input, input[0]是input[1]的parent，比如 {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}会形成上面的图
//第一问是只有0个parents和只有1个parent的节点
public class Ancestor1 {
    public static List<Integer> zeroOrOneAncestor(int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (edges == null || edges.length == 0)
            return result;

        // Build a graph using a map
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        // loop the keySet of the map, to find the nodes who has less or equal to 1
        // parent.
        for (int key : graph.keySet()) {
            if (graph.get(key).size() <= 1) {
                result.add(key);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 } };
        List<Integer> result = zeroOrOneAncestor(edges);
        for (int node : result) {
            System.out.println(node);
        }
    }
}
