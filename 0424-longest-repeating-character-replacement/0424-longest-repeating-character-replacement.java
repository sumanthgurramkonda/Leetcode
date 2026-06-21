class Solution {

    public int characterReplacement(String s, int k) {
        if(s==null || s.length()==0)return 0;
        int maxLen = 0;
        int len = s.length();
        int[] charCount = new int[126];
        int left = 0;
        int maxCount = 0;
        for(int right=0;right<len;right++){
            char c = s.charAt(right);
            maxCount = Math.max(maxCount,++charCount[c]);
            int currentLen = right-left+1;
            if(currentLen>maxCount+k){
                charCount[s.charAt(left)]--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }

}



