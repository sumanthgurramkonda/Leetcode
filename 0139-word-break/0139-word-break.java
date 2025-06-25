class Solution {
    Map<String, Boolean> dp = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0)return true;

        for(int i=0;i<wordDict.size();i++){
            String word = wordDict.get(i);
            if(s.equals(word))return true;
            if(word.length()>s.length())continue;
            if(dp.containsKey(s))return dp.get(s);
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()),wordDict)){
                    dp.put(s,true);
                    return true;
                }
            }
        }
        dp.put(s,false);
        return false;
    }

    // public boolean wordBreak1(String s, List<String> wordDict){

    //     for(int i=0;i<wordDict.size();i++){
    //         String word = wordDict.get(i);
    //         if(word.equals(s))return true;
    //         if(s.startsWith(word)){
    //             return wordBreak(s.substring(0,word.length()),wordDict);
    //         }
    //     }
    // }
}