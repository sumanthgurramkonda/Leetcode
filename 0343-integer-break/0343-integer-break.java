class Solution {
    int[] dp;
    public int integerBreak(int n) {
       dp=new int[n+1];
       return integerBreak2(n,0);
    }

    public int integerBreak1(int n){
        if(n<=1)return 1;
        if(dp[n]!=0)return dp[n];
        int product = 1;
        for(int i=1;i<n;i++){
          product = Math.max(product,integerBreak1(n-i)*i);
        }
        return dp[n]=product;
    }

    public int integerBreak2(int n, int sum){
        if(sum==n) return 1;
        if(sum>n)return 0;
        if(dp[sum]!=0)return dp[sum];
        int product = 1;
        for(int i=2;i<n;i++){
            product = Math.max(product,integerBreak2(n,sum+i)*i);
        }
        return dp[sum]=product;
    }
}