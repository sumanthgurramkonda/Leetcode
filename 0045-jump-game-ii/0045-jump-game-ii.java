class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return dfs(nums,dp,0);
    }

    public int dfs(int[] nums, int[] dp, int index){
        if(index>=nums.length-1)return 0;
        if(nums[index]==0)return Integer.MAX_VALUE;
        if(dp[index]!=-1)return dp[index];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int jump = dfs(nums,dp,index+i);
            if(jump!=Integer.MAX_VALUE)min = Integer.min(jump+1, min);
        }
        return dp[index]=min;
    }
}