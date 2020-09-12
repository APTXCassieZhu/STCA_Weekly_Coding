package ValidMatrix;
// """

import java.util.*;

// A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions. Specifically, each cell can be either black or white, which we will represent as 0 for black and 1 for white.

// +------------+
// | 1  1  1  1 |
// | 0  1  1  1 |
// | 0  1  0  0 |
// | 1  1  0  1 |
// | 0  0  1  1 |
// +------------+

// For each row and column, the instructions give the lengths of contiguous runs of black (0) cells. For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

// These are valid solutions: [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
// This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
// This is not valid: [ 1, 0, 0, 0, 1 ] since the two runs of 0s are not separated by 1s.

// Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

// Example instructions #1

// matrix1 = [[1,1,1,1],
//            [0,1,1,1],
//            [0,1,0,0],
//            [1,1,0,1],
//            [0,0,1,1]]
// rows1_1    =  [], [1], [1,2], [1], [2]
// columns1_1 =  [2,1], [1], [2], [1]
// validateNonogram(matrix1, rows1_1, columns1_1) => True

// Example solution matrix:
// matrix1 ->
//                                    row
//                 +------------+     instructions
//                 | 1  1  1  1 | <-- []
//                 | 0  1  1  1 | <-- [1]
//                 | 0  1  0  0 | <-- [1,2]
//                 | 1  1  0  1 | <-- [1]
//                 | 0  0  1  1 | <-- [2]
//                 +------------+
//                   ^  ^  ^  ^
//                   |  |  |  |
//   column       [2,1] | [2] |
//   instructions      [1]   [1]

// Example instructions #2

// (same matrix as above)
// rows1_2    =  [], [], [1], [1], [1,1]
// columns1_2 =  [2], [1], [2], [1]
// validateNonogram(matrix1, rows1_2, columns1_2) => False

// The second and third rows and the first column do not match their respective instructions.

// Example instructions #3

// matrix2 = [
// [ 1, 1 ],
// [ 0, 0 ],
// [ 0, 0 ],
// [ 1, 0 ]
// ]
// rows2_1    = [], [2], [2], [1]
// columns2_1 = [1, 1], [3]
// validateNonogram(matrix2, rows2_1, columns2_1) => False

// The black cells in the first column are not separated by white cells.

// n: number of rows in the matrix
// m: number of columns in the matrix
// """

public class Nonogram {
    public static boolean checkNonogram(int[][] matrix, int[][] rows, int[][] cols) {
        return checkRows(matrix, rows) && checkCols(matrix, cols);
    }

    private static boolean checkRows(int[][] matrix, int[][] rows) {
        if (matrix.length != rows.length)
            return false;
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> pattern = new ArrayList<>();
            int num = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && num != 0) {
                    pattern.add(num);
                    num = 0;
                }
                if (matrix[i][j] == 0) {
                    num += 1;
                }
            }
            if (num != 0) {
                pattern.add(num);
            }

            if (pattern.size() == 0 && rows[i].length == 0) {
                continue;
            }

            if (pattern.size() != rows[i].length) {
                return false;
            }

            for (int k = 0; k < pattern.size(); k++) {
                if (pattern.get(k) != rows[i][k])
                    return false;
            }
        }
        return true;
    }

    private static boolean checkCols(int[][] matrix, int[][] cols) {
        if (matrix[0].length != cols.length)
            return false;
        for (int i = 0; i < matrix[0].length; i++) {
            List<Integer> pattern = new ArrayList<>();
            int num = 0;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 1 && num != 0) {
                    pattern.add(num);
                    num = 0;
                }
                if (matrix[j][i] == 0) {
                    num += 1;
                }
            }
            if (num != 0) {
                pattern.add(num);
            }

            if (pattern.size() == 0 && cols[i].length == 0) {
                continue;
            }

            if (pattern.size() != cols[i].length) {
                return false;
            }
            for (int k = 0; k < pattern.size(); k++) {
                if (pattern.get(k) != cols[i][k])
                    return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 0, 0 }, { 1, 1, 0, 1 }, { 0, 0, 1, 1 } };
        int[][] rows = { {}, { 1 }, { 1, 2 }, { 1 }, { 2 } };
        int[][] cols = { { 2, 1 }, { 1 }, { 2 }, { 1 } };
        System.out.println(checkNonogram(matrix, rows, cols));
    }

}
