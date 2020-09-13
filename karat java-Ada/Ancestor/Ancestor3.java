package Ancestor;

import java.util.*;
// 最远祖先
//  1   2   3
// / \ /   / \
// 4  5   8   6
//             \
//              7
// find(7) = 3
public class Ancestor3 {
    public static int findFarAncestor(int[][] edges, int x) {
        if (edges == null || edges.length == 0)
            return 0;
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[1], new HashSet<>());
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.get(edge[1]).add(edge[0]);
        }
        // max is used to keep the maximum level so far;
        int max = Integer.MIN_VALUE;
        // result[0] is used to keep the farest parent
        int[] result = new int[] { 0 };
        dfs(x, 0, max, result, graph);
        return result[0];
    }

    // dfs to find a parent with max levels
    private static void dfs(int cur, int level, int max, int[] result, Map<Integer, HashSet<Integer>> graph) {
        if (graph.get(cur).size() == 0) {
            if (level > max) {
                max = level;
                result[0] = cur;
            }
        } else {
            for (int parent : graph.get(cur)) {
                dfs(parent, level + 1, max, result, graph);
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 4 }, { 1, 5 }, { 2, 5 }, { 3, 6 }, { 6, 7 }, { 3, 8 } };
        System.out.println(findFarAncestor(edges, 7));
        System.out.println(findFarAncestor(edges, 8));
        System.out.println(findFarAncestor(edges, 5));
    }
}
