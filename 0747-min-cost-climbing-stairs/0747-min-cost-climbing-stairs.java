class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        // dp = new int[cost.length];
        // Arrays.fill(dp,-1);
        // return minCostClimbingStairs(cost,0);
        
        for(int i=2;i<cost.length;i++){
            cost[i]= cost[i]+Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[cost.length-2],cost[cost.length-1]);
    }

    public int minCostClimbingStairs(int[] cost, int i){
        if(i>=cost.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int one = cost[i]+minCostClimbingStairs(cost,i+1);
        int two = cost[i+1]+minCostClimbingStairs(cost,i+2);
        return dp[i]=Math.min(one,two);
    }
}