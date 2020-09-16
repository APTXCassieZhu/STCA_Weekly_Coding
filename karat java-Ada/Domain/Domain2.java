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
    public static String[] LCS(String[] s1, String[] s2) {
        if (s1 == null || s2 == null || s1.length == 0 || s2.length == 0) {
            return new String[0];
        }
        int l1 = s1.length;
        int l2 = s2.length;
        int max = 0;
        int endIndex = -1;
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (s1[i - 1].equals(s2[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        endIndex = i - 1;
                    }
                }
            }
        }
        if (max == 0)
            return new String[0];
        String[] result = new String[max];
        int start = endIndex - max + 1;
        for (int i = 0; i < max; i++) {
            result[i] = s1[start++];
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s1 = { "3234.html", "xys.html", "7hsaa.html" }; // user1
        String[] s2 = { "3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html" }; // user2
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] result = LCS(s1, s2);
        String[] result2 = LCS(user0, user1);
        System.out.println("[");
        for (String s : result2) {
            System.out.println(s + " ,");
        }
        System.out.println("]");
    }
}
