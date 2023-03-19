class Node {
    Node links[] = new Node[26];
    boolean flag = false;
    Node() {
        
    }
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
    Node get(char ch ) {
        return links[ch - 'a'];
    }
}
class WordDictionary {
    public Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return searchHelper(root,word,0);
    }
    private boolean searchHelper(Node node,String word,int index) {
        if(index == word.length()) {
            return node.isEnd();
        }
        char ch = word.charAt(index);
        if(ch == '.') {
            for(Node child : node.links) {
               if(child != null && searchHelper(child,word,index+1)) {
                   return true;
               }
            }
            return false;
        } else {
            Node child = node.get(ch);
            if(child == null) {
                return false;
            }
            return searchHelper(child,word,index+1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */