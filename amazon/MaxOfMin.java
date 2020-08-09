/*
    https://leetcode.com/discuss/interview-question/383669/
    Amazon | OA 2019 | Max Of Min Altitudes
*/
public class MaxOfMin{
    public static int FindMaxOfMin(int[][] map){
        if(map == null || map.length == 0)  return 0;
        int r = map.length;
        int c = map[0].length;
        int[][] dp = new int[r][c];
        dp[0][0] = Integer.MAX_VALUE;
        dp[r-1][c-1] = Integer.MAX_VALUE;

        // dp[i][j] = max( min(dp[i-1][j], map[i][j]), min(dp[i][j-1]), map[i][j] )
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(i == 0 && j >= 1){
                    dp[i][j] = Math.min(dp[i][j-1], map[i][j]);
                }else if(j == 0 && i >= 1){
                    dp[i][j] = Math.min(dp[i-1][j], map[i][j]);
                }else if(i >= 1 && j >= 1){
                    dp[i][j] = Math.max(Math.min(map[i][j], dp[i][j-1]), Math.min(map[i][j], dp[i-1][j]));
                }
            }
        }
        return dp[r-1][c-1];
    }

    public static void main(String[] args){
        int[][] grid1 = new int[][] { { 5, 1 }, { 4, 5 } };
        int[][] grid2 = new int[][] { { 5, 7 }, { 3, 4 }, { 9, 8 } };
        int[][] grid3 = new int[][] { { 5, 7, 6, 8 }, { 3, 4, 2, 1 }, { 9, 8, 4, 6 } };
        int[][] grid4 = new int[][] { {10, 7, 3}, {12, 11, 9}, {1, 2, 8} };         
        int[][] grid5 = new int[][] { {20, 20, 3}, {20, 3, 20}, {3, 20, 20} };     
        System.out.println(FindMaxOfMin(grid1));    // 4
        System.out.println(FindMaxOfMin(grid2));    // 4
        System.out.println(FindMaxOfMin(grid3));    // 4
        System.out.println(FindMaxOfMin(grid4));    // 8
        System.out.println(FindMaxOfMin(grid5));    // 3
    }
}