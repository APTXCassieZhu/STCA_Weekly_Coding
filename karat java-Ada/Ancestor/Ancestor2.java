package Ancestor;

import java.util.*;

// 两个节点是否有公共祖先
//   1    2       3
//  / \  / \     / \
// 4    5   11  8   6
//                   \
//                    7
// input : {{1,4}, {1,5}, {2,5},{2,11}, {3,6}, {6,7}} , 7, 8
// output : true
public class Ancestor2 {
    public static boolean hasCommonAncestor(int[][] edges, int x, int y) {
        if (edges == null || edges.length == 1)
            return false;
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new HashSet<>());
            graph.putIfAbsent(edge[1], new HashSet<>()); 
            HashSet<Integer> grandparent = new HashSet<>(graph.get(edge[0]));
            grandparent.add(edge[0]);
            graph.get(edge[1]).addAll(grandparent);   
        }
        HashSet<Integer> parent1 = graph.get(x);
        HashSet<Integer> parent2 = graph.get(y);
        
        for (int parent : parent1) {
            if (parent2.contains(parent))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = { { 1, 4 }, { 1, 5 }, { 2, 5 }, {2, 11}, { 3, 6 }, { 6, 7 }, { 3, 8 } };
        System.out.println(hasCommonAncestor(edges, 7, 8));
        System.out.println(hasCommonAncestor(edges, 4, 5));
        System.out.println(hasCommonAncestor(edges, 5, 11));
        System.out.println(hasCommonAncestor(edges, 2, 1));
    }
}
