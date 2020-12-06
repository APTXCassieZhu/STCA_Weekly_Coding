public class EfficientJanitor{
    // each bag not over 3.0 pounds
    // min bag
    // 1.01 <= weights <= 3.0
    public static int efficientJanitor(List<Float> weight) {
        int ans = 0;
        Collections.sort(weight);
        int left = 0, right = weight.size()-1;
        while(left <= right){
            if(left == right){
                ans++;
                break;
            }
            if(weight.get(left) + weight.get(right) <= 3.0){
                left++;
                right--;
                ans++;
            }else{
                right--;
                ans++;
            }
        }
        return ans;
    }
}