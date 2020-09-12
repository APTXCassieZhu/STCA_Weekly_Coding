package ValidMatrix;

import java.util.*;
//给一个N*N的矩阵，判定是否是有效的矩阵。有效矩阵的定义是每一行或者每一列的数字都必须正好是1到N的数。输出一个bool。

public class ValidMatrix1 {
    public static boolean validMatrix(int[][] matrix){
        int N = matrix.length;
        for(int i = 0 ; i < N; i++){
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            for(int j = 0; j < N; j++){
                int curRow = matrix[i][j];
                if(curRow < 1 || curRow > N || !rows.add(curRow))   return false;
                int curCol = matrix[j][i];
                if(curCol < 1 || curCol > N || !cols.add(curCol))   return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // 1 1 3
        // 2 3 1
        // 3 1 2
        int[][] matrix = { { 1, 1, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
        System.out.println(validMatrix(matrix));
        int[][] matrix1 = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 1, 2 } };
        System.out.println(validMatrix(matrix1));
    }
}
