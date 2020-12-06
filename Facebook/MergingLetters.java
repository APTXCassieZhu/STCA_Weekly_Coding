public class MergingLetters{
    // merge two string in their original order
    // "aaaaa" "bbb" -> "abababaa"
    public static String mergeString(String s, String t){
        if(s.length() < t.length()) return mergeString(t, s);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t.length(); i++){
            sb.append(s.charAt(i));
            sb.append(t.charAt(i));
        }
        if(s.length() > t.length())    sb.append(s.substring(t.length()));
        return sb.toString();
    }
    private static boolean Test(String a, String b){
        return a.equals(b);
    }
    public static void main(String[] agrs){
        System.out.println(Test(mergeString("aaaaa", "bbb"), "abababaa"));
        System.out.println(Test(mergeString("ab", "abcdef"), "aabbcdef"));
    }
}