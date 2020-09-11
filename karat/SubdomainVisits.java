// leetcode 811
// Input: 
// ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
// Output: 
// ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
import java.util.*;
public class SubdomainVisits{

    public List<String> subdomainVisits(String[] cpdomains){
        Map<String, Integer> map = new HashMap<>();

        for(String domain: cpdomains){
            int index = domain.indexOf(' ');
            int times = Integer.valueOf(domain.substring(0, index));
            String tag = domain.substring(index+1);
            for(int i = 0; i < tag.length() ; i++){
                if(tag.charAt(i) == '.'){
                    String tmp = tag.substring(i+1);
                    map.put(tmp, map.getOrDefault(tmp, 0)+times);
                }                
            }
            map.put(tag, map.getOrDefault(tag, 0)+times);
        }
        List<String> ans = new ArrayList<>();
        for(String key : map.keySet()){
            ans.add(map.get(key)+" "+key);
        }
        return ans;
    }
}