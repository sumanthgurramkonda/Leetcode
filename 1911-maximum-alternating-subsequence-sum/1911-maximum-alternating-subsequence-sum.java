class Solution {
    long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        dp = new long[n][2];
        for(long[] arr : dp)Arrays.fill(arr,-1);
        return dfs(nums,0, 1);
    }

    public long dfs(int[]nums, int index, int isEven){
        if(index>=nums.length)return 0;
        if(dp[index][isEven]!=-1)return dp[index][isEven];
    
        long skip = dfs(nums,index+1,isEven);
        long include = dfs(nums, index+1,1-isEven);
        long total = Math.max(skip,include+(isEven==1 ? nums[index] : -nums[index]));
        return dp[index][isEven]=total;
    }
}




