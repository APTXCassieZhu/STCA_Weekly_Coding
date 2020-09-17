import java.util.*;
public class LargestHoles{
    public static long largestHoles(int n, int m, int[] h, int[] v){
        if(h.length == 0 && v.length == 0)  return 1;
        if(h.length == 1 && v.length == 1)  return 4;
        Arrays.sort(h);
        Arrays.sort(v);
        long i = longest(h);
        long j = longest(v);
        return i * j;
    }
    public static long longest(int[] arr){
        long ans = 1;
        long cur = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] == arr[i-1] + 1){
                cur++;
            }else{
                ans = Math.max(ans, cur);
                cur = 1;
            }
        }
        ans = Math.max(ans, cur);
        return ans+1;
    }

     public static void main(String []args){

        int[] h = new int[]{1, 2};
        int[] v = new int[]{1, 2};
        System.out.println(largestHoles(3, 3, h, v));     
         
     }
}