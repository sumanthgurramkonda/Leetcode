class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2];
        for(int[] arr : dp) Arrays.fill(arr,Integer.MAX_VALUE);
        return dfs(prices,0,0);
    }

    public int dfs(int[] prices, int index, int canSell){
        if(index>=prices.length)return 0;
        if(dp[index][canSell]!=Integer.MAX_VALUE)return dp[index][canSell];

        int idle = dfs(prices, index+1,canSell);
        int profit = 0;
        if(canSell==0){
            profit = -prices[index]+dfs(prices, index+1,1);
        }else{
            profit = prices[index]+dfs(prices, index+2,0);
        }
        return dp[index][canSell]=Math.max(profit,idle);
    }
}