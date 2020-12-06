public class BeforeMatrix{
    // 2 3          2 5
    //       == >
    // 5 7          7 17
    // 现在要逆推before
    // s = 0;
    // for(int i = 0; i <= x; i++){
    //     for(int j = 0; j <= y; j++){
    //         s = s + before(i, j);
    //     }
    // }
    // after(x, y) = s;
    public static int[][] findBeforeMatrix(int[][] after) {
        int R = after.length;
        int C = after[0].length;
    
        for (int i = 0; i < R; i++) {
            for (int j = C - 1; j >= 1; j--) {
                after[i][j] -= after[i][j - 1];
            }
        }
    
        for (int i = R - 1; i >= 1; i--) {
            for (int j = 0; j < C; j++) {
                after[i][j] -= after[i - 1][j];
            }
        }
    
        return after;
    }
}

