class Solution {
    Set<String> visited = new HashSet();
    Map<String, List<String>> patternMap = new HashMap();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        buildWordListMap(beginWord, wordList);       
        return minLadderLength(beginWord,endWord,wordList);
    }  

    public int minLadderLength(String beginWord, String endWord,List<String> wordList){

        Queue<String> queue = new LinkedList();
        queue.offer(beginWord);
        Set<String> visited = new HashSet();
        int len = 1;
        while(!queue.isEmpty()){
           int size = queue.size();
           for(int i=0;i<size;i++){
               String begWord = queue.remove();
               if(visited.contains(begWord))continue;
               for(String word : getPatterList(begWord)){
                if(word.equals(endWord)) return len+1;
                queue.offer(word);
               }
               visited.add(begWord);
            }
            len+=1;
        }
        return 0;
    }

    public List<String> getPatterList(String word){
        List<String> wordList = new ArrayList();
        int n = word.length();
        for(int i=0;i<n;i++){
            String pattern = word.substring(0,i)+"*"+word.substring(i+1,n);
            List<String> list = patternMap.getOrDefault(pattern,new LinkedList());
            for(String w : list){
                if(!w.equals(word)){
                    wordList.add(w);
                }
            }
        }
        return wordList;
    }

    private void buildWordListMap(String beginWord,List<String> wordList){
        
        List<String> list = new LinkedList();
        list.add(beginWord);
        int n = beginWord.length();
        for(int i=0; i<n;i++){
            String str1 = beginWord.substring(0,i);
            String str2 = beginWord.substring(i+1,n);
            patternMap.put(str1+"*"+str2,list);
        }
        for(String word : wordList){
            for(int i=0; i<n;i++){
                String str1 = word.substring(0,i);
                String str2 = word.substring(i+1,n);
                String w = str1+"*"+str2;
                if(patternMap.containsKey(w)){
                    patternMap.get(w).add(word);
                }else{
                    list = new LinkedList();
                    list.add(word);
                    patternMap.put(w,list);
                }
            }
        }
    } 
}

