class Solution {
    
    public int numSquares(int n) {
        if(isPerfectSquare(n))return 1;
        if(n<4)return n;
        int size = 0;
        for(int i=n-1;i>0;i--){
            if(isPerfectSquare(i)){
                size++;
            }
        }
        int[] nums = new int[size];
        int j=0;
        for(int i=n-1;i>0;i--){
            if(isPerfectSquare(i)){
                nums[j]=i;
                j++;
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return square(n,nums,0,dp)-1;
    }

    public int square(int n,int[] nums,int count,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        dp[n]=count;
        int min = Integer.MAX_VALUE;
        for(int j=0;j<nums.length;j++){
           int c = square(n-nums[j],nums,count+1,dp);
           if(c!=0){
            min = Math.min(c,min);
           }
        }
        return dp[n] = (min!=Integer.MAX_VALUE ? min+1 : 0);
    }

    public boolean isPerfectSquare(int n){
        double num = Math.sqrt(n);
        return Math.floor(num)==Math.ceil(num);
    }
}

