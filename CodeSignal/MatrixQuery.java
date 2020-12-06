import java.util.*;

public class MatrixQuery{
    // n * m 
    // board[i][j] = (i+1)*(j+1);
    // query type
    //      [0] : find min among all remaining active cells
    //      [1,i] : deactive all cells in row i
    //      [2,j] : deactive all cells in col j
    public static int[] solution(int[][] queries, int m, int n){
        int[] memo = new int[2];
        int minval = 1;
        
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int[] query: queries){
            if(query.length==1){
                if(!row.contains(memo[0]) && !col.contains(memo[1])){
                    res.add(minval);
                }else{
                    int min_i = m, min_j = n;
                    for(int i=0; i<m; i++){
                        if(row.contains(i)) continue;
                        else{
                            min_i = i;
                            break;
                        }
                    }
                    for(int j=0; j<n; j++){
                        if(col.contains(j)) continue;
                        else{
                            min_j = j;
                            break;
                        }
                    }
                    minval =(min_i+1) *(min_j+1);
                    memo[0] = min_i;
                    memo[1] = min_j;
                    res.add(minval);
                }
            }
            else{
                if(query[0] == 1){
                    row.add(query[1]-1);
                }else if(query[0] == 2){
                    col.add(query[1]-1);
                }
            }
        }

        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }

    static long[] matrixQueries(int m, int n, int[][] queries) {
        TreeMap<Integer, Integer> nums = new TreeMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int num = (i+1) * (j+1);
                nums.put(num, nums.getOrDefault(num, 0) + 1);
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int[] query: queries){
            if(query.length==1){
                res.add(nums.firstKey());
            }else{
                if(query[0] == 1){
                    for (int j = 1; j <= n; j++) {
                        int tmp = query[1] * j;
                        if (!nums.containsKey(tmp)) {
                            continue;
                        }
                        int prevCount = nums.get(tmp);
                        if (prevCount == 1) {
                            nums.remove(tmp);
                        } else {
                            nums.put(tmp, prevCount - 1);
                        }
                    }
                }else if(query[0] == 2){
                    for (int i = 1; i <= m; i++) {
                        int tmp = query[1] * i;
                        if (!nums.containsKey(tmp)) {
                            continue;
                        }
                        int prevCount = nums.get(tmp);
                        if (prevCount == 1) {
                            nums.remove(tmp);
                        } else {
                            nums.put(tmp, prevCount - 1);
                        }
                    }
                }
            }
        }
    
        long[] result = new long[res.size()];
        int idx = 0;
        for(int num: res){
            result[idx++] = num;
        }
        return result;
    }

    public static void forTest(long[] res){
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[][] queries = new int[][]{{0},{1,2},{0},{2,1},{0},{1,1},{0}};   // 1 1 2 6
        int[][] queries1 = new int[][]{{1,1},{1,4},{0},{1,5},{1,2},{0}};    // 2 3
        forTest(matrixQueries(3, 4, queries));
        forTest(matrixQueries(6, 1, queries1));
        
    }
}