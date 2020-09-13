package Treasure;

import java.util.ArrayList;
import java.util.List;
// 第一问就是给一个i和j，找出身边四个方向里为0的所有格子。
class Problem1 {
    public static List<int[]> findLegalMoves(int i, int j, int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new ArrayList<>();
        }
        List<int[]> result = new ArrayList<>();
        int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = i + direction[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                result.add(new int[] { x, y });
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // 1 0 1
        // 0 1 0
        // 1 0 0
        int[][] grid = new int[][] { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 } };
        List<int[]> result = findLegalMoves(1, 1, grid);
        for (int[] cell : result) {
            System.out.println(cell[0] + " " + cell[1]);
        }
    }
}