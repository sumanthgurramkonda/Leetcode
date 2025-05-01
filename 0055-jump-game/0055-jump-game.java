class Solution {
    int maxJump=0;
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        // return jump(nums,0,dp);
        for(int i=0;i<nums.length;i++){
            if(maxJump>=nums.length-1)return true;
            if(i==maxJump && nums[i]==0)return false;
            maxJump = Math.max(maxJump,i+nums[i]);
        }
        return maxJump>=nums.length-1;
    }

    public boolean jump(int[] nums, int i,boolean[] dp){
        if(maxJump>=nums.length-1)return true;
        else if(i>=nums.length)return false;
        if(dp[i])return true;
        maxJump = Math.max(maxJump,i+nums[i]);
        dp[i] = jump(nums,i+1,dp);
        return dp[i];
    }
}