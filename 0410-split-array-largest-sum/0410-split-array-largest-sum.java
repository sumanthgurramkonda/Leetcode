class Solution {
    int[][] dp;
    public int splitArray(int[] nums, int k) {
        dp = new int[nums.length][k+1];
        for(int[] arr : dp) Arrays.fill(arr,-1);
        return dfs(nums,0,k);
    }


    public int dfs(int[]nums, int index, int k){
        if(index>=nums.length)return 0;
        if(k==1){
            int sum = 0;
            for(int i=index;i<nums.length;i++) sum += nums[i];
            return sum;
        }
        if(dp[index][k]!=-1)return dp[index][k];
        int maxSum = 0;
        int currentSum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=index;i<nums.length;i++){
            currentSum += nums[i];
            maxSum = Math.max(currentSum, dfs(nums,i+1,k-1));
            res = Math.min(res, maxSum);
        }
        return dp[index][k] = res;
    }

}

