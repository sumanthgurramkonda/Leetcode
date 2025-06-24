class Solution {
    long res = 0;
    public long maxAlternatingSum(int[] nums) {
        // dp(nums,0,true,0);
        // return res;
        long[][]dp = new long[nums.length][2];
        return dp1(nums,0,true,dp);
    }


    private long dp1(int nums[], int index,boolean isEven,long[][]dp){
        if(index>=nums.length)return 0;

        if(dp[index][isEven?0:1]!=0) return dp[index][isEven?0:1];

        long total = isEven ? nums[index] : (-1*nums[index]);
        dp[index][isEven?0:1] = Math.max(total+dp1(nums,index+1,!isEven,dp),dp1(nums,index+1,isEven,dp));
        return dp[index][isEven?0:1];
    }

    private void dp(int nums[], int index,boolean isEven,long sum){
        
        res = Math.max(res,sum);
        if(index==nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            if(isEven){
                dp(nums,i+1,false,sum+nums[i]);
            }
            else {
                dp(nums,i+1,true,sum-nums[i]);
            }
        }
    }  
}