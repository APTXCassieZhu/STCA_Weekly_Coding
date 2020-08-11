/*
    https://leetcode.com/discuss/interview-question/542597/
    Amazon | OA 2020 | Top K Frequently Mentioned Keywords
*/
import java.util.*;

public class TopKFreqKeyword {
    public static List<String> findTopKWords(int k, String[] keywords, String[] reviews){
        HashMap<String, Integer> map = new HashMap<>();
        for(String key: keywords){
            map.put(key, 0);
        }
        for(String review: reviews){
            String[] words = review.toLowerCase().split(" ");
            HashSet<String> set = new HashSet<>();
            for(String word: words){
                //System.out.println(word);
                if(map.containsKey(word) && !set.contains(word)){
                    map.put(word, map.get(word)+1);
                    //System.out.println(word + " "+ map.get(word));
                }
                set.add(word);
            }
        }
        Arrays.sort(keywords, (s1, s2) -> 
            map.get(s1) - map.get(s2) == 0 ? s1.compareTo(s2) : map.get(s2) - map.get(s1));
        List<String> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            ans.add(keywords[i]);
            System.out.print(keywords[i]+" ");
        }
        System.out.println();
        return ans;
    }
    public static void main(String[] agrs){
        // ["anacell", "betacellular"]
        int k1 = 2;
        String[] keywords1 = new String[]{"anacell", "cetracular", "betacellular"};
        String[] reviews1 = new String[] {
            "Anacell provides the best services in the city",
            "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell",
        };
        // ["betacellular", "anacell"]
        int k2 = 2;
        String[] keywords2 = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews2 = new String[] {
            "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services",
            "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell",
            "Betacellular is better than deltacellular.",
        };
        findTopKWords(k1, keywords1, reviews1);
        findTopKWords(k2, keywords2, reviews2);
    }
}