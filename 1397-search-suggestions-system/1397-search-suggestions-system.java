class Solution {
    class Trie{
        Trie[] trie;
        boolean isWord;
        public Trie(){
            this.trie = new Trie[26];
            this.isWord = false;
        }
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trieNode = new Trie();
        for(String product : products){
            add(product,0, trieNode);
        }
        StringBuilder product = new StringBuilder();
        List<List<String>> productList = new ArrayList();
       
        for(int i=0;i<searchWord.length();i++){
            product.append(searchWord.charAt(i));
            List<String> list = new LinkedList();
            findWords(product.toString(),0,trieNode,new StringBuilder(),list);
            productList.add(list);
        }
        return productList;
    }

    public void add(String word, int index, Trie tr){
        if(index==word.length()){
            tr.isWord = true;
            return;
        }
        char c = word.charAt(index);
        if(tr.trie[c-'a']==null){
            tr.trie[c-'a'] = new Trie();
        }
        add(word, index+1, tr.trie[c-'a']);
    }

    public void findWords(String word, int index, Trie tr,StringBuilder str, List<String> wordList){
        if(wordList.size()>=3) return;
        if(tr.isWord && index>=word.length()){
                wordList.add(str.toString());
             }
        if(index<word.length()){
            char c = word.charAt(index);
            str.append(c);
            if(tr.trie[c-'a']==null){
                return;
            }
            findWords(word,index+1,tr.trie[c-'a'],str,wordList);
        }else{
            for(char c='a';c<='z';c++){
                if(tr.trie[c-'a']!=null){
                    str.append(c);
                    findWords(word,index+1,tr.trie[c-'a'],str,wordList);
                    str.deleteCharAt(str.length() - 1);
                }
            }
        }

        


    }
}