// class Solution {
//     int[] dp;
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n==1)return nums[0];
//         dp = new int[n];
//         Arrays.fill(dp,-1);
//         int first = dfs(nums,0,n-1);
//         Arrays.fill(dp,-1);
//         int second = dfs(nums,1,n);
//         return Math.max(first,second);
//     }

//     public int dfs(int[] nums, int index, int n){
//         if(index>=n)return 0;
//         if(dp[index]!=-1)return dp[index];
//         int skip = nums[index]+dfs(nums,index+2,n);
//         int noSkip = dfs(nums, index+1,n);
//         return dp[index]=Math.max(skip, noSkip);
//     }

// }

class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        if(n==1)return nums[0];
        int max = dfs(nums,0,n-1);
        Arrays.fill(dp,-1);
        for(int i=1;i<n;i++){
            max = Math.max(max,dfs(nums,i,n));
        }
        return max;
    }

    public int dfs(int[] nums, int index, int n){
        if(index>=n)return 0;
        if(dp[index]!=-1)return dp[index];
        int max = 0;
        for(int i=index+2;i<n;i++){
            max = Math.max(max, dfs(nums,i,n));
        }
        return dp[index]=nums[index]+max;
    }
    
}