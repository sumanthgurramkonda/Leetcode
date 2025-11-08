class Solution {
    static int[] dp = new int[45+1];
    static{
        Arrays.fill(dp,-1);
    }
    public int climbStairs(int n) {
        if(n==0)return 1;
        else if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n] = climbStairs(n-1)+climbStairs(n-2);
    }
}