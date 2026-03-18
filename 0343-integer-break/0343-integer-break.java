class Solution {
    int[] dp;
    public int integerBreak(int n) {
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(n,0);
    }

    public int dfs(int n, int sum){
        if(n==sum)return 1;
        if(sum>n)return 0;
        if(dp[sum]!=-1)return dp[sum];
        int prod = 1;
        int maxProd = 0;
        for(int i=1;i<n;i++){
            prod = i*dfs(n,sum+i);
            maxProd = Math.max(maxProd, prod);
        }
        return dp[sum]=maxProd;
    }

}