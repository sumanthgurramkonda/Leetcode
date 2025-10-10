class Solution {
    int[] dp;
    public int jump(int[] nums) {

        // dp = new int[nums.length];
        // Arrays.fill(dp,-1);
        // // return dfs(nums,dp,0);
        // int steps = dfs1(nums,0);
        // return steps == Integer.MAX_VALUE ? -1 : steps;
        return minJump(nums);
    }

    public int minJump(int[] nums){
        int steps = 0;
        int farthestStep = 0;
        int currentStep = 0;
        for(int i=0;i<nums.length-1;i++){
            farthestStep = Math.max(farthestStep, nums[i]+i);
            if(i==currentStep){
                currentStep = farthestStep;
                steps++;
            }
            if(currentStep>=nums.length-1)return steps;
        }
        return steps;
    }

    public int dfs1(int[] nums, int index){
        if(index>=nums.length) return Integer.MAX_VALUE;
        if(index==nums.length-1){
            return 0;
        }
        if(dp[index]!=-1)return dp[index];
        int minJumps = Integer.MAX_VALUE;
        for(int i=1;i<=nums[index];i++){
            int count = dfs1(nums,index+i);
            if(count==Integer.MAX_VALUE)continue;
            minJumps = Math.min(count+1,minJumps);
        }
        return dp[index]=minJumps;
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