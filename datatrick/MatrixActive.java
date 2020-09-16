import java.util.*;

public class MatrixActive{
    public static long[] matrixQueris(int n, int m, int[][] queries){
        int[] inactiveRow = new int[n+1];
        int[] inactiveCol = new int[m+1];
        List<Long> ans = new ArrayList<>();
        for(int[] query: queries){
            if(query[0] == 0){
                // calculate smallest
                long min = findMin(inactiveRow, inactiveCol);
                ans.add(min);
            }else if(query[0] == 1){
                // deactive row
                inactiveRow[query[1]] = 1;
            }else if(query[0] == 2){
                // deactive col
                inactiveCol[query[1]] = 1;
            }
        }
        long[] result = new long[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            result[i] = ans.get(i);
            //System.out.println(result[i]);
        }
        return result;
    }
    public static long findMin(int[] arr, int[] arr2){
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr2.length; j++){
                if(arr[i] == 0 && arr2[j] == 0)
                    return (long)i*j;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] queries = new int[][]{{0}, {1,2}, {0}, {2,1}, {0}, {1,1}, {0}};
        matrixQueris(3, 4, queries);
    }
}