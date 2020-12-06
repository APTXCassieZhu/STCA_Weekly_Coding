class Node{
    char c;
    int count;
    Node(char c, int count){
        this.c = c;
        this.count = count;
    }
}
public class wordCompression{
    // aba 2 -> aba
    // baac 2 -> bc
    // abbcccb 3 -> a   【explain: abbcccb -> abbb -> a】
    public static String compressWord(String word, int k) {
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!stack.isEmpty() && c == stack.peek().c){
                stack.peek().count++;
            }else{
                stack.push(new Node(c, 1));
            }
            if(stack.peek().count == k) stack.pop();
        }
        for(Node cur : stack){
            while(cur.count-- > 0){
                sb.append(cur.c);
            }
        }
        return sb.toString();
    }
}