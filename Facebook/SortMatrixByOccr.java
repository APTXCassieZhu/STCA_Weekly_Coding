import java.util.*;
public class SortMatrixByOccr{
    // given m 
    // sort its values in ascending order of how frequently the number occurs in m.
    // sort the equally frequent numbers by their values in ascending order
    // place the sorted numbers diagonally. starting from the bottom right corner
    // m = [[1,4,-2],                   [[3,3,4],
    //      [-2,3,4],           -->      [3,4,1],
    //      [3,1,3]]                     [1,-2,-2]]
    // explan: 1 occurs 2 times, -2 occurs 2 times, 3 occurs 3 times, 4 occurs 2 times
    //         after sorting [-2,-2,1,1,4,4,3,3,3]

    public static int[][] sortMatrixByOccurance(int[][] m){
        int len = m.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                map.put(m[i][j], map.getOrDefault(m[i][j], 0)+1);
            }
        }
        List<Integer> after = new ArrayList<>(map.keySet());
        Collections.sort(after, (a, b) -> map.get(a)==map.get(b)? a-b : map.get(a)-map.get(b));
        
    }
    public static void main(String[] args) {
        
    }
}