
class Trie {
    class Node{
        Node[] trie;
        boolean isWord;

        public Node(){
            this.trie = new Node[26];
            this.isWord = false;
        }
    }

    Node trieNode;

    public Trie() {
        trieNode = new Node();
    }
    
    public void insert(String word) {
        dfs(word,0,trieNode);
    }

    public void dfs(String word, int index, Node tr){
        if(index==word.length()){
            tr.isWord = true;
            return;
        }
        char c = word.charAt(index);
        if(tr.trie[c-'a']==null){
            tr.trie[c-'a'] = new Node();
        }
        dfs(word, index+1, tr.trie[c-'a']);
    }
    
    public boolean search(String word) {
        return searchWord(word,0,trieNode);
    }

    public boolean searchWord(String word, int index, Node tr){
        if(index==word.length()) return tr.isWord;
        char c = word.charAt(index);
        if(tr.trie[c-'a']==null)return false;
        return searchWord(word,index+1,tr.trie[c-'a']);
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(prefix,0,trieNode);
    }

    public boolean startsWith(String word, int index, Node tr){
        if(index==word.length()) return true;
        char c = word.charAt(index);
        if(tr.trie[c-'a']==null)return false;
        return startsWith(word,index+1,tr.trie[c-'a']);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */