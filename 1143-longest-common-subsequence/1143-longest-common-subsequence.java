class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int maxLen = 0;
        dp = new int[text1.length()][text2.length()];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        for(int index=0;index<text1.length();index++){
            maxLen = Math.max(maxLen, longestCommonSubsequence(text1,text2,index,0));
        }
        return maxLen;
    }

    public int longestCommonSubsequence(String text1, String text2, int text1Index, int text2Index){
        if(text2Index==text2.length() || text1.length()==text1Index) return 0;
        if(dp[text1Index][text2Index]!=-1)return dp[text1Index][text2Index];
        int maxLen = 0;
        if(text1.charAt(text1Index)==text2.charAt(text2Index)){
            maxLen = Math.max(maxLen, longestCommonSubsequence(text1, text2, text1Index+1,text2Index+1)+1);
        }else{
            maxLen = Math.max(maxLen, longestCommonSubsequence(text1, text2, text1Index+1,text2Index));
            maxLen = Math.max(maxLen, longestCommonSubsequence(text1, text2, text1Index,text2Index+1));
        }
        return dp[text1Index][text2Index] = maxLen;
    }
}