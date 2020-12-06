public class longestIdenticalSubarray{
    //input是一个array，所有element大于等于-10小于等于10。
    //假定你有三次机会把array里的任意一个element换成任意数，求最长的相等数列长度
    public static int helper(int[] A){
        int res = 0, count = 0;
        if(A.length <= 4) return A.length;
        for (int i = 0; i < A.length; i++) {
            //if(i > 0 && A[i] == A[i-1]) continue;
            int num = A[i];
            System.out.println(num+" "+res);
            count = 0;
            for(int j = i + 1; j < A.length; j++){
                if(A[j] != num){
                    count++;
                }
                if(count == 3){
                    res = Math.max(res, j - i + 1);
                    break;
                }
                if(j == A.length - 1 && 3 - count <= i){
                    res = Math.max(res, j - i + 1 + 3 - count);
                    System.out.println(res);
                }
            }
        }
        return res;
    }
    private static void check(int a, int b){
        System.out.println(a==b);
    }
    public static void main(String[] args) {
        // check(helper(new int[]{3,3,2,1,2,2,9,3,3}), 6);
        // check(helper(new int[]{1,2,10,3,10,10}), 6);
        // check(helper(new int[]{3,1,3,3,1,3,1,1}), 7);
        // check(helper(new int[]{-9,8}), 2);
        // check(helper(new int[]{1,1,3,3,3,3,3,4}), 8);
        check(helper(new int[]{2,3,3,3,3,1}), 6);
    }
}