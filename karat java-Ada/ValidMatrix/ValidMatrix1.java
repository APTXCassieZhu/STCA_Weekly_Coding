package ValidMatrix;

import java.util.HashSet;

public class ValidMatrix1 {
    public static boolean validMatrix1(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < N; j++) {
                int curRow = matrix[i][j];
                if (curRow < 1 || curRow > N || !rowSet.add(curRow)) {
                    return false;
                }
                int curCol = matrix[j][i];
                if (curCol < 1 || curCol > N || !colSet.add(curCol)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
        System.out.println(validMatrix1(matrix));
    }
}
