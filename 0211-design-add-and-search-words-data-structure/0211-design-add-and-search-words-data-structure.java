class WordDictionary {

    class Trie{
        Trie[] trie;
        boolean isWord;
        public Trie(){
            trie = new Trie[26];
            this.isWord = false;
        }

    }

    Trie trieNode;

    public WordDictionary() {
        trieNode = new Trie();
    }
    
    public void addWord(String word) {
        addWord(word,0,trieNode);
    }

    public void addWord(String word, int index, Trie tr){
        if(index==word.length()){
            tr.isWord = true;
            return;
        }
        char c = word.charAt(index);
        if(tr.trie[c-'a']==null){
            tr.trie[c-'a'] = new Trie();
        }
        addWord(word, index+1,tr.trie[c-'a']);
    }
    
    public boolean search(String word) {
        return search(word,0,trieNode);
    }

    public boolean search(String word, int index, Trie tr){
        if(index==word.length()) return tr.isWord;
        char c = word.charAt(index);
        if(c=='.'){
            for(int i=0;i<26;i++){
                if(tr.trie[i]!=null && search(word, index+1,tr.trie[i])){
                    return true;
                }
            }
            return false;
        }
        if(tr.trie[c-'a']==null){
            return false;
        }else {
            return search(word, index+1, tr.trie[c-'a']);
        }
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */