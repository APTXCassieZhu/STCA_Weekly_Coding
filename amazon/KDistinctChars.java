/*
    https://leetcode.com/discuss/interview-question/370157
    Amazon | OA 2019 | Substrings with exactly K distinct chars
    O(n) solution: https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/523136/JavaC%2B%2BPython-Sliding-Window
*/
import java.util.*;

public class KDistinctChars{
    // idea : sliding window, inside window the distinct char are k.
    public static int FindKDistinctChars(String word, int k){
        int ans = 0;
        for(int i = 0; i < word.length(); i++){
            Set<Character> set = new HashSet<Character>();
            for(int j = i; j < word.length(); j++){
                set.add(word.charAt(j));
                if(set.size() == k) ans++;
                else if(set.size() > k) break;
            }
        }
        return ans;
    }
   
    public static void main(String[] args){
        System.out.println("pqpqs k = 2 : " + FindKDistinctChars("pqpqs",2));     // 7 
        System.out.println("aabab k = 3 : " + FindKDistinctChars("aabab",3));     // 0
    }
}