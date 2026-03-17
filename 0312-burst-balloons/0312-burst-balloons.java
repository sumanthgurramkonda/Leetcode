class Solution {
    int[][] memo;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        memo = new int[n+2][n+2];
        int[] newNums = new int[n+2];
        int index=1;
        for(int num : nums){
            if(num>0) newNums[index++]=num;
        }
        newNums[0]=newNums[index++]=1;
        return maxCoins(newNums,0,index-1);
    }

    public int maxCoins(int[] nums, int left, int right){
        // if(left>right)return 0;
        if(left==right)return nums[left];
        if(memo[left][right]>0)return memo[left][right];
        int maxSum = 0;

        for(int i=left+1;i<right;i++){
            int prod = nums[i]*nums[left]*nums[right];
            int sum = prod + maxCoins(nums, left,i) + maxCoins(nums, i,right);
            maxSum = Math.max(maxSum,sum);
        }

        return memo[left][right]=maxSum;
    }
}