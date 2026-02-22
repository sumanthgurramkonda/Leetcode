class Solution {
    String res ="";
    public String longestWord(String[] words) {

        Trie trie = new Trie();
        int max = 0;
        for(String word : words){
            trie.add(word);
        }
        
        dfs(trie, new StringBuilder());
        return res;
    }

    public void dfs(Trie node, StringBuilder path){

        if(path.length()>res.length() ||
           (path.length()==res.length() &&
            path.toString().compareTo(res)<0)){
                res = path.toString();
        }

        for(int i=0;i<26;i++){
            Trie child = node.trie[i];
            if(child!=null && child.isWord){
                path.append((char)('a'+i));
                dfs(child, path);
                path.deleteCharAt(path.length()-1);
            }
        }
        
    }

    public static class Trie{
        Trie[] trie = new Trie[26];
        boolean isWord = false;

        public void add(String word){
        
            Trie node = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(node.trie[ind]==null){
                    node.trie[ind] = new Trie();
                }
                node = node.trie[ind];
            }
            node.isWord = true;
        } 
    }
}




/*

1 og
2 ogz
3 ogzn
4 ogznk
5 ogznkb

*/

/*

1 e
2 ey
3 eyj

1 eyjuo
2 eyjuoi

*/