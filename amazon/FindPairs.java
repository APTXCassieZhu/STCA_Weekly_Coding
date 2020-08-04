// https://leetcode.com/discuss/interview-question/356960
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindPairs{
    private static int diff = -30;
    public static int[] find(int[] nums, int target){
        if(nums == null || nums.length == 0)    return null;
        target += diff;
        int[] arr = new int[]{-1, -1};
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                if(num > max || map.get(num) > max){
                    arr[0] = map.get(num);
                    arr[1] = i;
                    max = Math.max(num, map.get(num));
                }
            }
            map.put(target-num, i);
            i++;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] nums1 = {1, 10, 25, 35, 60};
	    int target1 = 90;
	    System.out.println(Arrays.toString(find(nums1, target1)));
	    int[] nums2 = {20, 50, 40, 25, 30, 10};
	    int target2 = 90;
	    System.out.println(Arrays.toString(find(nums2, target2)));
	    int[] nums3 = {50, 20, 10, 40, 25, 30};
	    int target3 = 90;
	    System.out.println(Arrays.toString(find(nums3, target3)));
	    int[] nums4 = {1, 2};
	    int target4 = 90;
	    System.out.println(Arrays.toString(find(nums4, target4)));
    }
}