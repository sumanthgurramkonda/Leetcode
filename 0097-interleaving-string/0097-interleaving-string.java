class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        dp = new int[n1+1][n2+1];
        if(n1+n2!=n3)return false;
        return dfs(s1,s2,s3,0,0,0);
    }

    public boolean dfs(String s1, String s2, String s3, int i, int j, int k){
        if(k==s3.length()) return true;
        if(i+j>k)return false;
        if(dp[i][j]!=0)return dp[i][j]==1;
        char c1 = '1';
        if(i<s1.length()) c1 = s1.charAt(i);
        char c2 = '1';
        if(j<s2.length()) c2 = s2.charAt(j);
        char c3 = s3.charAt(k);
        boolean considerS1 = false;
        boolean considerS2 = false;
        if(c1==c3)
            considerS1 = dfs(s1,s2,s3,i+1,j,k+1);
        if(c2==c3)
            considerS2 = dfs(s1,s2,s3,i,j+1,k+1);
        dp[i][j] = considerS1 || considerS2 ? 1 : -1;
        return considerS1 || considerS2;
    }


}

