class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    //boolean isWord;
    Set<String> words = new TreeSet<>();
}
class Solution {
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>(); 
        TrieNode root = new TrieNode();
        Arrays.sort(products);

        for(String pro : products){
            TrieNode node = root;
            for(char ch : pro.toCharArray()){
                if(node.children.containsKey(ch)){
                    node = node.children.get(ch);
                    node.words.add(pro);
                }else{
                    TrieNode child = new TrieNode();
                    child.words.add(pro);
                    node.children.put(ch, child);
                    node = child;
                }
            }
            
        }
        TrieNode node = root;
        boolean notMatch = false;
        for(char ch : searchWord.toCharArray()){
            if(!notMatch && node.children.containsKey(ch)){
                node = node.children.get(ch);
                List<String> tmp = new ArrayList<>();
                List<String> words = new ArrayList<>(node.words);
                for(int i = 0; i < words.size() && i < 3; i++){
                    tmp.add(words.get(i));
                }
                ans.add(tmp);
            }else{
                ans.add(new ArrayList<String>());
                notMatch = true;
            }
        }
        return ans;
    }
}