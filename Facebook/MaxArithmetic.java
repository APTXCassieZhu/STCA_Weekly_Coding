import java.util.*;

public class MaxArithmetic{
    // two sorted int array (no duplicate)
    // a = [0, 4, 8, 16]    b = [0, 2, 6, 12, 14, 20]  -> 6
    // explain: add b[3]=12, b[5]=20 to a, and obtain array [0,4,8,12,16,20] 
    // 0 + 4 => 4 + 4 => 8 + 4 => 12 ......
    // len of new array is 6

    public int maxArithmeticLength(int[] a, int[] b){
        int gcd = a[1] - a[0];
        for(int i = 2; i < a.length; i++){
            gcd = findGCD(gcd, a[i]-a[i-1]);
        }
        List<Integer> factors = factor(gcd);
        Set<Integer> set = new HashSet<>();
        for(int i : b)  set.add(i);
        int max = -1;
        for(int factor : factors){
            max = Math.max(max, largestArth(a, set, factor));
        }
        return max;
    }
    private int findGCD(int a, int b){
        if(a < b)   return findGCD(b, a);
        if(b == 0)  return a;
        return findGCD(b, a%b);
    }
    private List<Integer> factor(int a){
        List<Integer> ans = new ArrayList<>();
        int j = (int) Math.sqrt(a);
        for(int i = 1; i <= j; i++){
            if(a % i == 0){
                if( i * j == a) ans.add(i);
                else{
                    ans.add(i);
                    ans.add(a / i);
                }
            }
        }
        return ans;
    }

    private int largestArth(int[] a, Set<Integer> b, int step){
        int len = 1, idx = 1;
        int lastNum = a[0];
        while(idx < a.length){
            if(a[idx] - lastNum == step){
                lastNum = a[idx++];
                len++;
            }else {
                if(b.contains(lastNum + step)){
                    lastNum += step;
                    len++;
                }else{
                    return -1;
                }
            }
        }
        while(b.contains(lastNum + step)){
            len++;
            lastNum += step;
        }
        lastNum = a[0];
        while(b.contains(lastNum - step)){
            len++;
            lastNum -= step;
        }
        return len;
    }
    public static void main(String[] args) {
        MaxArithmetic ma = new MaxArithmetic();
        System.out.println(ma.maxArithmeticLength(new int[]{0,4,8,16}, new int[]{0,2,6,12,14,20})); // 6
        System.out.println(ma.maxArithmeticLength(new int[]{5,7,13,14}, new int[]{9,11,15}));       // -1
    }
}