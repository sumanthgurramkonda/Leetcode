class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return dfs(coins,0,amount);
    }

    public int dfs(int[] coins, int i, int amount){
        if(amount==0)return 1;
        if(amount<0 || i==coins.length)return 0;
        if(dp[i][amount]!=-1)return dp[i][amount];

        int consider = dfs(coins, i, amount-coins[i]);
        int noConsider = dfs(coins, i+1, amount);
        
        return dp[i][amount] = consider + noConsider;
    }

}