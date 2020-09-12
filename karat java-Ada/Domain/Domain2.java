package Domain;
// 输出两个user的最长连续且相同的访问记录。
// input
// [
//     ["3234.html", "xys.html", "7hsaa.html"], // user1
//     ["3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"] // user2
// ]
// output
// ["xys.html", "7hsaa.html"]
public class Domain2 {
    public static String[] LCS(String[] history1, String[] history2) {
        if (history1 == null || history2 == null || history1.length == 0 || history2.length == 0) {
            return new String[]{};
        }
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

    public static void main(String[] args) {
        String[] s1 = { "3234.html", "xys.html", "7hsaa.html" }; // user1
        String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" }; // user2
        String[] result = LCS(s1, s2);
        System.out.println("[");
        for (String s : result) {
            System.out.println(s + " ,");
        }
        System.out.println("]");
    }
}
