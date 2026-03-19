class Solution {
    int MODULE = 1000000007;
    long[][] dp;
    // long[]dp;
    public int countVowelPermutation(int n) {
        // dp = new long[n+1];
        // Arrays.fill(dp,-1);
        dp = new long[5][n+1];
        for(long[]arr : dp) Arrays.fill(arr,-1);
        long count = 0;
        for(int i=0;i<5;i++){
            count = (count+dfs(i,n-1))%MODULE;
        }
        return (int)count%MODULE;
    }

/*
a - 0
e - 1
i - 2
o - 3
u - 4
*/
    public long dfs(int character , int n){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[character][n]!=-1)return dp[character][n];
        // if(dp[n]!=-1)return dp[n];
        long count = 0;
        if(character==0){  // character a
        count = dfs(1, n-1)%MODULE;
        }else if(character==1){
            count = dfs(0,n-1)+dfs(2,n-1);
            count = count%MODULE;
        }else if(character==2){
            count = dfs(0,n-1)+dfs(1,n-1)+dfs(3,n-1)+dfs(4,n-1);
            count = count%MODULE;
        }else if(character==3){
            count = dfs(2,n-1)+dfs(4,n-1);
            count = count%MODULE;
        }else if(character==4){
            count = dfs(0,n-1);
            count = count%MODULE;
        }
        return dp[character][n]=count;
        // return dp[n]=count;
    }
}