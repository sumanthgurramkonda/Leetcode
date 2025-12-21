class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : ransomNote.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        for(char c : magazine.toCharArray()){
            if(charMap.containsKey(c)){
                if(charMap.get(c)<=1){
                    charMap.remove(c);
                }else{
                    charMap.put(c, charMap.get(c)-1);
                }
            }
        }
        return charMap.isEmpty();
    }
}