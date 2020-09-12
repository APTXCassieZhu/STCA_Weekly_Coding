//leetcode 763 
//Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int len = S.length();
        if(S == null || len == 0)    return ans;
        int[] last = new int[26];
        for(int i = 0; i<len; i++){
            last[S.charAt(i)-'a']=i;
        }
        int rightmost = 0, anchor = 0;
        for(int i = 0; i < len; i++){
            rightmost = Math.max(rightmost, last[S.charAt(i)-'a']);
            if(rightmost == i){
                ans.add(rightmost - anchor + 1);
                anchor = rightmost+1;
            }
        }
        return ans;
    }
}