class Solution {
    
    int[] dp = new int[10001];

    public int numSquares(int n) {
        if(n==0)return 0;
        if(n<0)return Integer.MAX_VALUE;
        if(dp[n]!=0)return dp[n];
        int minCount = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
           int count = numSquares(n-i*i);
           if(count!=Integer.MAX_VALUE) minCount = Math.min(minCount,count+1);
        }
        return dp[n]=minCount;
    }
}