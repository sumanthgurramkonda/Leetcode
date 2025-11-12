class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,dfs(nums,i));
        }
        return max;
    }

    public int dfs(int[] nums, int index){
        if(index>=nums.length)return 0;
        if(dp[index]!=-1)return dp[index];
        int max = 0;
        for(int i=index+2;i<nums.length;i++){
            max = Math.max(max, dfs(nums,i));
        }
        return dp[index]=nums[index]+max;
    }
}
