class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)return 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int len = s.length();
        int maxLen = 0;
        int left = 0;
        for(int i=0;i<len;i++){
            char c = s.charAt(i);
            if(charMap.containsKey(c)){
                int index = charMap.get(c);
                left = Math.max(left, index+1);
            }
            charMap.put(c,i);
            maxLen = Math.max(maxLen, i-left+1);
        }
        return maxLen;
    }
}
