class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())return false;
        Map<Character, Integer> charMap1 = new HashMap<>();
        Map<Character, Integer> charMap2 = new HashMap<>();

        for(char c  : word1.toCharArray()){
            charMap1.put(c, charMap1.getOrDefault(c,0)+1);
        }
        for(char c  : word2.toCharArray()){
            charMap2.put(c, charMap2.getOrDefault(c,0)+1);
        }
        if(charMap1.size()!=charMap2.size())return false;
    
        for(char c='a';c<='z';c++){
            if(charMap1.containsKey(c) && charMap2.containsKey(c)) continue;
            if(charMap1.containsKey(c) || charMap2.containsKey(c))return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(char c='a';c<='z';c++){
            if(charMap1.containsKey(c)){
                int count = charMap1.get(c);
                map.put(count, map.getOrDefault(count, 0)+1);
            }
        }
        for(char c='a';c<='z';c++){
            if(charMap2.containsKey(c)){
                int count = charMap2.get(c);
                if(map.containsKey(count)){
                    if(map.get(count)==1)map.remove(count);
                    else{
                        map.put(count,map.get(count)-1);
                    }
                }else {
                    return false;
                }
            }
        }

        return map.isEmpty();
    }
}

/*
aabbczz
abbczzz
*/



