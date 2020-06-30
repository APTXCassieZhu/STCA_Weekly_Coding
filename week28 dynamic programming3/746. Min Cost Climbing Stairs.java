class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int costOfFirst = cost[0];
        int costOfSecond = cost[1];
        int temp = 0;
        for(int i=2; i<cost.length; i++){
            temp = Math.min(costOfFirst,costOfSecond) + cost[i];
            costOfFirst = costOfSecond;
            costOfSecond = temp;
        }
        return Math.min(costOfFirst, costOfSecond);
    }
}