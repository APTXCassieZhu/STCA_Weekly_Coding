package Ancestor;

import java.util.*;
//   1    2    3
//  / \  /      \
// 4    5        6
//                 \
//                  7
//输入是 int[][] input, input[0]是input[1]的parent，比如 {{1,4}, {1,5}, {2,5}, {3,6}, {6,7}}会形成上面的图
// output [1,2,3,4,5,6]
//第一问是只有0个parents和只有1个parent的节点
// idea : create map, which key is the child, value is the list of its ancestor
//        then go over key set of map, find out result
// time complexity O(n) space complexity 
public class Ancestor1 {
    public static List<Integer> zeroOrOneAncestor(int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (edges == null || edges.length == 0)
            return result;

        // Build a graph using a map (value is parent)
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            HashSet<Integer> grandparent = new HashSet<>(graph.get(edge[0]));
            grandparent.add(edge[0]);    
            graph.putIfAbsent(edge[1], grandparent);        
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
