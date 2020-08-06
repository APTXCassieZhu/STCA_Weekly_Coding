/*
    https://leetcode.com/discuss/interview-question/370112
    Substrings of size K with K distinct chars
*/
import java.util.*;
public class KDiffCharSub{

    // key idea : sliding windows
    public static List<String> findKSub(String word, int k){
        List<String> ans = new ArrayList<>();
        if(word == null || word.equals(""))
            return ans;
        HashSet<String> set = new HashSet<>();
        int[] ch = new int[26];
        //window: [left, right] with no repeating char of max size k
        int left = 0, len = word.length();
        for(int right = 0; right < len; right++){
            ch[word.charAt(right) - 'a']++;
            // while repeated
            while(ch[word.charAt(right) - 'a'] != 1){
                ch[word.charAt(left) - 'a']--;
                left++;
            }
            if(right-left+1 == k){
                set.add(word.substring(left, right+1));
                ch[word.charAt(left) - 'a']--;
                left++;
            }
        }
        print(set);
        System.out.println();
        return ans;
    }
    public static void print(HashSet<String> set){
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            System.out.print(it.next()+" ");
        }
    }
    public static void main(String[] args){
        findKSub("abcabc", 3);                 
        // ["abc", "bca", "cab"]
        findKSub("abacab", 3);                 
        // ["bac", "cab"]
        findKSub("awaglknagawunagwkwagl", 4);  
        // ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
    }
}