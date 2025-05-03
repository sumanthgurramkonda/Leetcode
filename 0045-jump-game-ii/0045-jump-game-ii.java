class Solution {

    public int jump(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int minJump = minJumps(nums,0,dp);
        return minJump;
    }

    private int minJumps(int[] nums, int i, int[] dp) {
        if (i >= nums.length - 1) return 0; // No more jumps needed
        if (nums[i] == 0) return Integer.MAX_VALUE; // Can't jump from here
        if (dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= nums[i]; j++) {
            int next = minJumps(nums, i + j, dp);
            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + next);
            }
        }
        dp[i] = min;
        return dp[i];
    }
}



