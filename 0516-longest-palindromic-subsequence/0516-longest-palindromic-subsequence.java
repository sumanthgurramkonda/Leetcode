class Solution {
    int dp[][];
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        return dfs(s,0,n-1);
    }

    public int dfs(String s, int left, int right){
        if(left==right) return 1;
        if(left>right || left>=s.length() || right<0) return 0;
        if(dp[left][right]!=0)return dp[left][right];

        if(s.charAt(left)==s.charAt(right)){
            dp[left][right] = 2+dfs(s,left+1,right-1);
        }else{
            dp[left][right] = Math.max(dfs(s,left+1,right), dfs(s,left,right-1));
        }
        return dp[left][right];
    }
    
}