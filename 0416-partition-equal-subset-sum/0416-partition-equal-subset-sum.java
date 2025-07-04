class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int n : nums)sum+=n;
        if(sum%2==1)return false;
        sum /=2;
        Boolean[][] dp = new Boolean[nums.length+1][sum+1];
        return canPartition(nums,0,sum,dp);
        // return canPartition(nums,sum);
    }

    public boolean canPartition(int[] nums, int index, int sum,Boolean[][] dp){
        if(sum==0)return true;
        if(sum<0 || index>=nums.length) return false;
        if(dp[index][sum]!=null)return (boolean)dp[index][sum];
        return dp[index][sum]= canPartition(nums,index+1,sum-nums[index],dp) || 
                               canPartition(nums,index+1,sum,dp);
    }

    public boolean canPartition(int[] nums,int sum){
        int len = nums.length;
        int length = (int)Math.pow(2,len-1)*len;
        if(length<0)length = len;
        List<Integer> list = new ArrayList(length);
        for(int n:nums){
            list.add(n);
            for(int i=0;i<list.size();i++){
                int num = list.get(i)+n;
                if(num==sum)return true;
                list.add(num);
            }
            
        }
        return false;
    }


}



