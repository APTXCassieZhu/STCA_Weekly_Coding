package Treasure;

public class FindLegalMoves2 {
    public static boolean FindLegalMoves(int[][] grid, int row, int col) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, visited);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false)
                    return false;
            }
        }
        return true;
    }

    public static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] == -1 || visited[i][j] == true)
            return;
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j - 1, visited);
        dfs(grid, i, j + 1, visited);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { { 0, -1, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(FindLegalMoves(grid, 0, 0));
    }
}
