class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int res = getCoinsCount(coins, amount);
        return res==Integer.MAX_VALUE ? -1 : res;
        // return minCoinsRequiredForSum(coins,amount);
    }

    public int getCoinsCount(int[] coins, int amount){
       if(amount==0){
        return 0;
       }
       if(amount<0)return Integer.MAX_VALUE;
       if(dp[amount]!=-1)return dp[amount];
       int minCoins = Integer.MAX_VALUE;
       for(int j=0;j<coins.length; j++){
          int ans = getCoinsCount(coins,amount-coins[j]);
          if(ans!=Integer.MAX_VALUE)minCoins = Math.min(minCoins, ans+1);
       }
       return dp[amount]=minCoins;
    }
    public int minCoinsRequiredForSum(int[] coins, int amount){
        // if(amount==0)return 0;
        // if(coins.length==1){
        //     if(coins[0]==amount)return 1;
        //     else return -1;
        // }
        Arrays.sort(coins);
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                int diff = i-coin;
                if(diff<0)break;
                min = Math.min(min,dp[diff]+1);
            }
            dp[i] = min;
        }
        return dp[amount]<Integer.MAX_VALUE ? dp[amount] : -1;
    }
}




