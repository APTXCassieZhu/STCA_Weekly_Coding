// 木棍切割问题
// find longest side of square
public class Cutter{
    public static int cut(int A, int B){
        int ans = 0;
        if(A < B)   return cut(B, A);
        if(A+B < 4) return ans;
        int x = (A+B)/4;
        int max = A/2;
        while(x <= max){
            int count = A/x + B/x;
            System.out.print(count+" ");
            if(count > 4){
                // x need to be bigger
                x++;
            }else if(count < 4){
                // x need to be smaller
                x--;
            }else{
                ans = Math.max(ans, x);
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(cut(10,21));  //7
        System.out.println(cut(13,11));  //5
        System.out.println(cut(2,1));    //0
        System.out.println(cut(1,8));    //2
    }
}