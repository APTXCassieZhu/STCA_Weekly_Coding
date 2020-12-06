import java.util.*;
//1h45 code
//1h bq
public class maxTime{
    // HH:MM 有多少种可能的valid time
    public static int find(String time){
        int[] max = new int[4];
        Arrays.fill(max, 1);
        char[] arr = time.toCharArray();
        // check if time valid
        if((arr[0] != '?' && arr[0] >= '3') || (arr[0] != '?' && arr[1] != '?' && 
        arr[0] == '2' && arr[1] > '3') || (arr[3] != '?' && arr[3] > '5'))    return 0;
        if(arr[0] == '?')   
            max[0] = (arr[1] <= '3' || arr[1] == '?') ? 3 : 2;
        if(arr[1] == '?')
            max[1] = (arr[0] == '2') ? 4 : 10;
        if(arr[3] == '?')
            max[2] = 6;
        if(arr[4] == '?')
            max[3] = 10;
        return max[0]*max[1]*max[2]*max[3];
    }
    public static void main(String[] args) {
        check(find("2?:45"), 4);    // 20:45    21:45   22:45   23:45
        check(find("?9:32"), 2);    // 09:32    19:32
        check(find("0?:?0"), 60);
        check(find("?4:0?"), 20);
        check(find("29:01"), 0);
        check(find("32:01"), 0);
        check(find("23:61"), 0);
    }
    private static void check(int a, int b){
        System.out.println(a==b);
    }
}