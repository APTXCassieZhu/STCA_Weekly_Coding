/*
    https://leetcode.com/problems/search-a-2d-matrix-ii/s
    Amazon | OA 2019 | 
*/
public class Search2DMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)    return false;
        int row = matrix.length - 1, col = 0;
        while(row >= 0 && col <= matrix[0].length - 1){
            if(matrix[row][col] == target)  return true;
            else if(matrix[row][col] > target)  row--;
            else    col++;
        }
        return false;
    }

    public static void main(String[] args){     
        System.out.println();    
    }
}