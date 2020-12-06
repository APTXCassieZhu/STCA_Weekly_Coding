public class CutMetalSurplus{
    public static long calculateMaximumProfit(int cost_per_cut, int metal_price, int[] lengths) {
        long maxProfit = 0;
        long curProfit = 0;
        int maxLength = 0;
        int totalRods = 0;
        int totalCuts = 0;

        // Find out maximum length
        for (int curLength : lengths) {
            maxLength = Math.max(maxLength, curLength);
        }

        // For each of the possible rod lengths, calculate possible profit
        for (int curLength = 1; curLength < maxLength; curLength++) {

            totalRods = 0;
            totalCuts = 0;

            // Cut each of the rods into smaller rods of size curLength
            // Count total rods and total cuts
            for (int length : lengths) {
                int benefit = (length/curLength) * metal_price * curLength - cost_per_cut * (length % curLength);
                if(benefit > 0){
                    totalRods += (length / curLength);
                    totalCuts += ((length - 1) / curLength);
                }
                
            }

            // Calculate current profit
            curProfit = totalRods * curLength * metal_price - totalCuts * cost_per_cut;

            // Calculate maximum profit
            maxProfit = Math.max(maxProfit, curProfit);
        }

        return maxProfit;
    }
    public static void main(String[] args){
        int[] lengths = new int[]{20,40,21,20,20,20,20,20,20};
        System.out.println(calculateMaximumProfit(25, 1, lengths));
    }
}