class Solution {
    int[] used;
    Map<String, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //minmax
        if(desiredTotal <= 0)   return true;
        // aum = maxChoosableInteger*(maxChoosableInteger+1)/2. All posible solutions add up
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal)     return false;
        used = new int[maxChoosableInteger];
        map = new HashMap<>();
        return helper(desiredTotal);
    }
    
    public boolean helper(int total){
        String curr = Arrays.toString(used);
        if(map.containsKey(curr))   return map.get(curr);
        for(int i=0; i<used.length; i++){
            if(used[i] == 0){
                used[i] = 1;        // used
                if(total<= i+1 || !helper(total - i - 1)){
                    map.put(curr, true);
                    used[i] = 0;
                    return true;
                }
                used[i] = 0;
            }
        }
        map.put(curr, false);
        return false;

    }
}