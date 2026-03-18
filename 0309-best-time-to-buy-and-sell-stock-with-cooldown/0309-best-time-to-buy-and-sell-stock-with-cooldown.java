class Solution {
    int[] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length];
        // for(int[] arr : dp)
            Arrays.fill(dp,Integer.MAX_VALUE);
        return dfs(prices,0);
    }

    public int dfs(int[] prices, int index){
        int maxProfit = 0;
        if(index>=prices.length)return 0;
        if(dp[index]!=Integer.MAX_VALUE)return dp[index];
        for(int i=index+1;i<prices.length;i++){
            int hold = dfs(prices,i);
            int sell = dfs(prices,i+2)+prices[i]-prices[index];
            maxProfit = Math.max(maxProfit,Math.max(hold, sell));
        }
        return dp[index]=maxProfit;
    }
}