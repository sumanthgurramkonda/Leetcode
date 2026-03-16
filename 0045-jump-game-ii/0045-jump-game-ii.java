class Solution {
    int[] dp;
    public int jump(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return jump(nums,0);
    }

    public int jump(int[] nums, int index){
        if(index>= nums.length-1) return 0;
        if(dp[index]!=-1)return dp[index];
        int minSteps = Integer.MAX_VALUE;
        for(int i=index+1;i<=index+nums[index] && i<nums.length;i++){
            // if(nums[i]==0)continue;
            minSteps = Math.min(minSteps,jump(nums,i));
        }
        return dp[index] =  minSteps==Integer.MAX_VALUE ? Integer.MAX_VALUE : minSteps+1;
    }
}

