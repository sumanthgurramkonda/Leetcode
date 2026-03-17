class Solution {
    int total = 0;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        for(int num : nums)total+=num;

        dp = new Boolean[n][(total/2)+1];

        if(total%2==1)return false;
        return dfs(nums,0,0);
    }

    public boolean dfs(int[]nums, int index, int sum){
        if(index==nums.length)return false;
        if(total==(sum*2))return true;
        if((sum*2)>total) return false;
        if(dp[index][sum]!=null)return dp[index][sum];

        boolean skip = dfs(nums,index+1,sum);
        boolean include = dfs(nums,index+1,sum+nums[index]);

        return dp[index][sum]=skip||include;
    }

}