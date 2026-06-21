class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int count = dfs(coins, amount);
        return count==Integer.MAX_VALUE ? -1 : count;
    }

    public int dfs(int[] coins, int amount){
        if(amount==0) return 0;
        if(amount<0)return Integer.MAX_VALUE;
        int minCount = Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];

        for(int i=0;i<coins.length;i++){
            // int count = Math.min(count, dfs(coins, amount-coins[i]));
            minCount = Math.min(minCount, dfs(coins, amount-coins[i]));
        }
        return dp[amount] = minCount==Integer.MAX_VALUE ? Integer.MAX_VALUE : minCount+1;
    }
}