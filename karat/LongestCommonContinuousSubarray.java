// 输出两个user的最长连续且相同的访问记录。
// input
// [
//     ["3234.html", "xys.html", "7hsaa.html"], // user1
//     ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
// ]
// output
// ["xys.html", "7hsaa.html"]
import java.util.*;

public class LongestCommonContinuousSubarray{

    public static String[] longestCommonContiHistory(String[] history1, String[] history2){
        if(history1 == null || history2 == null || history1.length == 0 || history2.length == 0)    
            return new String[]{};
        int count = -1, index = -1;
        // dp
        int[] memo = new int[history2.length+1];
        for(int i = 1; i <= history1.length; i++){
            int prev = 0;
            for(int j = 1; j <= history2.length; j++){
                int tmp = memo[j];
                if(history1[i-1].equals(history2[j-1])){
                    memo[j] = prev + 1;
                    if(count < memo[j]){
                        count = memo[j];
                        index = j-1;
                    }
                }
                prev = tmp;
            }
        }
        String[] ans = new String[count];
        // find common
        if(index != -1){
            for(int i = count - 1; i>=0; i--){
                ans[i] = history2[index--];
            }
        }
        return ans;
    }

    public static void main(String[] args){  
        String[] history1 = new String[]{"3234.html", "xys.html", "7hsaa.html"};
        String[] history2 = new String[]{"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};
        String[] result = longestCommonContiHistory(history1, history2);
        for(String str: result)
            System.out.println(str);            
    }
}
