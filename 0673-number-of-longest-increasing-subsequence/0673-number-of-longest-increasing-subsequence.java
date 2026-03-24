class Solution {
    int[][] dp;
    public int findNumberOfLIS(int[] nums) {
        dp = new int[nums.length][];
        
        int maxLen = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int[] height = dfs(nums, i);
            if(height[0]>maxLen){
                maxLen = height[0];
                count = height[1];
            }else if(height[0]==maxLen){
                count+=height[1];
            }
        }
        
        return count;
    }

    public int[] dfs(int[] nums, int index){
        // if(index==nums.length)return new int[]{0,0};
        int maxLen = 0;
        int count = 1;
        if(dp[index]!=null)return dp[index];
        for(int i=index+1;i<nums.length;i++){
            if(nums[i]>nums[index]){
                int[] height = dfs(nums, i);
                if(height[0]>maxLen){
                    maxLen = height[0];
                    count = height[1];
                }else if(height[0]==maxLen){
                    count+=height[1];
                }
            }
        }
        return dp[index]=new int[]{maxLen+1,count};
    }
}

