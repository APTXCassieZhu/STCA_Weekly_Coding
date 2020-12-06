public class WorkingButtons{
    static String[] arr = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // 手机按键坏了 
    // [2,3] words = ["abc","gdef"] -> [true, false]
    // Only 2, 3 still working on the phone, so only abcdef can be typed. It possible to type the first word, but not second   
    public static boolean[] workingButtons(int[] digits, String[] words){
        StringBuilder possibleLetters = new StringBuilder();
        for(int button : digits){
            possibleLetters.append(arr[button]);
        }
        String possible = possibleLetters.toString();
        boolean[] ans = new boolean[words.length];
        for(int j = 0; j < words.length; j++){
            ans[j] = true;
            for(int i = 0; i < words[j].length(); i++){
                if(possible.indexOf(words[j].charAt(i)) == -1){
                    ans[j] = false;
                    break;
                }
            }
        }
        return ans;
    }

    public static boolean test(boolean[] a, boolean[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i])    return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(test(workingButtons(new int[]{2, 3}, new String[]{"abc", "gdef"}), new boolean[]{true, false}));
        System.out.println(test(workingButtons(new int[]{0,1,2,3,4,5,6,7,8,9}, new String[]{"abc", "gdef", "x"}), new boolean[]{true, true, true}));
    }
}