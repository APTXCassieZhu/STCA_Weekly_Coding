package Treasure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindLegalMoves3 {
    public static List<List<int[]>> findShortestPaths(int[][] grid, int[] start, int[] end) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return new ArrayList<>();
        List<List<int[]>> temp = new ArrayList<>();
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int treasure = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    treasure += 1;
            }
        }
        backtrack(grid, start[0], start[1], end, treasure, new LinkedList<>(), directions, temp);
        List<List<int[]>> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (List<int[]> path : temp) {
            if (path.size() < min) {
                result = new ArrayList<>();
                result.add(path);
                min = path.size();
            } else if (path.size() == min) {
                result.add(path);
            }
        }
        return result;
    }

    private static void backtrack(int[][] grid, int row, int col, int[] end, int treasure, LinkedList<int[]> path,
            int[][] directions, List<List<int[]>> result) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == -1
                || grid[row][col] == 2) {
            return;
        }

        int temp = grid[row][col];
        grid[row][col] = 2;
        if (temp == 1)
            treasure--;
        path.offer(new int[] { row, col });
        if (row == end[0] && col == end[1] && treasure == 0) {
            result.add(new ArrayList<>(path));
            grid[row][col] = temp;
            path.removeLast();
        } else {
            for (int[] direction : directions) {
                int x = row + direction[0];
                int y = col + direction[1];
                backtrack(grid, x, y, end, treasure, path, directions, result);
            }
            grid[row][col] = temp;
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        // Test case1:
        // treasure(board3, (5, 0), (0, 4)) -> None

        // Test case2:
        // treasure(board3, (5, 2), (2, 0)) ->
        // [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (2, 2), (2, 3), (1, 3), (0, 3), (0,
        // 2), (0, 1), (0, 0), (1, 0), (2, 0)]
        // Or
        // [(5, 2), (5, 1), (4, 1), (3, 1), (3, 2), (3, 3), (2, 3), (1, 3), (0, 3), (0,
        // 2), (0, 1), (0, 0), (1, 0), (2, 0)]

        // Test case3:
        // treasure(board3, (0, 0), (4, 1)) ->
        // [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (2, 2), (3, 2), (3, 1), (4,
        // 1)]
        // Or
        // [(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (3, 2), (3, 1), (4,
        // 1)]
        int[][] grid = new int[][] { { 1, 0, 0, 0, 0 }, { 0, -1, -1, 0, 0 }, { 0, -1, 0, 1, 0 }, { -1, 0, 0, 0, 0 },
                { 0, 1, -1, 0, 0 }, { 0, 0, 0, 0, 0 } };
        List<List<int[]>> paths = findShortestPaths(grid, new int[] { 0, 0 }, new int[] { 4, 1 });

        for (List<int[]> path : paths) {
            System.out.println("Path:[");
            for (int[] p : path) {
                System.out.println("[" + p[0] + " ," + p[1] + "]");
            }
            System.out.println("]");
        }
    }
}
