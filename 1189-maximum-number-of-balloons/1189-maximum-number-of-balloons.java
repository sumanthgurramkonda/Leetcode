class Solution {
    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : text.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0)+1);
        }
        int l = charMap.getOrDefault('l',0);
        int o = charMap.getOrDefault('o',0);
        if(l==0 || o==0) return 0;
        l/=2;
        o/=2;
        charMap.put('l',l);
        charMap.put('o',o);
        int min = Integer.MAX_VALUE;
        for(char c : "balon".toCharArray()){
            min = Math.min(min,charMap.getOrDefault(c,0));
        }
        return min;
    }
}