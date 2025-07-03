class Solution {
    int[] dp;
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length+1];
        return lengthOfLIS1(nums);
    }

    public int lengthOfLIS1(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res = 1;
        for(int i=0;i<n-1;i++){
            int len = 0;
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    dp[j] = Math.max(dp[j],dp[i]+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}