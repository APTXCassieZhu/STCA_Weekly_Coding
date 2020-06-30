class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))    return true;
        if(t.equals(""))    return false;
        int i = 0, j=0;
        int slen = s.length();
        int tlen = t.length();
        while(i<slen && j<tlen){
            if(t.charAt(j++) == s.charAt(i)){
                i++;
            }
        }
        return i==slen;
    }
}